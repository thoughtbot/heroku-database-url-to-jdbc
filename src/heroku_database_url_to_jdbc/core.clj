(ns heroku-database-url-to-jdbc.core)

(defn- create-uri [url] (java.net.URI. url))

(defn- parse-username-and-password [db-uri]
  (clojure.string/split (.getUserInfo db-uri) #":"))

(defn- subname [db-uri]
  (format "//%s:%s%s" (.getHost db-uri) (.getPort db-uri) (.getPath db-uri)))

(defn heroku-database-url->jdbc-connection-string
  "Converts Heroku's DATABASE_URL to a JDBC-friendly connection string"
  [heroku-database-url]
  (let [db-uri (create-uri heroku-database-url)
        [username password] (parse-username-and-password db-uri)]
    (format "jdbc:postgresql:%s?user=%s&password=%s"
            (subname db-uri)
            username
            password)))

(defn heroku-database-url->korma-connection-map
  "Converts Heroku's DATABASE_URL to a map that you can pass to Korma's
  defdb fn"
  [heroku-database-url]
  (let [db-uri (create-uri heroku-database-url)
        [user password] (parse-username-and-password db-uri)]
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"
     :user user
     :password password
     :subname (subname db-uri)}))
