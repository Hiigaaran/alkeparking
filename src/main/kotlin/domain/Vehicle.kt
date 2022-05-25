package src.main.kotlin.domain

import java.time.LocalDateTime
import java.util.Calendar

/**
 * Ejercicio 2.2: Se agrega propiedad type de VehicleType en la data class Vehicle. Y se debe definir
 * como constante ya que un vehiculo no va a cambiar de tipo vehiculo, menos estando estacionado.
 *
 * Ejercicio 3.1: Se agrega propiedad checkInTime de tipo Calendar para guardar el momento en el cual
 * el vehiculo entra en el parking.
 *
 * Ejercicio 3.2: Se agrega propiedad discountCard de tipo String que puede ser null para informar
 * de descuento sobre la tarifa de estacionamiento si esta presente.
 *
 * Ambas propiedades se guardan en la clase Vehicle ya que estan relacionadas al ingreso del vehiculo
 * en el parking y ayudan para realizar los calculos en ParkingSpace para tiempo total de estadìa y
 * tarifa final.
 *
 * Luego la propiedad discountCard està definida con el simbolo ? para denotar que puede ser nulo,
 * debido al requerimiento.
 */
data class Vehicle (val plate: String, val type: VehicleType, val checkInTime : LocalDateTime, val discountCard : String?) {
    override fun equals(other: Any?): Boolean {
        if(other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}