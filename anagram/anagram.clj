(ns anagram
  (:require [clojure.string :refer [lower-case]]))



(defn- anagram-for? [word candidate]
    (let [lower-word (lower-case word)
          lower-candidate (lower-case candidate)
          diff (clojure.data/diff (sort lower-word) (sort lower-candidate))]
      (and
        ;; anagram is not own word
        (not (= lower-word lower-candidate))
        ;; Check if we characters only in the word on the candidate
        (empty? (nth diff 0))
        (empty? (nth diff 1))
        ;; Check that the things in both are count of word
        (= (count word) (count (nth diff 2)))
        )
      ))

(defn anagrams-for [word candidates]
  (filter #(anagram-for? word %) candidates))
