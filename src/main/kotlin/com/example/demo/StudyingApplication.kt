package com.example.demo

import com.example.demo.exercises.RectanglesExercise
import com.example.demo.exercises.RestClientExcercise
import com.example.demo.exercises.ValidationCNPJExercise
import com.example.demo.utils.Rectangles
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudyingApplication

fun main(args: Array<String>) {
    runApplication<StudyingApplication>(*args)

    // 1) Validate CNPJ format and check digits
    val cnpjExercise = ValidationCNPJExercise()
    cnpjExercise.validationCNPJ("16572883000144")
    // println("The CNPJ: 16572883000144 is ${cnpjExercise.validationCNPJ("16572883000144")}")

    // 2) Test if two rectangles intersect
    // 3) Compute the area of intersection between two rectangles
    val A = Rectangles(3, 5, 11, 11)
    val B = Rectangles(7, 2, 13, 7)
    val C = Rectangles(11, 11, 15, 13)
    val rectanglesExcercise = RectanglesExercise()
    rectanglesExcercise.twoRectanglesIntersect(A, B)
    rectanglesExcercise.computeArea(A, B)
    // println("Two rectangles intersect: ${rectanglesExcercise.twoRectanglesIntersect(A, B)}")
    // println("Compute the area: ${rectanglesExcercise.computeArea(A, B)}")

    // 5) Rest Client - World Clock
    val restClientExcercise = RestClientExcercise()
    restClientExcercise.worldClock()
    // println("result: ${restClientExcercise.worldClock(url)}")

    // 6) Rest Server - World Clock - Acess
    restClientExcercise.getCurrentDateTime()
    // println("result: ${restClientExcercise.getCurrentDateTime()}")
}