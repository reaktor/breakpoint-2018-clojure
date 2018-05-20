# Reaktor Breakpoint 2018 ClojureScript Workshop

In order to participate to this workshop please ensure that you have following preliminaries done.

## Install Java 8

Please refer to [this StackOverflow post](https://stackoverflow.com/a/28635465) for Mac OS instructions. If you use Java 9 please ensure that you have the latest Leiningen version installed.

## Install Leiningen

Leiningen is the project management tool for Clojure (much like Node's npm). Please download it from https://leiningen.org/ .

Mac OS users who have HomeBrew installed can alternatively install it using command

```
brew install leiningen
``` 

## Clone This Repository

Please clone this repository. Then run following command in the repository root to download all the required dependencies beforehand:

```
lein deps
```

When the workshop starts we will publish the application template in this git repository. We suggest that you set up the remote tracking branch for master in order to be able to pull it:

```
git branch --set-upstream-to=origin/master
git pull --rebase
```

## Install a Clojure Editor

Please ensure that you have at least one Clojure editor installed and set up before the workshop. You aren't restricted to editors mentioned here. You can use any other Clojure editor of your choice too.

### LightTable

1. The editor can be downloaded from http://lighttable.com/ .
2. Start the application.
3. Press CTRL + space to open the right-side menu.
4. Find the `Plugins: Show plugin manager` and select it.
5. Please ensure that you have the `ClojureInstarepl` plugin installed. You might need to restart LightTable after installing it.
6. Open the right-side menu again.
7. Select `Instarepl: Open a clojure instarepl`.
8. When done for the first time this should make LightTable to download all Clojure core dependencies. You can test if the REPL is working by typing `(+ 1 2 3)` to the REPL window.

### IntelliJ IDEA + Cursive

1. You can find installation instructions from https://cursive-ide.com/userguide/ .
2. After installing Cursive import this repository as a project in IDEA (`File` -> `New` -> `Project from Existing Sources`).
3. Select `Import project from external model` and select `Leiningen`.
4. Click `next` until you see a dialog that shows the `breakpoint-app.0.1.0-SNAPSHOT` being selected.
5. Click `next` and ensure that you have a SDK version `1.8` selected.
6. Click `next` until you can click `finish`.
7. From the top bar menu select `Run` -> `Edit configurations...`.
8. From the top-left corner of the window, click `+` -> `Clojure REPL` -> `Local`.
9. Write `Local REPL` to the name text field.
10. Click `ok`.
11. Run the `Local REPL` run configuration. You should be able to do it from the top bar of IntelliJ IDEA. Alternatively from the top bar menu select `Run` -> `Run...` -> `Local REPL`.
12. When the REPL window outputs `nREPL server started` you should be able to type `(+ 1 2 3)` to the lowest part of the dialog window and see `=> 6` as output.
