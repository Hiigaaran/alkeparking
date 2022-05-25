import src.main.kotlin.domain.Parking
import src.main.kotlin.domain.ParkingSpace
import src.main.kotlin.domain.Vehicle
import src.main.kotlin.domain.VehicleType
import java.nio.charset.Charset
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Random

/**
 * Challenge kotlin
 * @since 23-05-2022
 * @author Diana Cerda
 * @author Simon Morales
 */
fun main() {
    /***
     * Ejercicio 1: ¿Por que se define vehicles como un set?
     * RE: El que sea definido como set nos permite mediante el uso de hashcode validar rapidamente
     *     y evitar ingresar vehiculos repetidos, ademas, el orden de los items no es importante.
     *
     * Ejercicio 2:
     */
    val localDateTimeAdv = LocalDateTime.now().minusHours(3)

    val car = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), "DISCOUNT")
    val moto = Vehicle(plateGenerator(), VehicleType.BIKE, LocalDateTime.now(), null)
    val minibus = Vehicle(plateGenerator(), VehicleType.MINIBUS, LocalDateTime.now(), null)
    val bus = Vehicle(plateGenerator(), VehicleType.BUS, localDateTimeAdv, "DISCOUNT")
    val car2 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), null)
    val car1 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), "DISCOUNT")
    val moto1 = Vehicle(plateGenerator(), VehicleType.BIKE, LocalDateTime.now(), null)
    val minibus1 = Vehicle(plateGenerator(), VehicleType.MINIBUS, LocalDateTime.now(), null)
    val bus1 = Vehicle(plateGenerator(), VehicleType.BUS, LocalDateTime.now(), "DISCOUNT")
    val car3 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), null)
    val car5 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), "DISCOUNT")
    val moto2 = Vehicle(plateGenerator(), VehicleType.BIKE, LocalDateTime.now(), null)
    val minibus2 = Vehicle(plateGenerator(), VehicleType.MINIBUS, LocalDateTime.now(), null)
    val bus2 = Vehicle(plateGenerator(), VehicleType.BUS, LocalDateTime.now(), "DISCOUNT")
    val car4 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), null)
    val car7 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), "DISCOUNT")
    val moto3 = Vehicle(plateGenerator(), VehicleType.BIKE, LocalDateTime.now(), null)
    val minibus3 = Vehicle(plateGenerator(), VehicleType.MINIBUS, LocalDateTime.now(), null)
    val bus3 = Vehicle(plateGenerator(), VehicleType.BUS, LocalDateTime.now(), "DISCOUNT")
    val car6 = Vehicle(plateGenerator(), VehicleType.CAR, LocalDateTime.now(), null)

    val parking = Parking(mutableSetOf())
    val arrayOfVehicles = arrayOf(car, moto, minibus, bus, car2, car1, car3, car4, car5, car6, car7, bus1
    , bus2, bus3, moto1, moto2, moto3, minibus1, minibus2, minibus3, bus1, bus2, bus3)

    /**
     * Ejercicio 6.3: se recorre el arreglo de vehiculos creado para invocar la funcion addVehicle
     * para ingresar vehiculos en el parking, pasando por la validacion de plazas disponibles.
     */
    arrayOfVehicles.forEach { vehicle ->
        if (parking.addVehicle(vehicle)) println("Welcome to AlkeParking!")
        else println("Sorry, the check-in has failed")
    }

    val parkingSpace = ParkingSpace(bus, parking)

    parkingSpace.checkOutVehicle(bus.plate, onSuccess = ::onSuccess, ::onError)
    parkingSpace.checkOutVehicle(moto.plate, ::onSuccess, ::onError)

    parking.getCumulativeGains()
    parking.listVehicles()
}

fun plateGenerator(): String {
    val plateArray: ByteArray = ByteArray(7)
    Random().nextBytes(plateArray)
    return String(plateArray, Charset.forName("UTF-8"))
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