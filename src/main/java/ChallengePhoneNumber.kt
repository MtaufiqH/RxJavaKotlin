fun main() {
    val contacts = mapOf(
        "603-555-1212" to "Florent",
        "212-555-1212" to "Elise",
        "408-555-1212" to "Marin",
        "617-555-1212" to "Scott"
    )


}

fun phoneNumberFormat(input: List<Int>) : String {
    val phone  = input.map { it.toString() }.toMutableList()
    phone.add(3, "-")
    phone.add(7, "-")
    return phone.joinToString("")
}

