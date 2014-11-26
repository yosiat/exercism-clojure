(ns bob)


(defn- all? [predicate list]
  "Check if all elements in the list returns true for predicate,
  empty list would return false (unlike every?)"
  (and
    (not (empty? list))
    (every? predicate list)))

(defn- all-letters [string]
  "Returns all letters in the string"
  (filter #(Character/isLetter %) string))


(defn- all-letters-uppercase? [string]
  "Check if all letters are uppercase"
  (all? #(Character/isUpperCase %) (all-letters string)))

(defn- yell? [sentence]
  (all-letters-uppercase? sentence))

(defn- question? [sentence]
  (= (str (last sentence)) "?"))

(defn- nothing? [sentence]
  (clojure.string/blank? sentence))


(defn response-for [sentence]
  (cond
  (nothing? sentence) "Fine. Be that way!"
  (yell? sentence) "Whoa, chill out!"
  (question? sentence) "Sure."
  :else  "Whatever."
  ))
