'use strict';

var AuthModel = require('../models/login.js');


module.exports = function (router) {

    router.post('/', function (req, res) {
    	console.log(req.body);
        AuthModel.authenticate(req.body.EmailId, req.body.password, function(err, model){
          if(!err){
          res.status(200);
          res.send({SUCCESS: true, EmailId: model.EmailId});
        }
          else {
            res.send(500, err);
          }
        });
    });

};
