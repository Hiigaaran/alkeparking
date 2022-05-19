package src.main.kotlin.domain

data class Vehicle (val plate: String) {
    override fun equals(other: Any?): Boolean {
        if(other is Vehicle) return this.plate == other.plate

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}