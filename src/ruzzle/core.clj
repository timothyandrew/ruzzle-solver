(ns ruzzle.core
  (require [ruzzle.solver]
           [clojure.string :as s])
  (:gen-class))

(defn -main
  [size collapsed-board & args]
  (let [board (vec (map vec (partition (Integer. size) (s/split collapsed-board #""))))]
    (ruzzle.solver/solve board)
    (shutdown-agents)))
