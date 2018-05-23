(ns introductory-excercises.excercises)

;; keywords

(def my-kwd :breakpoint)
(= :breakpoint :breakpoint)

;; vectors

(def my-vec [:reaktor :breakpoint 3 "str"])
(first my-vec)
(nth my-vec 2)

;; maps

(def my-map {:key :value
             "key2" (fn [x]
                      (inc x))})

(:key my-map)
(my-map :key)
(my-map "key2")
(get my-map "key2")

;; functions

(def my-fn (fn [x]
             (inc x)))

(def other-inc-fn #(inc %))
(defn inc-fn [x]
  (inc x))

(my-fn 3)

;; threading macros

(-> 5
    (+ 1)
    (/ 2))

(->> [1 2 3 4]
     (map (fn [num]
            (inc num))))

;; let bindings

(let [my-val "foo"]
  (string? my-val))
;(string? my-val)

;; destructuring

(defn dest-vec [a [b c & rest]]
  [a b c rest])

(defn dest-map [{:keys [a b] :or {a "A" b "B"}}]
  [a b])
