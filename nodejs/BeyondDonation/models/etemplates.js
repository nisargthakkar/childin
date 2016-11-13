'use strict';

var DBConnector = require('../lib/dbconnector');

module.exports = {
    inserttemplates: function(templateName, templateStructure, callback) {
        DBConnector.query("SELECT * FROM Donation WHERE DonorId="+templateName, callback);
    },
    getByTemplateName: function(templateName, callback) {
        DBConnector.query("SELECT * FROM Donation WHERE DonorId="+templateName, callback);
    }
}