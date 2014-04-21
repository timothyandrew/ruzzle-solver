(defproject ruzzle "0.1.0-SNAPSHOT"
  :description "Ruzzle Solver in Clojure"
  :url "http://example.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot ruzzle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
