package src.main.kotlin.domain

import java.util.Calendar

data class ParkingSpace (var vehicle : Vehicle, val parking: Parking) {
    /**
     * Ejercicio 4.1: Se agrega propiedad parkedTime en ParkingSpace para calcular el tiempo total de
     * estadia del vehiculo en el parking.
     */
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    /**
     * Ejercicio 7.1, 7.2 y 7.3
     */
    fun checkOutVehicle(plate: String): Unit {
        var foundVehicle: Vehicle? = parking.vehicles.find { it.hashCode() == plate.hashCode() }
        foundVehicle?.let { foundVehicle.discountCard?.let { onSuccess(calculateFee(foundVehicle.type, this.parkedTime, true)) } ?:
        run { onSuccess(calculateFee(foundVehicle.type, this.parkedTime, false))} } ?: run { onError() }
    }

    fun onSuccess(fee: Int): Unit {
        println("Your fee is $fee . Come back soon.")
    }

    fun onError(): Unit {
        println("Se ejecuto onError")
    }

    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        var subFee: Long = 0L
        when{
            parkedTime <= 120 -> subFee = type.fee.toLong()
            parkedTime > 120 -> subFee = type.fee + ((parkedTime - 120)/15) * 5
        }
        if(hasDiscountCard) return (subFee * 0.85).toInt() else return subFee.toInt()
    }
}