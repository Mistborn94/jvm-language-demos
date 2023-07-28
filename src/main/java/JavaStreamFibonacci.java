import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class JavaStreamFibonacci implements FibonacciStrategy {

    private final Map<Integer, Long> cache = new HashMap<>();

    @Override
    public long fibonacci(int n) {
        return Stream.iterate(new Pair(0L, 1L),
                        JavaStreamFibonacci::nextPair)
                .map(Pair::b)
                .skip(n - 1)
                .findFirst()
                .orElse(0L);
    }

    @NotNull
    private static Pair nextPair(Pair pair) {
        return new Pair(pair.b(), pair.a() + pair.b());
    }

    private record Pair(long a, long b) {
    }

    @Override
    public String toString() {
        return "JavaStreamFibonacci";
    }
}


