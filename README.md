# heroku-database-url-to-jdbc

Useful for connecting your JDBC-using, Heroku-deployed Clojure application to Heroku's postgres service.

## Basic Usage

To generate a JDBC connection string from a Heroku DATABASE_URL:
```clj
    (def database-url "postgres://user:pass@ec2-host:1234/path-to-db")

    (heroku-database-url->jdbc-connection-string database-url)

    ; => "jdbc:postgresql://ec2-host:1234?user=user&password=pass"
```

To generate a Korma-friendly connection map from a Heroku DATABASE_URL:
```clj
    (def database-url "postgres://user:pass@ec2-host:1234/path-to-db")

    (heroku-database-url->korma-connection-map database-url)

    ; {:classname "org.postgresql.Driver"
    ;  :subprotocol "postgresql"
    ;  :user "user"
    ;  :password "pass"
    ;  :subname "//host:1234/path-to-db"
```

## License

Copyright © 2014 Ben Orenstein and thoughtbot

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
