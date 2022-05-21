import src.main.kotlin.domain.Parking
import src.main.kotlin.domain.ParkingSpace
import src.main.kotlin.domain.Vehicle
import src.main.kotlin.domain.VehicleType
import java.util.Calendar

fun main() {
    /***
     * Ejercicio 1: ¿Por que se define vehicles como un set?
     * RE: El que sea definido como set nos permite mediante el uso de hashcode validar rapidamente
     *     y evitar ingresar vehiculos repetidos, ademas, el orden de los items no es importante.
     *
     * Ejercicio 2:
     */
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto = Vehicle("8222BBB", VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus = Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")
    val car2 = Vehicle("DD444DD", VehicleType.CAR, Calendar.getInstance(), null)

    val parking = Parking(mutableSetOf(car, moto, minibus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))

    val isCar2Parked = parking.vehicles.add(car2)
    println(isCar2Parked)


}