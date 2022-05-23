package src.main.kotlin.domain

data class Parking (val vehicles : MutableSet<Vehicle>) {

    /**
     * Ejercicio 5.1: Se agrega propiedad privada maxParkingSlots para setear la cantidad maxima de
     * vehiculos que puede tener el parking.
     */
    private val maxParkingSlots = 20

    /**
     * Ejercicio 11.1 propiedad tipo Pair para guardar cantidad de vehiculos saliendo del estacionamiento
     * y la cantidad de dinero recaudado respectivamente.
     */
    var cumulativeGains: Pair<Int, Int> = Pair(0, 0)

    /**
     * Ejercicio 5.2: Se implementa la funcion addVehicle que permite agregar vehiculos en el parking
     * mediando una validacion de capacidad, si el vehiculo pudo ingresar retorna true y si no puede
     * retorna false.
     */
    fun addVehicle(vehicle: Vehicle): Boolean {
        if(vehicles.size != maxParkingSlots) {
            vehicles.add(vehicle)
            return true
        } else {
            return false
        }
    }

    /**
     * Ejercicio 11.2
     */
    fun getCumulativeGains(): Unit {
        println("${cumulativeGains.first} vehicles have checked out and have earnings of $${cumulativeGains.second}")
    }

    /**
     * Ejercicio 12.1
     */
    fun listVehicles() {
        vehicles.forEach {
            it -> println(it.plate)
        }
    }
}