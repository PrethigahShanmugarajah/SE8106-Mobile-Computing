fun main() {
    val words = listOf("HTML", "React", "Android", "Flutter", "Node.js", "Spring", "MySQL", "MongoDB")
    val reversedList = mutableListOf<String>()
    for (i in words.size - 1 downTo 0) {
        reversedList.add(words[i])
    }
    println("Original list: $words")
    println("Reversed list: $reversedList")
}