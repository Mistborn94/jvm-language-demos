(ns CljStreamFibonacci

    (:import (java.util.function UnaryOperator)
             (java.util.stream Stream)))

(defn fibonacci [n]
    (.orElse
        (.findFirst
            (.skip
                (.map
                    (Stream/iterate
                        [0 1]
                        (reify UnaryOperator (apply [_ t]
                                                 [(get t 1) (+ (get t 1) (get t 0))]))
                        )
                    (reify UnaryOperator (apply [_ pair] (get pair 1))))
                (.intValue (- n 1))
                )
            )
        0
        )
    )



