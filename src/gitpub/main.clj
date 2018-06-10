(ns gitpub.main
  (:require [clj-jgit.porcelain :as g]
            [clojure.string :as s]
            [clojure.data.json :as j])
  (:gen-class))


(defn post-status
  [status-text]
  (.post mastodon-client "statuses"
         (clj->js (merge {:status status-text}))))

(defn print-usage
  [args]
  (println (str "`" (first args)
                "` was not recognised. The following commands are understood:"))
  (println "\t`post-receive`: handle a post-receive hook from git, and send\n\t  appropriate ActivityPub messages to the configured server."))

(defn post-receive
  "Handle a post-receive. What this needs to is, for each branch which has moved as a result
  of the specified push, a message as described in `doc/intro.md`.
  Data is passed to post-receive as tuples <oldrev, newrev, ref> on standard in."
  [args]
  (let
    [tuples (map #(s/split % #" ") (s/split (slurp *in*) #"\n"))
     repo (g/load-repo ".")
     branches (g/git-branch-list repo)]
    (doall
      (map
        (fn [branch] (post-status (create-gitpub-message branch)))
        (filter
          (fn [branch]
            (let [id (.getObjectId branch)]
              (if
                (some #(= id (first %)) tuples)
                branch)))
          branches)))))

(defn -main
  "Expects as arg the name of the git hook to be handled, followed by the arguments to it"
  [& args]
  ;; (println (-> (java.io.File. ".") .getAbsolutePath))
  (case (str (first args))
    "post-receive" (post-receive args)
    (print-usage args)
    ))
