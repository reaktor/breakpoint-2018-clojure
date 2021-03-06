(ns breakpoint-app.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
  :animation-enabled?
  (fn [db]
    (:animation/enabled? db)))

(reg-sub
  :background-color
  (fn [db]
    (:background-color db)))

(reg-sub
  :images
  (fn [db]
    (:images db)))
