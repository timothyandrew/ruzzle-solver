(ns ruzzle.core
  (:require [domina :as dom]
            [domina.events :as events]
            [clojure.string :as string]
            [ruzzle.solver :as solver]))

(enable-console-print!)

(defn start []
  (let [size 3
        collapsed-board "ARCBTXASD"
        board (vec (map vec (partition size (string/split collapsed-board #""))))]
    (println "SOLVING.")
    (solver/solve board)
    (println "DONE.")))

(events/listen! (dom/by-id "solve") :click start)
