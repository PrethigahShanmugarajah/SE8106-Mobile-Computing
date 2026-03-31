fun main() {
    print("Enter an integer: ")
    val number = readLine()!!.toInt()

    if (number > 0) {
        println("The number is Positive")
    } else if (number < 0) {
        println("The number is Negative")
    } else {
        println("The number is Zero")
    }
}
