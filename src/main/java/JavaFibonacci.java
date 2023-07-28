import java.util.HashMap;
import java.util.Map;

public class JavaFibonacci implements FibonacciStrategy {

    private final Map<Integer, Long> cache = new HashMap<>();

    @Override
    public long fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            final var v = cache.get(n);

            if (v != null) {
                return v;
            } else {
                var newV = fibonacci(n - 1) + fibonacci(n - 2);
                cache.put(n, newV);
                return newV;
            }

        }
    }

    @Override
    public String toString() {
        return "JavaFibonacci";
    }
}
