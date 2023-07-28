class KotlinStreamFibonacci : FibonacciStrategy {

    override fun fibonacci(n: Int): Long =
        generateSequence(0L to 1L)
                 { (a, b) -> b to (a + b) }
            .map { it.second }
            .drop(n - 1)
            .first()

    override fun toString() = "KotlinStreamFibonacci"
}

