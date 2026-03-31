class Student(val name: String, val age: Int, val marks: Int) {

    fun displayDetails() {
        println("Name: $name")
        println("Age: $age")
        println("Marks: $marks")
    }
}

fun main() {

    print("Enter student name: ")
    val name = readLine()!!

    print("Enter student age: ")
    val age = readLine()!!.toInt()

    print("Enter student marks: ")
    val marks = readLine()!!.toInt()

    val student1 = Student(name, age, marks)

    student1.displayDetails()
}
