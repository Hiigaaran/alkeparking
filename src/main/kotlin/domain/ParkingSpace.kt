package src.main.kotlin.domain

import java.util.Calendar

data class ParkingSpace (var vehicle : Vehicle) {
    /**
     * Ejercicio 4.1: Se agrega propiedad parkedTime en ParkingSpace para calcular el tiempo total de
     * estadia del vehiculo en el parking.
     */
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS
}