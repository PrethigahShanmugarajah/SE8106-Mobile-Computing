fun main() {
    val number = 10
    var factorial = 1
    for (i in 1..number) {
        factorial = factorial * i
    }
    println("Factorial of $number is: $factorial")
}