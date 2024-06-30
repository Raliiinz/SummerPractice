package ru.itis.summerpractice


open class Car(
    val brand: String,
    val model: String,
    val year: Int,
    val color: String
) {
    open fun printInfo() {
        println("Info about car - Brand: $brand, Model: $model, Year: $year, Color: $color")
    }
}

class Crossover(brand: String,
                model: String,
                year: Int,
                color: String,
                val driveType: String,
                val enginePower: Int):
    Car(brand,model,year, color) {
    override fun printInfo() {
        super.printInfo()
        println("Drive Type: $driveType, Engine Power: $enginePower")
    }
}

class Bus(brand: String,
          model: String,
          year: Int,
          color: String,
          val numberOfSeats: Int):
    Car(brand, model, year, color) {
    override fun printInfo() {
        super.printInfo()
        println("Number of seats: $numberOfSeats")
    }
}

class Bicycle(brand: String,
              model: String,
              year: Int,
              color: String,
              val typeOfActivity: String):
    Car(brand, model, year, color) {
    override fun printInfo() {
        super.printInfo()
        println("Type of activity: $typeOfActivity")
    }
}

class Motorbike(brand: String,
                model: String,
                year: Int,
                color: String,
                val fuelСonsumption: String):
    Car(brand, model, year, color) {
    override fun printInfo() {
        super.printInfo()
        println("Fuel consumption: $fuelСonsumption")
    }
}


