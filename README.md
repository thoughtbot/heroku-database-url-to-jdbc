# heroku-database-url-to-jdbc

Useful for connecting your JDBC-using, Heroku-deployed Clojure application to Heroku's postgres service.

## Usage

Generate a JDBC connection string from a Heroku DATABASE_URL

    (heroku-database-url->jdbc-connection-string heroku-database-url)

Generate a [Korma](http://sqlkorma.com) connection map from a Heroku DATABASE_URL

    (heroku-database-url->korma-connection-map heroku-database-url)

## License

Copyright © 2014 Ben Orenstein and thoughtbot

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
