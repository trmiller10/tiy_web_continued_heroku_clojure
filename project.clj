 (defproject tiy_web_continued_heroku_clojure "0.0.1-SNAPSHOT"
   :description "TIY Clojure web app assignment"
   :dependencies [[org.clojure/clojure "1.8.0"]
                  [org.clojure/java.jdbc "0.6.1"]
                  [org.postgresql/postgresql "9.4-1201-jdbc41"]
                  [compojure "1.4.0"]
                  [ring "1.4.0"]
                  [ring/ring-defaults "0.1.2"]
                  [ring/ring-jetty-adapter "1.4.0"]
                  [hiccup "1.0.5"]
                  ]
   :main tiy-web-continued-heroku-clojure.web)

