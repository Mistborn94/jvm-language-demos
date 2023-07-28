import clojure.java.api.Clojure;
import clojure.lang.IFn;


public class ClojureFibonacci implements FibonacciStrategy {

    private final String ns;

    public ClojureFibonacci(String cljFibonacci) {
        ns = cljFibonacci;
    }

    @Override
    public long fibonacci(int n) {

        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read(ns));

        IFn fib = Clojure.var(ns, "fibonacci");

        return (long) fib.invoke(n);
    }

    @Override
    public String toString() {
        return ns;
    }
}

