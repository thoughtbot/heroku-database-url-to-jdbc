(ns heroku-database-url-to-jdbc.core-test
  (:require [clojure.test :refer :all]
            [heroku-database-url-to-jdbc.core :refer :all]))

(def heroku-database-url "postgres://user:pass@host:1234/path")

(deftest test-heroku-database-url->korma-connection-map
  (is (= {:classname "org.postgresql.Driver"
          :subprotocol "postgresql"
          :user "user"
          :password "pass"
          :subname "//host:1234/path"}
         (heroku-database-url->korma-connection-map heroku-database-url))))

(deftest test-heroku-database-url->jdbc-connection-string
  (is (= "jdbc:postgresql://host:1234/path?user=user&password=pass"
         (heroku-database-url->jdbc-connection-string heroku-database-url))))
