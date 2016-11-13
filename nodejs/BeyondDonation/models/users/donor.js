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
    insertDonor: function(Name, GenderType, MaritalStatusType, DOB, Address, TelephoneNo, MobileNo, Email, password, WeddingAnniversaryDate, isActive, callback) {
        console.log("INSERT INTO Donor (Name, GenderType, MaritalStatusType, DOB, Address, password, TelephoneNo, MobileNo, Email, WeddingAniversayDate, isActive) VALUES ('" + Name + "', '" + GenderType + "', '" + MaritalStatusType + "', '" + DOB + "', '" + Address + "', '" + password + "', '" + TelephoneNo + "', '" + MobileNo + "', '" + Email + "', '" + WeddingAnniversaryDate + "', '" + isActive + "')");
        DBConnector.query("INSERT INTO Donor (Name, GenderType, MaritalStatusType, DOB, Address, password, TelephoneNo, MobileNo, Email, WeddingAniversayDate, isActive) VALUES ('" + Name + "', '" + GenderType + "', '" + MaritalStatusType + "', '" + DOB + "', '" + Address + "', '" + password + "', '" + TelephoneNo + "', '" + MobileNo + "', '" + Email + "', '" + WeddingAnniversaryDate + "', '" + isActive + "')", callback);
    },
    updateDonor: function(oldEmail, Name, GenderType, MaritalStatusType, DOB, Address, TelephoneNo, MobileNo, Email, password, WeddingAnniversaryDate, isActive, callback) {
        DBConnector.query("update Donor set (Name, GenderType, MaritalStatusType, DOB, Address, TelephoneNo,MobileNo, Email, password, WeddingAniversayDate, IsActive) VALUES ('" + Name + "', '" + GenderType + "', '" + MaritalStatusType + "', '" + DOB + "', '" + Address + "', '" + password + "', '" + TelephoneNo + "', '" + MobileNo + "', '" + Email + "', '" + WeddingAnniversaryDate + "', '" + isActive + "' WHERE Email= '" + oldEmail + "')", callback);
    }
}