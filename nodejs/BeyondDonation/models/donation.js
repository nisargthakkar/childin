'use strict';

var DBConnector = require('../lib/dbconnector');

module.exports = {
    getDonationByDonorId: function(donorid, callback) {
        DBConnector.query("SELECT * FROM DONATION WHERE DonorId="+donorid, callback);
    },
    getDonationByChildId: function(childid, callback) {
        DBConnector.query("SELECT * FROM DONATIONS WHERE DonatedTo="+childid, callback);
    },
    getAllDonation: function(callback) {
        DBConnector.query("SELECT * FROM DONATION", callback);
    },
    insertDonation: function(info, callback) {
        DBConnector.query("INSERT INTO DONATION (name) VALUES ('" + info + "')", callback);
    }
}