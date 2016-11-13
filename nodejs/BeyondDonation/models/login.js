'use strict';

var DBConnector = require('../lib/dbconnector');

module.exports = {
    authenticate: function(Emailid, password, callback) {
        DBConnector.query("SELECT password FROM Donor WHERE Email='" + Emailid +"'", function(err, res){
        	if(!err){
        		if(res[0].password == password)
        			callback(null, {EmailId : Emailid});
        		else
        			callback(true);
        	}
        	else
        		callback(err);
        });
    }
}