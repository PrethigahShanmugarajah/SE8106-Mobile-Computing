fun main() {
    val numbers = listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10)
    val newList = mutableListOf<Int>()
    for (num in numbers) {
        if (!newList.contains(num)) {
            newList.add(num)
        }
    }
    println("Original list: $numbers")
    println("List without duplicates: $newList")
}