

class ScalaFunctionalFibonacci extends FibonacciStrategy {

    override def fibonacci(n: Int): Long = memoize {
        case 0 => 0
        case 1 => 1
        case n => fibonacci(n - 2) + fibonacci(n - 1)
    }(n)

    private def memoize(f: Int => Long): Int => Long = {
        val cache = scala.collection.mutable.Map.empty[Int, Long]
        k => cache.getOrElseUpdate(k, f(k))
    }

    override def toString = s"ScalaFunctionalFibonacci"
}

  