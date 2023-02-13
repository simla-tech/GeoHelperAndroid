package com.simla.geohelper.api

import com.simla.geohelper.model.params.ApiKeyParam
import com.simla.geohelper.model.params.LocaleParam
import com.simla.geohelper.model.params.OrderParam
import com.simla.geohelper.model.params.PaginationParam
import com.simla.geohelper.model.params.filter.*
import com.simla.geohelper.model.response.*
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GeoHelperApi {

    @GET("countries")
    suspend fun countries(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: CountriesFilterParam = CountriesFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): CountriesResponse

    @GET("regions")
    suspend fun regions(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: RegionsFilterParam = RegionsFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): RegionsResponse

    @GET("cities")
    suspend fun cities(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: CitiesFilterParam = CitiesFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): CitiesResponse

    @GET("districts")
    suspend fun districts(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: DistrictsFilterParam = DistrictsFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): DistrictsResponse

    @GET("streets")
    suspend fun streets(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: StreetsFilterParam = StreetsFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): StreetsResponse

    @GET("post-code")
    suspend fun postCode(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: PostCodeFilterParam = PostCodeFilterParam.EMPTY
    ): PostCodeResponse

    @GET("service-locality")
    suspend fun serviceLocality(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: ServiceLocalityFilterParam = ServiceLocalityFilterParam.EMPTY,
        @QueryMap order: OrderParam = OrderParam.DEFAULT,
        @QueryMap pagination: PaginationParam = PaginationParam.EMPTY
    ): ServiceLocalityResponse

    @GET("phone-data")
    suspend fun phoneData(
        @QueryMap apiKey: ApiKeyParam = ApiKeyParam.EMPTY,
        @QueryMap locale: LocaleParam = LocaleParam.DEFAULT,
        @QueryMap filter: PhoneDataFilterParam = PhoneDataFilterParam.EMPTY
    ): PhoneDataResponse

    companion object {
        const val BASE_URL = "http://geohelper.info/api/v1/"
    }
}