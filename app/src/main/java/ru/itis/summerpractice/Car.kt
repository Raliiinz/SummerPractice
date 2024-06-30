package ru.itis.summerpractice

import kotlin.random.Random

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

//
//fun createRandomCar(): Car {
//    val brands = mapOf(
//        "Toyota" to listOf("Corolla", "Camry", "RAV4"),
//        "Honda" to listOf("Civic", "Accord", "CR-V"),
//        "Ford" to listOf("Fiesta", "Focus", "Escape")
//    )
//    val randomBrand = brands.keys.elementAt(Random.nextInt(brands.size))
//    val randomModels = brands[randomBrand]?.toMutableList()?: mutableListOf()
//    val randomModel = randomModels.random()
//    val randomYear = (1990..2022).random()
//    val colors = listOf("Black", "White", "Grey", "Red", "Blue", "Green")
//    val randomColor = colors.random()
//
//    return Car(randomBrand, randomModel, randomYear, randomColor)
//}

fun race(car1: Car, car2: Car): Car {
    return if (car1.year > car2.year) car1 else car2
}