package jp.cordea.nytbestsellers

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.takeFrom

internal class ApiClient(private val token: String) {
    companion object {
        private const val BASE_URL = "https://api.nytimes.com/"
        private const val BASE_PATH = "svc/books/v3"
        private const val GET_LISTS_PATH = "$BASE_PATH/lists.json"
        private const val GET_LIST_NAMES_PATH = "$BASE_PATH/lists/names.json"
    }

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = CustomJsonSerializer(
                KotlinxSerializer().apply {
                    setMapper(ListNamesResponse::class, ListNamesResponse.serializer())
                }
            )
        }
        defaultRequest {
            accept(ContentType.Application.Json)
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getLists(): ListsResponse = client.get {
        buildApiUrl(GET_LISTS_PATH)
    }

    suspend fun getListNames(): ListNamesResponse = client.get {
        buildApiUrl(GET_LIST_NAMES_PATH)
    }

    private fun HttpRequestBuilder.buildApiUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            encodedPath = path
            parameter("api-key", token)
        }
    }
}
