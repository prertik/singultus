# singultus

Singultus is a fork of [crate](https://github.com/ibdknox/crate) which is
ClojureScript implementation of the awesome [Hiccup](https://github.com/weavejester/hiccup/) html templating library.

## Usage

```clojure
(ns myapp
 (:use-macros [singultus.def-macros :only [defpartial]])
 (:require [singultus.core :as singultus]))

(singultus/html [:p.woot {:id "blah"} "Hey!"])
=> <p class="woot" id="blah">Hey!</p>

(defpartial header []
 [:header
   [:h1 "My app!"]])

(header)
=> <header><h1>My app!</h1></header>

```

## Differences from Hiccup

* The singultus.core/html returns dom nodes instead of strings of html
* You can use dom nodes in element bodies like this:

```clojure
(singultus/html [:div (crate/raw "<span>foo</span><strong>bar</strong>")])
=> <div><span>foo</span><strong>bar</strong></div>
```

## License

Copyright (C) 2011 Chris Granger

Copyright (C) 2020 Pratik Karki

Distributed under the Eclipse Public License, the same as Clojure.
