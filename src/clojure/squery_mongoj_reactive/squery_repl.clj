(ns squery-mongoj-reactive.squery-repl
  (:refer-clojure :only [])
  (:use squery-mongo-core.operators.operators
        squery-mongo-core.operators.qoperators
        squery-mongo-core.operators.uoperators
        squery-mongo-core.operators.stages
        squery-mongo-core.operators.options
        squery-mongoj-reactive.driver.cursor
        squery-mongoj-reactive.driver.document
        squery-mongoj-reactive.driver.settings
        squery-mongoj-reactive.driver.transactions
        squery-mongoj-reactive.driver.utils
        squery-mongoj-reactive.arguments
        squery-mongoj-reactive.commands
        squery-mongoj-reactive.macros
        squery-mongoj-reactive.methods
        clojure.pprint)
  (:refer-clojure)
  (:require [clojure.core :as c])
  (:import (com.mongodb.client MongoClients MongoCollection)
           (com.mongodb MongoClientSettings MongoNamespace)))

(update-defaults :client-settings (-> (MongoClientSettings/builder)
                                      (.codecRegistry clj-registry)
                                      (.build)))

(update-defaults :client (MongoClients/create ^MongoClientSettings (defaults :client-settings)))
