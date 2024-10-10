package com.example.busapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.busapp.models.TransitRoutesResponse
import com.example.busapp.places.PlacesRepository
import com.example.busapp.routes.RoutesRepository
import com.google.android.libraries.places.api.model.AutocompletePrediction
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class RouteFinderViewModel(
    private val placesRepository: PlacesRepository,
    private val routesRepository: RoutesRepository
) : ViewModel() {
    var startLocation by mutableStateOf("")
        private set

    var destination by mutableStateOf("")
        private set

    var travelTimeOption by mutableStateOf("Leave by")
        private set

    var calendar: Calendar by mutableStateOf(Calendar.getInstance())
        private set

    var transitRoutes: TransitRoutesResponse by mutableStateOf(TransitRoutesResponse(emptyList()))

    fun updateStartLocation(newStartLocation : String) {
        startLocation = newStartLocation
    }

    fun updateDestination(newDestination : String) {
        destination = newDestination
    }

    fun findAutocompletePredictions(newQuery: String, onResult: (List<AutocompletePrediction>) -> Unit) {
        if (newQuery.length > 2) {
            placesRepository.findAutocompletePredictions(newQuery, onResult)
        } else {
            onResult(emptyList())
        }
    }

    fun updateTravelTimeOption(newTravelTimeOption : String) {
        travelTimeOption = newTravelTimeOption
    }

    fun updateCalendar(newCalendar: Calendar) {
        calendar = newCalendar
    }

    fun getRoutes(): TransitRoutesResponse {
        return routesRepository.getRoutes(startLocation, destination, timeToZuluFormat())
    }

    private fun timeToZuluFormat(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        return formatter.format(calendar.time)
    }

    fun resetValues() {
        startLocation = ""
        destination = ""
        calendar = Calendar.getInstance()
    }
}