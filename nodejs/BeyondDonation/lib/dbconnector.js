var mysql = require('mysql');
module.exports = {
    query: function(query, callback) {
        var connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'root',
            database : 'childin'
        });

        connection.connect();

        connection.query(query, function (err, rows, fields) {
            connection.end();
            if (err) return callback(err);

            return callback(null, rows);
        })
    }

}