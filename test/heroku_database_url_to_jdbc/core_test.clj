(ns heroku-database-url-to-jdbc.core-test
  (:require [clojure.test :refer :all]
            [heroku-database-url-to-jdbc.core :refer :all]))

(deftest test-heroku-database-url->jdbc-connection-map
  (is (= {:classname "org.postgresql.Driver"
          :subprotocol "postgresql"
          :user "user"
          :password "pass"
          :subname "//host:1234/path"}
         (heroku-database-url->jdbc-connection-map "postgres://user:pass@host:1234/path"))))
