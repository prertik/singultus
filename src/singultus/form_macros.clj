(ns singultus.form-macros)

(defmacro with-group
  "Group together a set of related form fields for use with the Ring
  nested-params middleware."
  [group & body]
  `(binding [singultus.form/*group* (conj singultus.form/*group* (singultus.util/as-str ~group))]
     (list ~@body)))
