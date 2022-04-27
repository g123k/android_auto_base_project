package com.example.androidauto.network.model

data class IdfElevators (
    val response: Response,
    val error: Any? = null
)

data class Response (
    val elevators: List<Elevator>
)

data class Elevator (
    val id: String,
    val name: String,
    val coordinates: Coordinates,
    val location: String,
    val direction: String,
    val lastUpdate: Long,
    val status: Status,
    val reason: Any? = null
)

data class Coordinates (
    val latitude: Double,
    val longitude: Double
)

enum class Status(val value: String) {
    Available("available"),
    Unavailable("unavailable"),
    Unknown("unknown");

    companion object {
        public fun fromValue(value: String): Status = when (value) {
            "available"   -> Available
            "unavailable" -> Unavailable
            "unknown"     -> Unknown
            else          -> throw IllegalArgumentException()
        }
    }
}