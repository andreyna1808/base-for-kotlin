package com.example.demo.exercises

import com.example.demo.utils.Coord
import com.example.demo.utils.Rectangles

class RectanglesExercise {

    // https://www.geeksforgeeks.org/find-two-rectangles-overlap/
    fun twoRectanglesIntersect(rectangleOne: Rectangles, rectangleTwo: Rectangles): Boolean {
        val validationX = rectangleOne.x2 >= rectangleTwo.x1 && rectangleOne.x1 <= rectangleTwo.x2
        val validationY = rectangleOne.y2 >= rectangleTwo.y1 && rectangleOne.y1 <= rectangleTwo.y2

        return validationX && validationY
    }

    // Help by Juan
    fun computeArea(rectangleOne: Rectangles, rectangleTwo: Rectangles): Number {
        val CoordOne = Coord(minOf(rectangleOne.y2, rectangleTwo.y2), maxOf(rectangleOne.y1, rectangleTwo.y1))
        val CoordTwo = Coord(minOf(rectangleOne.x2, rectangleTwo.x2), maxOf(rectangleOne.x1, rectangleTwo.x1))

        val base = countValuesBetween(CoordOne.x, CoordTwo.x)
        val height = countValuesBetween(CoordOne.y, CoordTwo.y)

        val area = base * height
        return area
    }

    private fun countValuesBetween(valueInitial: Int, valueFinish: Int): Int {
        var count = 0
        for (i in valueInitial..valueFinish) {
            count++
        }

        return count
    }

}