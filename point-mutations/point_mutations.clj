(ns point-mutations)

(defn sum [lst]
  "Sum a list of numbers"
  (reduce + lst))

(defn zip [first-lst second-lst]
  "Returns a vector where those to letters are zipped"
  (map vector first-lst second-lst))

(defn letters-distance [first-letter second-letter]
  "Returns the distance between two letters, if
  they are equals the distance will 0 otherwise it will be 1"
  (if (= first-letter second-letter) 0 1))

(defn hamming-distance [first-str second-str]
  "Returns the hamming distance between two strings, if there length are
  equall nill will be returned"
  (if (= (count first-str) (count second-str))
    (sum (map #(letters-distance (first %) (second %)) (zip first-str second-str)))
    nil))



