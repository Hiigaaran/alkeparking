package src.main.kotlin.domain

import java.util.Calendar
import java.util.concurrent.TimeUnit

/**
 * Challenge kotlin
 * @since 23-05-2022
 * @author Diana Cerda
 * @author Simon Morales
 */
data class ParkingSpace (var vehicle : Vehicle, val parking: Parking) {
    /**
     * Ejercicio 4.1: Se agrega propiedad parkedTime en ParkingSpace para calcular el tiempo total de
     * estadia del vehiculo en el parking.
     */
    val parkedTime: Long
        get() = (TimeUnit.MILLISECONDS.toMinutes(Math.abs(Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis)))


    /**
     * Ejercicio 7.1, 7.2 y 7.3
     */
    fun checkOutVehicle(plate: String): Unit {
        var foundVehicle: Vehicle? = parking.vehicles.find { it.hashCode() == plate.hashCode() }
        foundVehicle?.let {
            parking.vehicles.remove(foundVehicle)
            foundVehicle.discountCard?.let {
                onSuccess(calculateFee(foundVehicle.type, this.parkedTime, true)) } ?:
                run { onSuccess(calculateFee(foundVehicle.type, this.parkedTime, false))} } ?:
                run { onError() }
    }

    /**
     * Ejercicio 10.1
     */
    fun onSuccess(fee: Int): Unit {
        println("Your fee is $$fee . Come back soon.")
    }

    fun onError(): Unit {
        println("Se ejecuto onError")
    }

    /**
     * Ejercicio 8.1, 8.2, 9.1 y 9.2
     */
    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        var subFee: Long = 0
        var totalFee: Int = 0
        when{
            parkedTime <= 120 -> subFee = type.fee.toLong()
            parkedTime > 120 -> subFee = type.fee + ((parkedTime - 120)/15) * 5
        }
        if(hasDiscountCard) totalFee = (subFee * 0.85).toInt() else totalFee = subFee.toInt()
        parking.cumulativeGains = Pair(parking.cumulativeGains.first + 1, parking.cumulativeGains.second + totalFee)

        return totalFee
    }
}