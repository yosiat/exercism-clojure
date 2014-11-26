(ns word-count)



(defn word-count [sentence]
  (frequencies (map clojure.string/lower-case (re-seq #"\w+" sentence))))
