class GroovyFibonacci implements FibonacciStrategy {

    def cache = new HashMap<Integer, Long>()

    @Override
    long fibonacci(int n) {
        if (n < 2) {
            n
        } else {
            final def v = cache.get n

            if (v != null) {
                v
            } else {
                var newV = (fibonacci n - 1) + (fibonacci n - 2)
                cache.put n, newV
                newV
            }

        }
    }


    @Override
    public String toString() {
        return "GroovyFibonacci";
    }
}

