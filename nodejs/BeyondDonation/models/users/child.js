'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getChild: function(userid, callback) {
        DBConnector.query("SELECT * FROM Child WHERE ChildId="+userid, callback);
    },
    getAllChild: function(callback) {
        DBConnector.query("SELECT * FROM Child", callback);;
    },
    insertChild: function(Name, GenderType, DOB, Description, callback) {
        DBConnector.query("INSERT INTO Child (Name, GenderType, DOB, Description) VALUES ('" + Name + "', '" + GenderType + "', '" + DOB  + "', '" + Description + "')", callback);
    }
}
