package com.example.demo.exercises

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.HttpURLConnection
import java.net.URI
import java.io.BufferedReader
import java.io.InputStreamReader

@RestController
class RestClientExcercise {
    val url = "http://worldclockapi.com/api/json/utc/now"

    fun worldClock(): String {
        val uri = URI(url)
        val connection = uri.toURL().openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val jsonResponse = reader.readText()
            reader.close()
            return jsonResponse
        }

        return ""
    }

    @GetMapping()
    fun getCurrentDateTime(): String {
        val resWorldClock = worldClock()

        if (resWorldClock.isNotEmpty()) {
            val currentFileTimeIndex = resWorldClock.indexOf("\"currentDateTime\":")
            if (currentFileTimeIndex != -1) {
                val startIndex = currentFileTimeIndex + "\"currentDateTime\":".length
                val endIndex = resWorldClock.indexOf(",", startIndex)
                val currentFileTimeString = resWorldClock.substring(startIndex, endIndex)
                return currentFileTimeString
            }
        }
        return "Error: Service Unavailable"
    }
}