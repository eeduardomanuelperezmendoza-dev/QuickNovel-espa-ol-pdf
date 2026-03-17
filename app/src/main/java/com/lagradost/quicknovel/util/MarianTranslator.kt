// MarianTranslator.kt

package com.lagradost.quicknovel.util

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Body
import retrofit2.http.POST

@JsonClass(generateAdapter = true)
data class TranslationRequest(
    @Json(name = "text") val text: String,
    @Json(name = "source_lang") val sourceLang: String,
    @Json(name = "target_lang") val targetLang: String
)

@JsonClass(generateAdapter = true)
data class TranslationResponse(
    @Json(name = "translatedText") val translatedText: String
)

interface MarianNMTService {
    @POST("nmt/translate")
    suspend fun translateText(@Body request: TranslationRequest): TranslationResponse
}

class MarianTranslator(private val service: MarianNMTService) {
    suspend fun translate(text: String, targetLang: String, sourceLang: String = "en"): String {
        val request = TranslationRequest(text, sourceLang, targetLang)
        val response = service.translateText(request)
        return response.translatedText
    }
}