import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class FibonacciTest {

    @ParameterizedTest
    @MethodSource("source")
    fun `Test Fibonacci`(strategy: FibonacciStrategy, n: Int, expected: Long) {
        assertEquals(expected, strategy.fibonacci(n))
    }

    companion object {
        private val strategies = listOf(
            JavaFibonacci(), JavaStreamFibonacci(),
            KotlinFibonacci(), KotlinStreamFibonacci(),
            ScalaFibonacci(), ScalaFunctionalFibonacci(), ScalaStreamFibonacci(),
            ClojureFibonacci("CljFibonacci"), ClojureFibonacci("CljStreamFibonacci"),
            GroovyFibonacci(), GroovyStreamFibonacci()
        )
        private val pairs = listOf(1 to 1L, 2 to 1L, 3 to 2L, 4 to 3L, 10 to 55L, 15 to 610L, 20 to 6765L)

        @JvmStatic
        fun source(): List<Arguments> =
            strategies.flatMap { strategy -> pairs.map { (n, e) -> Arguments.of(strategy, n, e) }}
    }
}
