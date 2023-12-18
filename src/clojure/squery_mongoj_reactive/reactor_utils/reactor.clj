(ns squery-mongoj-reactive.reactor-utils.reactor
  (:use squery-mongoj-reactive.reactor-utils.functional-interfaces)
  (:import (java.util.concurrent CompletableFuture)
           (java.util.function BooleanSupplier)
           (java.util.stream Collectors)
           (reactor.core.publisher Flux Mono)))

(defn to-flux [publisher]
  (Flux/from publisher))

(defn to-mono [publisher]
  (Mono/from publisher))

(defn flux-to-mono [flx]
  (if (instance? reactor.core.publisher.Flux flx)
    (Mono/from (.take flx 1))
    (Mono/from (.take (to-flux flx) 1))))

;;TODO
(defn mono-from-future
  ([fut]
   (let [cf (CompletableFuture.)
         _ (future (.complete cf @fut))]
     (Mono/fromFuture cf)))
  ([fut timeout-millis timeout-val]
   (let [cf (CompletableFuture.)
         _ (future (.complete cf (deref fut timeout-millis timeout-val)))]
     (Mono/fromFuture cf))))

(defn context-to-map [context]
  (-> (.stream context)
      (.collect (Collectors/toMap
                  (ffn [e] (.getKey e))
                  (ffn [e] (.getValue e))))
      ((partial into {}))))







