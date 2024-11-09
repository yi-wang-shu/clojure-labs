(ns clojure-camp)
;; Refactor the below code to use a single `cond` instead of multiple `ifs`.
;; Also, consider re-ordering the conditionals to simplify the logic.
(defn process-value
  [value]
  (if (and (number? value) (> value 10))
   :pretty-big
   (if (and (number? value) (< value 0))
    :negative
    (if (and (number? value) (zero? value))
     :zero
     (if (number? value)
      :small-number
      (if (string? value)
       :a-string
       :something-else))))))

;; Solution:
(defn process-value
  [value]
  (cond (string? value) :a-string
        (not (number? value)) :something-else
        (zero? value) :zero
        (> value 10) :pretty-big
        (< value 0) :negative
        :else :small-number))

;; Write a function to determine if some 3 side lengths are sufficient to make
;; a triangle.
;; To check if 3 sides make a triangle, you need to check that every side is less
;; than or equal to the sum of the other two sides.
(defn triangle? [a b c]
  (and
   (>= (+ a b) c)
   (>= (+ a c) b)
   (>= (+ b c) a)))
