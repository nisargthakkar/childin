'use strict';

var DBConnector = require('../lib/dbconnector');

module.exports = {
    authenticate: function(userid, password, callback) {
        DBConnector.query("SELECT * FROM DONATION WHERE DonorId="+donorid, callback);
    }
}