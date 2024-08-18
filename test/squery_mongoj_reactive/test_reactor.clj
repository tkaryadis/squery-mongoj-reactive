(ns squery-mongoj-reactive.test-reactor
  (:refer-clojure :only [])
  (:use squery-mongo-core.operators.operators
        squery-mongo-core.operators.qoperators
        squery-mongo-core.operators.uoperators
        squery-mongo-core.operators.stages
        squery-mongo-core.operators.options
        squery-mongoj-reactive.driver.cursor
        squery-mongoj-reactive.driver.document
        squery-mongoj-reactive.driver.settings
        squery-mongoj-reactive.driver.utils
        squery-mongoj-reactive.arguments
        squery-mongoj-reactive.commands
        squery-mongoj-reactive.macros
        flatland.ordered.map
        clojure.pprint)
  (:refer-clojure)
  (:require [clojure.core :as c])
  (:import
    (com.mongodb MongoClientSettings)
    (com.mongodb.reactivestreams.client MongoClients)))

(update-defaults :client (MongoClients/create ^MongoClientSettings (defaults :client-settings)))

;(update-defaults :client (MongoClients/create "mongodb+srv://root:2580takis#@rejoy-cluster.3zyookr.mongodb.net/?retryWrites=true&w=majority&appName=rejoy-cluster"))

#_(-> (drop-database :products-service)
    .block)

(comment)
(-> (drop-collection :testdb.testcoll)
    .block)

(-> (insert :testdb.testcoll [{:b [-1 2 3]}])
    .block)

(-> (q :testdb.testcoll
       {:b (map (fn [:this.] (abs :this.)) :b)})
    (.map (fn [r] (do (prn r) r)))
    (.subscribe))



(.read (System/in))