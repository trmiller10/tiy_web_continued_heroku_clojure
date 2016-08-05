(ns web
  (:require [compojure.core :refer [defroutes]]
            [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [controllers.notes :as notes]
            [views.layout :as layout]
            [models.migration :as schema])
  (:gen-class))

(defonce server (atom nil))

(defroutes routes
           notes/routes
           (route/resources "/")
           (route/not-found (layout/four-oh-four)))

(def application (wrap-defaults routes site-defaults))

(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (when @server
    (.stop @server))
  (schema/migrate)
  (reset! server (ring/run-jetty routes {:port 3000 :join? false})))