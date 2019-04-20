package jp.cordea.nytbestsellers

import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.content.OutgoingContent

class CustomJsonSerializer(
    private val serializer: KotlinxSerializer = KotlinxSerializer()
) : JsonSerializer by serializer {
    override fun write(data: Any): OutgoingContent {
        if (data is OutgoingContent) {
            return data
        }
        return serializer.write(data)
    }
}
