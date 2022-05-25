package src.main.kotlin.domain

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
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
        //get() = (TimeUnit.MILLISECONDS.toMinutes(Math.abs(Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis)))
        //get() = TimeUnit.MINUTES.convert(Math.abs(Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis), TimeUnit.MILLISECONDS)
        get() = vehicle.checkInTime.until(LocalDateTime.now(), ChronoUnit.MINUTES)


    /**
     * Ejercicio 7.1, 7.2 y 7.3
     */
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit): Unit {
        var foundVehicle: Vehicle? = parking.vehicles.find { it.hashCode() == plate.hashCode() }
        foundVehicle?.let {
            parking.vehicles.remove(foundVehicle)
            foundVehicle.discountCard?.let {
                onSuccess(calculateFee(foundVehicle.type, this.parkedTime, true)) } ?:
                run { onSuccess(calculateFee(foundVehicle.type, this.parkedTime, false))} } ?:
                run { onError() }
    }

    /**
     * Ejercicio 8.1, 8.2, 9.1 y 9.2
     * Correccion -> valores long de 2 horas y 15 minutos para calcular el fee
     */
    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        var subFee: Long = 0
        var totalFee: Int = 0
        val twoHours: Long = 120
        val fifteenMinutes: Long = 15

        when{
            parkedTime <= twoHours -> subFee = type.fee.toLong()
            parkedTime > twoHours -> subFee = type.fee + ((parkedTime - twoHours)/fifteenMinutes) * 5
        }
        if(hasDiscountCard) totalFee = (subFee * 0.85).toInt() else totalFee = subFee.toInt()
        parking.cumulativeGains = Pair(parking.cumulativeGains.first + 1, parking.cumulativeGains.second + totalFee)

        return totalFee
    }
}