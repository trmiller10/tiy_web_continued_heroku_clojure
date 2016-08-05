(ns views.notes
  (:require [views.layout :as layout]
            [hiccup.core :as h]
            [ring.util.anti-forgery :as anti-forgery]
            [hiccup.def :refer [defelem]])
  )

(defn note-form []
  [:div
   [:form {:action "/" :method "POST"}
    (anti-forgery/anti-forgery-field)
    [:label {:for "note"} "Enter note here"]
    [:br]
    [:input {:type "text" :name "note"}]
    [:button {:type "submit"} "Submit note"]]])

;{:id "note-form" :class "sixteen columns alpha omega"}
;(form/form-to [:post "/"]
;(anti-forgery/anti-forgery-field)
;(form "note" "Enter note here.")
;(form/text-area "note")
;(form/submit-button "Submit")
;)])


(defn display-notes [notes]
  [:div
   [:ol
    (map
      (fn [note] [:li (h/html (:name note))]))]])

(defn index [notes]
  (layout/common "NoteTaker"
                 (note-form)
                 [:div (display-notes notes)]))