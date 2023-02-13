package com.simla.geohelper

import com.simla.geohelper.api.GeoHelperApi
import com.simla.geohelper.data.GeoHelperException
import com.simla.geohelper.model.params.LocaleParam
import com.simla.geohelper.model.params.PaginationParam
import com.simla.geohelper.model.params.filter.*
import com.simla.geohelper.model.response.BaseResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class ApiUnitTest {

    private lateinit var geoHelper: GeoHelper
    private lateinit var geoHelperNoApiKey: GeoHelper
    private lateinit var geoHelperBadLocale: GeoHelper

    @Before
    fun init() {
        geoHelper = GeoHelper(
            GeoHelperConfig.Builder(TEST_API_KEY)
                .build()
        )
        geoHelperNoApiKey = GeoHelper(
            GeoHelperConfig.Builder("-")
                .build()
        )
        geoHelperBadLocale = GeoHelper(
            GeoHelperConfig.Builder(TEST_API_KEY)
                .defaultLocale(
                    LocaleParam.Builder("-").fallbackLang("-").build()
                )
                .build()
        )
    }

    @Test
    fun countries() = runBlocking {
        runTestsForEndPoint{
            countries(
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun regions() = runBlocking {
        runTestsForEndPoint{
            regions(
                filter = RegionsFilterParam.Builder()
                    .externalIds(
                        mapOf(
                            "fias" to "d8327a56-80de-4df2-815c-4f6ab1224c50",
                            "fias" to "5c48611f-5de6-4771-9695-7e36a4e7529d"
                        )
                    )
                    .ids(listOf("26"))
                    .build()
            )
        }
        runTestsForEndPoint{
            regions(
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun cities() = runBlocking {
        runTestsForEndPoint{
            cities(
                filter = CitiesFilterParam.Builder()
                    .externalIds(
                        mapOf(
                            "fias" to "d8327a56-80de-4df2-815c-4f6ab1224c50",
                            "fias" to "5c48611f-5de6-4771-9695-7e36a4e7529d"
                        )
                    )
                    .ids(listOf("26"))
                    .build()
            )
        }
        runTestsForEndPoint{
            cities(
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun districts() = runBlocking {
        runTestsForEndPoint{
            districts(
                filter = DistrictsFilterParam.Builder()
                    .externalIds(
                        mapOf(
                            "fias" to "d8327a56-80de-4df2-815c-4f6ab1224c50",
                            "fias" to "5c48611f-5de6-4771-9695-7e36a4e7529d"
                        )
                    )
                    .ids(listOf("26"))
                    .build()
            )
        }
        runTestsForEndPoint{
            districts(
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun streets() = runBlocking {
        runTestsForEndPoint{
            streets(
                filter = StreetsFilterParam.Builder()
                    .cityId("1")
                    .externalIds(
                        mapOf(
                            "fias" to "d8327a56-80de-4df2-815c-4f6ab1224c50",
                            "fias" to "5c48611f-5de6-4771-9695-7e36a4e7529d"
                        )
                    )
                    .ids(listOf("26"))
                    .build()
            )
        }
        runTestsForEndPoint{
            streets(
                filter= StreetsFilterParam.Builder().cityId("1").build(),
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun postCode() = runBlocking {
        runTestsForEndPoint{
            postCode(filter = PostCodeFilterParam.Builder()
                .cityId("277158")
                .build()
            )
        }
    }

    @Test
    fun serviceLocality() = runBlocking {
        runTestsForEndPoint{
            serviceLocality(
                filter = ServiceLocalityFilterParam.Builder().service("abc").build(),
                pagination = PaginationParam.Builder().limit(100).build()
            )
        }
    }

    @Test
    fun phoneData() = runBlocking {
        runTestsForEndPoint{
            phoneData(filter = PhoneDataFilterParam("111222333444"))
        }
    }

    private suspend fun runTestsForEndPoint(endpointCallback: suspend GeoHelperApi.() -> BaseResponse) {
        val response = endpointCallback(geoHelper.api)
        assertTrue(response.success)
        assertTrue(
            response.language == LocaleParam.DEFAULT.lang ||
                    response.language == LocaleParam.DEFAULT.fallbackLang
        )
        assertFailsWith(GeoHelperException.InvalidApiKey::class) {
            endpointCallback(geoHelperNoApiKey.api)
        }
        assertFailsWith(GeoHelperException.BadRequest::class) {
            endpointCallback(geoHelperBadLocale.api)
        }
    }

    companion object {
        const val TEST_API_KEY = "TpUN9HmsxxhDutK6hwwpSeWWDjsG294F"
    }
}