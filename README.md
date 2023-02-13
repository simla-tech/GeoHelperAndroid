## GeoHelper - Android SDK

Kotlin [GeoHelper service](http://geohelper.info/) client for Android platform.

### Dependencies

* OkHttp
* Reprofit
* Moshi

### Getting Started

Getting started is easy. Just add the following dependency to your app's module `build.gradle` file:

```
dependencies {
  implementation "com.simla.android:geohelper:1.0"
}
```

Then you just need to create a new instance of GeoHelper and run your query:

```
// create configuration
val geoHelperConfig =
    GeoHelperConfig.Builder(apiKey = "MY_API_KEY")

        // you can specify locale[lang] and locale[fallbackLang] api params here
        // these params will be used automatically in all requests if not specified otherwise
        .defaultLocale(LocaleParam.Builder("en").fallbackLang("kz").build()) // optional

        // GeoHelper Android SDK uses okHttp for network communication.
        // okHttp client is created automatically, but you can also provide your own http client instance
        .httpClient(httpClient) // optional

        .build()

// create helper instance
val geoHelper = GeoHelper(geoHelperConfig)

// run query from kotlin courotine context
runBlocking {
    try {
        geoHelper.api.countries()
    } catch (e: GeoHelperException) {
        // catch HTTP and API errors here
    }

```

#### Interceptor

Interceptor will be added to okHttp client under the hood, that will add `apiKey`, `locale[lang]` and `locale[fallbackLang]` parameters to the query automatically. Interceptor also wraps all errors and delivers them as an instance of `GeoHelperException`.

#### Api parameters

Api parameters can be provided via simple input classes with Builder-pattern. Parameter names in those builders follow parameter names in api [documentation](http://geohelper.info/ru/doc/api/). All input classes can be found in

```
com.simla.geohelper.model.params.*
```
