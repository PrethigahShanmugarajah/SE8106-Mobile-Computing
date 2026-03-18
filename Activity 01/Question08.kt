fun main() {
    val numbers = listOf( -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var sum = 0
    for (num in numbers) {
        if (num > 0) {
            sum = sum + num
        }
    }
    println("Sum of positive numbers is: $sum")
}