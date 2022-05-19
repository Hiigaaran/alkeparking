import src.main.kotlin.domain.Parking
import src.main.kotlin.domain.Vehicle
import src.main.kotlin.domain.VehicleType
import java.util.Calendar

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT")
    val moto = Vehicle("8222BBB", VehicleType.BIKE, Calendar.getInstance(), null)
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance(), null)
    val bus = Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT")

    val parking = Parking(mutableSetOf(car, moto, minibus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))
}