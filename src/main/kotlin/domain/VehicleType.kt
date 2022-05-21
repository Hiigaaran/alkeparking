package src.main.kotlin.domain

/**
 * Ejercicio 2.1: clase enum para definir los tipos de vehiculos.
 *
 * Ejercicio 2.3: Se agrega propiedad fee de tipo Int al enum class para guardar la tarifa fija por
 * tipo de vehiculo.
 */
enum class VehicleType(val fee: Int) {
    CAR(20),
    BIKE(15),
    MINIBUS(25),
    BUS(30)
}