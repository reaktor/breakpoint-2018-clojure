(ns breakpoint-app.db)

(def default-db
  {:requests-ongoing 0
   :images []
   :saved-images []
   :search-input ""
   :animation/tilt-direction :left
   :animation/enabled? true})
