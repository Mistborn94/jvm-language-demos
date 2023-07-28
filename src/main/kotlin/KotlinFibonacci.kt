@file:Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE", "RedundantExplicitType",
    "VARIABLE_WITH_REDUNDANT_INITIALIZER"
)

class KotlinFibonacci : FibonacciStrategy {

    private val cache = mutableMapOf<Int, Long>()

    override fun fibonacci(n: Int): Long {
        return if (n < 2) {
            n.toLong()
        } else {
            cache.getOrPut(n) { fibonacci(n - 1) + fibonacci(n - 2) }
        }
    }

    override fun toString() = "KotlinFibonacci"
}


