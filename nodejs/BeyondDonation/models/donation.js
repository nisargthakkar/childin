'use strict';

var DBConnector = require('../lib/dbconnector');

module.exports = {
    getDonationByDonorId: function(donorid, callback) {
        DBConnector.query("SELECT * FROM Donation WHERE DonorId="+donorid, callback);
    },
    getDonationByChildId: function(childid, callback) {
        DBConnector.query("SELECT * FROM Donation WHERE DonatedTo="+childid, callback);
    },
    getAllDonation: function(callback) {
        DBConnector.query("SELECT * FROM Donation", callback);
    },
    insertDonation: function(DonorId, DonatedTo, Amount, DonatedOn, callback) {
        DBConnector.query("INSERT INTO Donation (DonorId, DonatedTo, Amount, DonatedOn) VALUES ('" + DonorId + "', '" + DonatedTo + "', '" + Amount + "', '" + DonatedOn + "')", callback);
    }
}