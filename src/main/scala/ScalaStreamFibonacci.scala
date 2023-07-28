

class ScalaStreamFibonacci extends FibonacciStrategy {

    override def fibonacci(n: Int): Long = {
        lazy val fibs: LazyList[Long] =
            0L #:: 1L #:: fibs.zip(fibs.tail)
                .map { n => n._1 + n._2 }

        fibs(n)
    }

    override def toString = s"ScalaStreamFibonacci"
}

  