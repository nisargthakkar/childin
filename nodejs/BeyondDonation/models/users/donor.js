'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getDonor: function(userid, callback) {
        DBConnector.query("SELECT * FROM DONOR WHERE DonorID="+userid, callback);
    },
    getDonorByName: function(name, callback) {
        DBConnector.query("SELECT * FROM DONOR WHERE Name="+name, callback);
    },
    getAllDonor: function(callback) {
        DBConnector.query("SELECT * FROM DONOR", callback);
    },
    insertDonor: function(info, callback) {
        DBConnector.query("INSERT INTO DONOR (name) VALUES ('" + info + "\')", callback);
    }
}