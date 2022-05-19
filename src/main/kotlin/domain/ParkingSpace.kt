package src.main.kotlin.domain

import java.util.Calendar

data class ParkingSpace (var vehicle : Vehicle) {
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS
}