(ns heroku-database-url-to-jdbc.core)

(defn- parse-user-and-password [db-uri]
  (clojure.string/split (.getUserInfo db-uri) #":"))

(defn- subname [db-uri]
  (format "//%s:%s%s" (.getHost db-uri) (.getPort db-uri) (.getPath db-uri)))

(defn heroku-database-url->jdbc-connection-map
  "Converts Heroku's DATABASE_URL to a JDBC-friendly connection map"
  [heroku-database-url]
  (let [db-uri (java.net.URI. heroku-database-url)
        [user password] (parse-user-and-password db-uri)]
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"
     :user user
     :password password
     :subname (subname db-uri)}))
