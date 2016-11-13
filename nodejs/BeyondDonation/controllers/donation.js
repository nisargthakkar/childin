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

    router.get('/history', function (req, res) {
        var model = DonationModel.getDonationHistory(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/topten', function (req, res) {
        var model = DonationModel.getToptepDonation(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.post('/', function (req, res){
      DonationModel.insertDonation(req.body.DonorId, req.body.ChildId, req.body.Amount, req.body.DonatedOn, req.body.description, function(err, model){
        if(!err){
          res.status(200);
          res.send({SUCCESS: true, DonationId: model.insertId, message: 'donation insterted successfully'});
        }
        else {
          res.send(500, err);
        }
      });

    });

};
