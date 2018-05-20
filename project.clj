(defproject breakpoint-app "0.1.0-SNAPSHOT"
  :description "Reaktor Breakpoint 2018 ClojureScript Workshop"
  :url "https://github.com/reaktor/breakpoint-2018-clojure"
  :license {:name "MIT"
            :url  "https://tldrlegal.com/license/mit-license"}

  :dependencies [[org.clojure/clojure "1.10.0-alpha4"]
                 [org.clojure/clojurescript "1.10.238" :scope "provided"]
                 [com.cognitect/transit-clj "0.8.309"]
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [ring/ring-codec "1.1.1"]
                 [ring/ring-json "0.4.0"]
                 [bk/ring-gzip "0.3.0"]
                 [radicalzephyr/ring.middleware.logger "0.6.0"]
                 [clj-logging-config "1.9.12"]
                 [compojure "1.6.1"]
                 [environ "1.1.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [org.danielsz/system "0.4.1"]
                 [org.clojure/tools.namespace "0.3.0-alpha4"]
                 [http-kit "2.3.0"]
                 [re-frame "0.10.5"]
                 [metosin/compojure-api "1.1.11"]
                 [org.clojure/data.json "0.2.6"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [prismatic/schema "1.1.9"]
                 [org.clojure/core.async "0.4.474"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-environ "1.1.0"]
            [lein-less "1.7.5"]]

  :min-lein-version "2.6.1"

  :source-paths ["src/clj" "src/cljs" "src/cljc"]

  :test-paths ["test/clj" "test/cljc"]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/js" "dev-target"]

  :uberjar-name "breakpoint-app.jar"

  ;; Use `lein run` if you just want to start a HTTP server, without figwheel
  :main breakpoint-app.application

  ;; nREPL by default starts in the :main namespace, we want to start in `user`
  ;; because that's where our development helper functions like (go) and
  ;; (browser-repl) live.
  :repl-options {:init-ns user}

  :cljsbuild {:builds
              [{:id           "app"
                :source-paths ["src/cljs" "src/cljc" "dev"]

                :figwheel     {:on-jsload "breakpoint-app.system/reset"}

                :compiler     {:main                 cljs.user
                               :asset-path           "js/compiled/out"
                               :output-to            "dev-target/public/js/compiled/breakpoint_app.js"
                               :output-dir           "dev-target/public/js/compiled/out"
                               :source-map-timestamp true
                               :closure-defines      {"re_frame.trace.trace_enabled_QMARK_" true}
                               :preloads             [day8.re-frame-10x.preload]}}

               {:id           "test"
                :source-paths ["src/cljs" "test/cljs" "src/cljc" "test/cljc"]
                :compiler     {:output-to     "dev-target/public/js/compiled/testable.js"
                               :main          breakpoint-app.test-runner
                               :optimizations :none}}

               {:id           "min"
                :source-paths ["src/cljs" "src/cljc"]
                :jar          true
                :compiler     {:main                 breakpoint-app.system
                               :output-to            "resources/public/js/compiled/breakpoint_app.js"
                               :output-dir           "target"
                               :source-map-timestamp true
                               :optimizations        :advanced
                               :closure-defines      {goog.DEBUG false}
                               :pretty-print         false}}]}

  :figwheel {:css-dirs       ["resources/public/css"]       ;; watch and update CSS
             :server-logfile "log/figwheel.log"}

  :doo {:build "test"}

  :less {:source-paths ["src/less"]
         :target-path  "resources/public/css"}

  :profiles {:dev
             {:dependencies [[figwheel "0.5.16"]
                             [figwheel-sidecar "0.5.16"]
                             [com.cemerick/piggieback "0.2.2"]
                             [org.clojure/tools.nrepl "0.2.13"]
                             [lein-doo "0.1.10"]
                             [reloaded.repl "0.2.4"]
                             [day8.re-frame/re-frame-10x "0.3.3"]]

              :plugins      [[lein-auto "0.1.3"]
                             [lein-figwheel "0.5.16"]
                             [lein-doo "0.1.10"]]

              :source-paths ["dev"]
              :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}

             :uberjar
             {:source-paths ^:replace ["src/clj" "src/cljc"]
              :prep-tasks   ["compile"
                             ["cljsbuild" "once" "min"]]
              :hooks        [leiningen.less]
              :omit-source  true
              :aot          :all}})