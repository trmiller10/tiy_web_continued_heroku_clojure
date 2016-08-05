(ns controllers.notes
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [ring.util.response :as ring]
            [views.notes :as view]
            [models.note :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [note]
  (when-not (str/blank? note)
    (model/create note))
  (ring/redirect "/"))

(defroutes routes
           (GET  "/" [] (index))
           (POST "/" [note] (create note)))
