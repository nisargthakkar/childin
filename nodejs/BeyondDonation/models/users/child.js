'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getChild: function(userid, callback) {
        DBConnector.query("SELECT * FROM CHILD WHERE ID="+userid, callback);
    },
    getAllChild: function(callback) {
        DBConnector.query("SELECT * FROM CHILD", callback);;
    },
    insertChild: function(userid, info, callback) {
        DBConnector.query("INSERT INTO CHILD (id, name) VALUES (" + userid + ",'" + info + "\')", callback);
    }
}