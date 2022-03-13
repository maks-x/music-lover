const val loyalCustomer = true
var purchaseAmount = 11_500_00

fun main() {
    val initialCost = 250_00
    val discount =
        if (purchaseAmount in 1_000_01..10_000_00) {
            100_00
        } else if (purchaseAmount > 10_000_00) {
            initialCost * 5 / 100
        } else 0
    var finalCost = initialCost - discount
    if (loyalCustomer) finalCost = finalCost * 99 / 100
    println(
        "Purchase amount: ${purchaseAmount / 100} RUB\n" +
                "Loyal customer: $loyalCustomer\n" +
                "Initial cost: ${initialCost / 100} RUB\n" +
                "Final cost: ${kopToRub(finalCost)}"
    )
}

//немного попрактиковался со строками
fun kopToRub(num: Int): String {
    val strNum = num.toString()
    val result =
        if (num % 100 == 0) {
            strNum
        } else {
            val rub = strNum.subSequence(0, strNum.length - 2)
            val kop = strNum.subSequence(strNum.length - 2, strNum.length)
            "${if (rub == "") "0" else rub} RUB $kop kopecks"
        }
    return result
}