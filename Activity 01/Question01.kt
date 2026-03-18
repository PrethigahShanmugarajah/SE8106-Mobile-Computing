fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var sum = 0
    for (num in numbers) {
        if (num % 2 == 0) {
            sum = sum + num
        }
    }
    println("Sum of even numbers is: $sum")
}