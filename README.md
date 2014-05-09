# heroku-database-url-to-jdbc

Useful for connecting your JDBC-using, Heroku-deployed Clojure application to Heroku's postgres service.

## Usage

You probably want to use this library like this:

  (defn jdbc-connection-string []
    (if-let [database-url (System/getenv "DATABASE_URL")]
      (heroku-database-url->jdbc-connection-string database-url)
      (local-database-connection-string)))

Or, if you're using [Korma](http://sqlkorma.com):

  (defn db-spec []
    (if-let [database-url (System/getenv "DATABASE_URL")]
      (heroku-database-url->korma-connection-map database-url)
      local-database-map))

  (defdb db (db-spec))

More concretely, this library consists of two public functions.

To generate a JDBC connection string from a Heroku DATABASE_URL:
```clj
    (heroku-database-url->jdbc-connection-string database-url)

    ; => "jdbc:postgresql://host:1234?user=username&password=password"
```

To generate a Korma connection map from a Heroku DATABASE_URL:
```clj
    (heroku-database-url->korma-connection-map database-url)

    ; {:classname "org.postgresql.Driver"
    ;  :subprotocol "postgresql"
    ;  :user "user"
    ;  :password "password"
    ;  :subname //host:1234/path-to-db
```

## License

Copyright © 2014 Ben Orenstein and thoughtbot

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
