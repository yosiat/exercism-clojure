(ns nucleotide-count)


(def dna-nucleotides #{\A \T \C \G})
(def rna-nucleotides #{\U})
(def all-nucleotides (set (concat rna-nucleotides dna-nucleotides)))

(defn valid-nucleotide? [nucleotide]
  "Check if this a valid rna/dna nucleotide"
  (contains? all-nucleotides nucleotide))

(defn count [nucleotide dna]
  "Count the number of nucleotide occurence in the dna strand"
  (if (valid-nucleotide? nucleotide)
    (clojure.core/count (filter #(= nucleotide %) dna))
    (throw (Exception. "invalid nucleotide"))))


(defn nucleotide-counts [dna]
  "Count the number of nucleotides in the dna"
  (reduce into (map (fn [n] {n (count n dna)}) dna-nucleotides)))
