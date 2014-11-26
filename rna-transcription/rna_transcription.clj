(ns rna-transcription)


(def dna-to-rna {\G \C, \C \G, \T \A, \A \U})


(defn- trasnform-nucleotide [nucleotide]
  "Transform nucleotide from dna to rna,
  if nucleotide isn't valid AssertionError will be thrown"
  (assert (contains? dna-to-rna nucleotide))
  (dna-to-rna nucleotide))

(defn to-rna [strand]
  (apply str (map trasnform-nucleotide strand)))
