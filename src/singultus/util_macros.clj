(ns singultus.util-macros)

(defmacro with-base-url
  "Add a base-url that will be added to the output of the to-uri function."
  [base-url & body]
  `(binding [singultus.util/*base-url* ~base-url]
     ~@body))
