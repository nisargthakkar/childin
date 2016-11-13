'use strict';

var DonorModel = require('../../models/users/donor.js');


module.exports = function (router) {

    router.get('/:id', function (req, res) {
        DonorModel.getDonor(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/', function (req, res) {
        var model = DonorModel.getAllDonor(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.post('/', function (req, res){
      DonorModel.insertDonor(req.body.Name, req.body.GenderType, req.body.MaritalStatusType, req.body.DOB, req.body.Address, req.body.TelephoneNo, req.body.MobileNo, req.body.Email, req.body.WeddingAnniversaryDate, req.body.DonatedOn, req.body.isActive, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });

    });

    router.patch('/:id', function (req, res){
      DonorModel.updateDonor(req.body.Name, req.body.GenderType, req.body.MaritalStatusType, req.body.DOB, req.body.Address, req.body.TelephoneNo, req.body.MobileNo, req.body.Email, req.body.WeddingAnniversaryDate, req.body.DonatedOn, req.body.isActive, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });

    });

    router.delete('/:id', function (req, res){
      DonorModel.deleteDonor(req.params.id, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });

    });

};
