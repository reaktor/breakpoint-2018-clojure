(ns breakpoint-app.animation.animation-subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub :animation/tilt-direction
  (fn [db]
    (:animation/tilt-direction db)))
