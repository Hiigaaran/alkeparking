package src.main.kotlin.domain

import org.jetbrains.annotations.Nullable
import java.util.Calendar

data class Vehicle (val plate: String, val type: VehicleType, val checkInTime : Calendar, val discountCard : String?) {
    override fun equals(other: Any?): Boolean {
        if(other is Vehicle) return this.plate == other.plate

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}