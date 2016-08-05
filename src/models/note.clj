(ns models.note
  (:require [clojure.java.jdbc :as sql]))

(def url "postgresql://localhost:5432/something")

(defn all []
  (into [] (sql/query url ["select * from notes order by id desc"])))

(defn create [note]
  (sql/insert! url :notes note))


