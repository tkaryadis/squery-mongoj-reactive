(ns squery-mongoj-reactive.test-mutiny
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
    (com.mongodb.reactivestreams.client MongoClients)
    (io.smallrye.mutiny Multi Uni)))

(update-defaults :client (MongoClients/create ^MongoClientSettings (defaults :client-settings))
                 :mutiny? true)

(-> (drop-collection :testdb.testcoll)
    (.await)
    (.indefinitely))

(-> (insert :testdb.testcoll [{:b [-1 2 3]}])
    (.await) (.indefinitely))

(-> (q :testdb.testcoll
       {:b (map (fn [:this.] (abs :this.)) :b)})
    (.map (fn [r] (do (prn r) r)))
    (.subscribe) (.with (fn [x] (prn x))))

(.read (System/in))