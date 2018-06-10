(defproject gitpub "0.1.0-SNAPSHOT"
  :description "FIXME: Transmitter to send Git commits to an AcitvityPub node"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [clj-jgit "0.8.10"]
                 [crypto-password "0.2.0"]]
  :main ^:skip-aot gitpub.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
