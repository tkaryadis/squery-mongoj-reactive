(defproject org.squery/squery-mongoj-reactive "0.2.0-SNAPSHOT"
  :description "SQuery for the reactive mongodb java driver"
  :url "https://github.com/tkaryadis/squery-mongoj-reactive"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.11.0"]

                 ;;project reactor
                 [io.projectreactor/reactor-core "3.6.3"]
                 ;;clojure-reactor-utils
                 ;;[reactor-utils "0.1.0-SNAPSHOT"]

                 ;;mutiny
                 [io.smallrye.reactive/mutiny "2.5.7"]
                 [io.smallrye.reactive/mutiny-reactor "2.5.7"]

                 ;;log
                 [org.slf4j/slf4j-api "1.7.30"]
                 [com.fzakaria/slf4j-timbre "0.3.21"]

                 ;;mongo
                 [org.mongodb/mongodb-driver-reactivestreams "4.11.0"]
                 [org.squery/squery-mongo-core "0.2.0-SNAPSHOT"]

                 ;;json
                 [org.clojure/data.json "2.4.0"]  
                 [cheshire "5.10.0"]              ;;json alternative

                 ;;ordered-map
                 [org.flatland/ordered "1.5.9"]
                 ]

  :plugins [[lein-codox "0.10.7"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]

  ;;:global-vars {*warn-on-reflection* true *assert* false}

  ;;:repl-options {:init-ns cmql-j.cmql-repl}
  ;:main squery-mongoj-reactive.core
  ;:aot [squery-mongoj-reactive.core]
  )
