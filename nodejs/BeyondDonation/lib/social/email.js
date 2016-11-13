var nodemailer = require('nodemailer');
var serviceProvider = {
	gmail: {
		pool: true,
		service: 'gmail',
		auth: {
			user: '',
			pass: ''
		}
	}
};

var transporter = nodemailer.createTransport(serviceProvider.gmail);

// setup e-mail data with unicode symbols

/*
var sender = '"Childin" <saganeriwal@gmail.com>';
var receivers = ['rishav006@gmail.com']; //array
var subject = 'fsdf';
var text = 'fsfd';

var mailOptions = {
    from: sender, // sender address
    to: receivers, // list of receivers
    subject: subject, // Subject line
    text: text // plaintext body
};
*/

// send mail with defined transport object
var emailservice = function(mailOptions){
	console.log(mailOptions);

	return new Promise((resolve, reject) => {
		transporter.sendMail(mailOptions, function(error, info){
	    	if(error){
	    		console.log(error);
	        	reject(error);
	    	} else {
		    	var res = info.response;
		    	console.log('Message sent: ' + res);
		    	resolve(res);
		    }
	    });
	});
};

module.exports = emailservice;