'use strict';

var DBConnector = require('../../lib/dbconnector');

module.exports = {
    getDonor: function(userid, callback) {
        DBConnector.query("SELECT * FROM Donor WHERE DonorId="+userid, callback);
    },
    getDonorByName: function(name, callback) {
        DBConnector.query("SELECT * FROM Donor WHERE Name="+name, callback);
    },
    getAllDonor: function(callback) {
        DBConnector.query("SELECT * FROM Donor", callback);
    },
    insertDonor: function(Name, GenderType, MaritalStatusType, DOB, Address, TelephoneNo, MobileNo, Email, WeddingAnniversaryDate, DonatedOn, isActive, callback) {
        DBConnector.query("INSERT INTO Donor (Name, GenderType, MaritalStatusType, DOB, Address, TelephoneNo, MobileNo, Email, WeddingAniversayDate, DonatedOn, isActive) VALUES ('" + Name + "', '" + GenderType + "', '" + MaritalStatusType + "', '" + DOB + "', '" + Address + "', '" + TelephoneNo + "', '" + MobileNo + "', '" + Email + "', '" + WeddingAnniversaryDate + "', '" + DonatedOn + "', '" + isActive + "')", callback);
    }
}