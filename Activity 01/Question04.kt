fun main() {
    val text = "Sabaragamuwa University of Sri Lanka Software Engineering"
    var count = 0
    for (ch in text) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            count = count + 1
        }
    }
    println("Number of vowels is: $count")
}