(ns views.layout
  (:require [hiccup.page :as h]))

(defn common [title & body]
  (h/html5
    [:head
     [:title title]]
     [:body
      [:div {:id "header"}
       [:h1 {:class "container"} "NoteTaker"]]
      [:div {:id "content" :class "container"} body]]))

(defn four-oh-four []
  (common "Page Not Found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))