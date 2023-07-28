(ns CljFibonacci)

    (defn fibonacci [n] memoize
        (case n
            0 0
            1 1
            (+ (fibonacci (- n 1)) (fibonacci (- n 2)))
            )
        )

