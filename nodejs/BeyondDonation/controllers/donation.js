'use strict';

var DonationModel = require('../models/donation.js');


module.exports = function (router) {

    router.get('/donor/:id', function (req, res) {
        DonationModel.getDonoationByDonorId(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/child/:id', function (req, res) {
        var model = DonationModel.getDonoationByChildId(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/', function (req, res) {
        var model = DonationModel.getAllDonation(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.post('/', function (req, res){
      DonationModel.insertDonation(req.body.DonorId, req.body.DonatedTo, req.body.Amount, req.body.DonatedOn, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });

    });

};
