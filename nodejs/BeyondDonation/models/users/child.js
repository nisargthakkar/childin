'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getChild: function(userid, callback) {
        DBConnector.query("SELECT * FROM Child WHERE ID="+userid, callback);
    },
    getAllChild: function(callback) {
        DBConnector.query("SELECT * FROM Child", callback);;
    },
    insertChild: function(Name, GenderType, MaritalStatusType, DOB, CreatedOn, isActive, callback) {
        DBConnector.query("INSERT INTO Child (Name, GenderType, MaritalStatusType, DOB, CreatedOn, isActive) VALUES ('" + Name + "', '" + GenderType + "', '" + MaritalStatusType + "', '" + DOB + "', '" + CreatedOn + "', '" + isActive + "')", callback);
    }
}
