@file:OptIn(ExperimentalSerializationApi::class)

package http

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.js.Date

@Serializer(forClass = Date::class)
class DateSerializer: KSerializer<Date> {
    override fun deserialize(decoder: Decoder): Date =
        Date(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Date) =
        encoder.encodeString(value.toISOString())
}
