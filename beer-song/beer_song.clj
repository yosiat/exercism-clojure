(ns beer-song
  (:require [clojure.string :refer [capitalize, join]]))

(def max-bottles-number 99)
(def no-bottles 0)
(def one-bottle 1)

(defn format-bottles-quantity [bottles-number]
  "Formats the bottles quantity - singular/plural or no more bottles"
  (cond
    (> bottles-number one-bottle) (str bottles-number " bottles")
    (= bottles-number one-bottle) (str bottles-number " bottle")
    (= bottles-number no-bottles) "no more bottles"
    (< bottles-number no-bottles) (format-bottles-quantity max-bottles-number)))

(defn next-action [bottles-number]
  "Finds out the next action we need to do with the bottle"
  (cond
    (> bottles-number one-bottle) "Take one down and pass it around"
    (= bottles-number one-bottle) "Take it down and pass it around"
    (< bottles-number one-bottle) "Go to the store and buy some more"))

(defn verse [verse-number]
  (let [next-verse (- verse-number 1)
        current-quantity (format-bottles-quantity verse-number)
        next-quantity (format-bottles-quantity next-verse)]
  (str (capitalize current-quantity) " of beer on the wall, " current-quantity " of beer.\n"
       (next-action verse-number) ", " next-quantity " of beer on the wall.\n")))

(defn sing
  ([end] (sing end 0))
  ([end start] (join "\n" (reverse (map verse (range start (+ end 1)))))))
