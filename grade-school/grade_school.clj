(ns grade-school)


(defn add [db student-name grade]
  "Add new student to the database by it's grade"
  (assoc db grade (conj (get db grade []) student-name)))


(defn grade [db search-grade]
  "Returns list of student by their grade"
  (get db search-grade []))

(defn- sort-by-value [pair]
  "Sort a pair of key/value by it's value"
  (let [key (first pair)
        value (second pair)]
    {key (sort value)}))

(defn sorted [db]
  "Sort the keys (grades) of the db and it's names"
  ;; sort by grade
  (into (sorted-map)
    ;; sort student name
    (map sort-by-value db)))

