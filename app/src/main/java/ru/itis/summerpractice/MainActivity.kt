package ru.itis.summerpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonStartRace = findViewById<Button>(R.id.buttonStartRace)

        buttonStartRace.setOnClickListener {
            val numberOfCars = editTextNumber.text.toString().toIntOrNull()
            if (numberOfCars!= null) {
                val cars = MutableList(numberOfCars) { createRandomCar() }
                runRaces(cars)
            }
        }
    }

    fun createRandomCar(): Car {
        val brands = mapOf(
            "Toyota" to listOf("Corolla", "Camry", "RAV4"),
            "Honda" to listOf("Civic", "Accord", "CR-V"),
            "Ford" to listOf("Fiesta", "Focus", "Escape")
        )
        val randomBrand = brands.keys.elementAt(Random.nextInt(brands.size))
        val randomModels = brands[randomBrand]?.toMutableList()?: mutableListOf()
        val randomModel = randomModels.random()
        val randomYear = (1990..2022).random()
        val colors = listOf("Black", "White", "Grey", "Red", "Blue", "Green")
        val randomColor = colors.random()

        return Car(randomBrand, randomModel, randomYear, randomColor)
    }

    fun runRaces(cars: MutableList<Car>) {
        while (cars.size > 1) {
            val pairs = generatePairs(cars)
            for ((index1, pair) in pairs.withIndex()) {
                val winner = race(pair.first, pair.second)
                if (winner!= null) {
                    println("--- Гонка между ${pair.first.model} и ${pair.second.model}, Победитель ${winner.model}")
                    cars.remove(winner)
                } else {
                    println("${cars[index1]} - Нет пары, следующий круг")
                }
            }
        }
        println("Победитель: ${cars[0].model}")
    }



    fun generatePairs(cars: MutableList<Car>): List<Pair<Car, Car>> {
        val shuffledCars = cars.toMutableList().shuffled()
        val pairs = mutableListOf<Pair<Car, Car>>()
        for (i in 0 until shuffledCars.size step 2) {
            if (i + 1 < shuffledCars.size) {
                pairs.add(Pair(shuffledCars[i], shuffledCars[i + 1]))
            } else {
                break // Если автомобилей нечетное количество, последний автомобиль проходит в следующий круг
            }
        }
        return pairs
    }


    fun race(car1: Car, car2: Car): Car? {
        return if (car1.year > car2.year) car1 else car2
    }
}
