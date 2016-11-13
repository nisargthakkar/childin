// Twilio Credentials 
var accountSid = ''; 
var authToken = ''; 
 
//require the Twilio module and create a REST client 
var client = require('twilio')(accountSid, authToken); 

var smsservice = function(to, body){
	console.log(to, body);
	
	var sms = { 
		to: to, //one at a time in loop
		from: "+19712526966", 
		body: body   
	};
	return new Promise((resolve, reject) => {
		client.messages.create(sms, function(error, message) { 
	    	if(error){
	    		console.log(error);
	        	reject(error);
	    	} else {
		    	var res = message.sid;
		    	console.log('Message sent: ' + res);
		    	resolve(res);
		    }
	    });
	});
};

module.exports = smsservice;