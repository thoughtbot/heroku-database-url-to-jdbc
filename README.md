# heroku-database-url-to-jdbc

Useful for connecting your JDBC-using, Heroku-deployed Clojure application to Heroku's postgres service.

## Basic Usage

To generate a JDBC connection string from a Heroku DATABASE_URL:
```clj
    (ns example
      (:require [heroku-database-url-to-jdbc.core :as h]))

    (def database-url "postgres://user:pass@ec2-host:1234/path-to-db")

    (h/jdbc-connection-string database-url)

    ; => "jdbc:postgresql://ec2-host:1234?user=user&password=pass"
```

To generate a [Korma](http://sqlkorma.com)-friendly connection map from a Heroku DATABASE_URL:
```clj
    (ns example
      (:require [heroku-database-url-to-jdbc.core :as h]))

    (def database-url "postgres://user:pass@ec2-host:1234/path-to-db")

    (h/korma-connection-map database-url)

    ; {:classname "org.postgresql.Driver"
    ;  :subprotocol "postgresql"
    ;  :user "user"
    ;  :password "pass"
    ;  :subname "//host:1234/path-to-db"
```

## Installation

Add to your `project.clj`'s `:dependencies` section:

```clj
[heroku-database-url-to-jdbc "0.2.2"]
```

## License

Copyright © 2014 Ben Orenstein and thoughtbot

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
