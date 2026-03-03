fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var largest = numbers[0] 
    for (num in numbers) {
        if (num > largest) {
            largest = num
        }
    }
    println("The largest number is: $largest")
}