(ns phone-number)

(def bad-number "0000000000")
(def area-code-length 3)

(defn- list->string [lst]
  (clojure.string/join lst))

(defn- digits [string]
  "Returns all the digits from the string"
  (list->string (filter #(Character/isDigit %) string)))


(defn number [phone_number]
  (let [numbers (digits phone_number)
        len (count numbers)]
    (cond
      (< len 10) bad-number
      (= len 10) numbers
      (and (= len 11) (= (first numbers) \1)) (list->string (rest numbers))
      (>= len 11) bad-number
    )))

(defn area-code [phone_number]
  (list->string (take area-code-length (number phone_number))))

(defn pretty-print [phone_number]
  (let [cleaned (number phone_number)
        local-number (drop area-code-length cleaned)]
  (str "(" (area-code cleaned) ") "
       (list->string (take 3 local-number)) "-"
       (list->string (take-last 4 local-number)))))

