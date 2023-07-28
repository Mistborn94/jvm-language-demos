

class ScalaFibonacci extends FibonacciStrategy {
    final private val cache = collection.mutable.Map[Int, Long]()

    override def fibonacci(n: Int): Long = if (n < 2) {
        n
    } else {
        val v = cache.get(n)
        if (v.isDefined) {
            v.get
        } else {
            val newV = fibonacci(n - 1) + fibonacci(n - 2)
            cache.put(n, newV)
            newV
        }
    }

    override def toString = s"ScalaFibonacci"
}

