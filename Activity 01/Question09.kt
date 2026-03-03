fun main() {
    val correctNumber = 5
    var guess = 0
    println("Guess a number between 1 and 10")
    while (guess != correctNumber) {
        print("Enter your guess: ")
        val input = readLine()
        guess = input!!.toInt()
        if (guess < 1 || guess > 10) {
            println("Guess a number between 1 and 10")
        }
        else if (guess != correctNumber) {
            println("Wrong number, try again.")
        }
    }
    println("Correct! You guessed the number.")
}