(ns ruzzle.solver
  (:require [clojure.string :as s]
            [clojure.set :as set]))

(declare find-words)

(def word-list
  (let [word-list ["RAT"]]
    (reduce (fn [dict word]
              (assoc dict word true))
            {}
            word-list)))



(defn solve
  ([board] (solve board #()))
  ([board solutions]
     (let [size (count board)
           starting-points (for [x (range size) y (range size)] [x y])]
       (dorun (map #(find-words board %) starting-points)))))

(def get-from-board get-in)

(defn valid-word? [word]
  (if (contains? word-list word)
    (do
      (when (> (count word) 1) (println "Found: " word))
      true)
    false))

(defn neighbors [board coords exclude]
  (let [offsets [[1 1] [-1 -1] [-1 0] [1 0] [0 -1] [0 1] [1 -1] [-1 1]]
        size (count board)
        all-neighbors (map (fn [[x y]]
                             (let [[starting-x starting-y] coords]
                               [(+ starting-x x) (+ starting-y y)]))
                           offsets)
        valid-neighbors (remove (fn [[x y]]
                                  (cond
                                   (< x 0) true
                                   (< y 0) true
                                   (>= x size) true
                                   (>= y size) true
                                   :default false))
                                all-neighbors)]
    (vec (set/difference (set valid-neighbors) (set exclude)))))


(defn find-words
  ([board starting-at] (find-words board starting-at #{} [(get-from-board board starting-at)] [starting-at]))
  ([board starting-at words builder seen-already]
     (let [words (if (valid-word? (s/join builder))
                   (conj words (s/join builder))
                   words)]
       (if-let [neighbors (neighbors board starting-at seen-already)]
         (set
          (reduce set/union
                  words
                  (map #(find-words board % words (conj builder (get-from-board board %)) (conj seen-already %)) neighbors)))
         words))))
