import java.util.stream.Stream

class GroovyStreamFibonacci implements FibonacciStrategy {

    @Override
    long fibonacci(int n) {
        return Stream.iterate(new Tuple2<>(0L, 1L),
                pair -> nextTuple pair)
                .map { pair -> pair.v2 }
                .skip(n - 1)
                .findFirst()
                .orElse(0L)
    }

    private static Tuple2<Long, Long> nextTuple(Tuple2<Long, Long> pair) {
        new Tuple2<>(pair.v2, pair.v1 + pair.v2)
    }


    @Override
    String toString() {
        return "GroovyStreamFibonacci";
    }
}


