'use strict';

var AuthModel = require('../models/auth.js');


module.exports = function (router) {

    router.post('/', function (req, res) {
        AuthModel.authenticate(req.body.id, req.body.password, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

};
