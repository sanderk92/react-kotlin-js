package http

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json
import org.w3c.fetch.RequestInit
import org.w3c.fetch.Response

class HttpClient {

    suspend fun <T> getForEntity(
        url: String,
        deserializer: DeserializationStrategy<T>,
        onError: (String) -> T,
    ): T {
        val response = get(url)
        return if (response.ok) {
            parse(stringBodyFrom(response), deserializer, onError)
        } else {
            onError("GET request to $url failed: ${response.status}: ${response.statusText}")
        }
    }

    private suspend fun get(url: String): Response =
        window
            .fetch(url, RequestInit("GET"))
            .await()

    private suspend fun stringBodyFrom(response: Response): String =
        response
            .text()
            .await()

    private fun <T> parse(
        json: String,
        deserializer:
        DeserializationStrategy<T>,
        onError: (String) -> T
    ): T =
        try {
            Json.decodeFromString(deserializer, json)
        } catch (t: Throwable) {
            onError("Parsing failed for reason \"${t.message}\"")
        }
}
