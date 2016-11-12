'use strict';

var DonorModel = require('../models/users/donor.js');


module.exports = function (router) {

    router.get('/:id', function (req, res) {
        DonorModel.getDonor(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, {err : "Can't add donor details"})
          }
        });
    });

    router.get('/', function (req, res) {
        var model = DonorModel.getAllDonor(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, {err : "Can't add donor details"})
          }
        });
    });

    router.post('/:id', function (req, res){
      DonorModel.insertDonor(req.params.id, req.body.info, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, {err : "Can't add donor details"});
        }
      });

    });

};
