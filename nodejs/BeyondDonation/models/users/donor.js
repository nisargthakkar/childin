'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getDonor: function(userid, callback) {
        DBConnector.query("SELECT * FROM DONOR WHERE ID="+userid, callback);
    },
    getAllDonor: function(callback) {
        DBConnector.query("SELECT * FROM DONOR", callback);;
    },
    insertDonor: function(userid, info, callback) {
        DBConnector.query("INSERT INTO DONOR (id, name) VALUES (" + userid + ",'" + info + "\')", callback);
    }
}