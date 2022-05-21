import src.main.kotlin.domain.Parking
import src.main.kotlin.domain.ParkingSpace
import src.main.kotlin.domain.Vehicle
import src.main.kotlin.domain.VehicleType
import java.nio.charset.Charset
import java.util.Calendar
import java.util.Random

fun main() {
    /***
     * Ejercicio 1: ¿Por que se define vehicles como un set?
     * RE: El que sea definido como set nos permite mediante el uso de hashcode validar rapidamente
     *     y evitar ingresar vehiculos repetidos, ademas, el orden de los items no es importante.
     *
     * Ejercicio 2:
     */
    val car = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto = Vehicle(plateGenerator(), VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus = Vehicle(plateGenerator(), VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus = Vehicle(plateGenerator(), VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")
    val car2 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), null)
    val car1 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto1 = Vehicle(plateGenerator(), VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus1 = Vehicle(plateGenerator(), VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus1 = Vehicle(plateGenerator(), VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")
    val car3 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), null)
    val car5 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto2 = Vehicle(plateGenerator(), VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus2 = Vehicle(plateGenerator(), VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus2 = Vehicle(plateGenerator(), VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")
    val car4 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), null)
    val car7 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto3 = Vehicle(plateGenerator(), VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus3 = Vehicle(plateGenerator(), VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus3 = Vehicle(plateGenerator(), VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")
    val car6 = Vehicle(plateGenerator(), VehicleType.CAR, Calendar.getInstance(), null)

    //val parking = Parking(mutableSetOf(car, moto, minibus, bus))
    val parking = Parking(mutableSetOf())
    val arrayOfVehicles = arrayOf(car, moto, minibus, bus, car2, car1, car3, car4, car5, car6, car7, bus1
    , bus2, bus3, moto1, moto2, moto3, minibus1, minibus2, minibus3, bus1, bus2, bus3)

    //println(parking.vehicles.contains(car))
    //println(parking.vehicles.contains(moto))
    //println(parking.vehicles.contains(minibus))
    //println(parking.vehicles.contains(bus))

    //val isCar2Parked = parking.vehicles.add(car2)
    //println(isCar2Parked)
    /**
     * Ejercicio 6.3: se recorre el arreglo de vehiculos creado para invocar la funcion addVehicle
     * para ingresar vehiculos en el parking, pasando por la validacion de plazas disponibles.
     */
    arrayOfVehicles.forEach { vehicle ->
        if (parking.addVehicle(vehicle)) println("Welcome to AlkeParking!")
        else println("Sorry, the check-in has failed")
    }

}

fun plateGenerator(): String {
    val plateArray: ByteArray = ByteArray(7)
    Random().nextBytes(plateArray)
    return String(plateArray, Charset.forName("UTF-8"))
}