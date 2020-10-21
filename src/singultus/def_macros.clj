(ns singultus.def-macros)

(defmacro defpartial
  [name params & body]
  `(let [group# (swap! singultus.core/group-id inc)]
     (defn ^{:singultusGroup group#}
       ~name ~params
       (let [elem# (singultus.core/html ~@body)]
         (.setAttribute elem# "singultusGroup" group#)
         elem#))
     (set! (.-prototype._singultusGroup ~name) group#)))

(defmacro defhtml
  [name params & body]
  `(let [group# (swap! singultus.core/group-id inc)]
     (defn ~name ~params
       (singultus.core/html ~@body))))

(defmacro defelem
  "Defines a function that will return a tag vector. If the first argument
  passed to the resulting function is a map, it merges it with the attribute
  map of the returned tag value."
  [name & fdecl]
  `(do
    (declare ~name)
    (let [func# (fn ~@fdecl)]
      (def ~name (singultus.compiler/add-optional-attrs func#)))))
