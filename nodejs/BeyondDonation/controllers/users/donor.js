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
      DonorModel.insertDonor(req.body.Name, req.body.GenderType, req.body.MaritalStatusType || "", req.body.DOB, req.body.Address, req.body.TelephoneNo || "", req.body.MobileNo, req.body.Email,req.body.password || "password", req.body.WeddingAniversayDate, req.body.isActive || "1", function(err, model){
        if(!err){
          res.status(200);
          res.send({SUCCESS: true, DonorId: model.insertId, message: 'donor insterted successfully'});
        }
        else {
          res.send(500, err);
        }
      });

    });

    router.post('/update', function (req, res){
      DonorModel.updateDonor(req.body.old, req.body.Name, req.body.GenderType, req.body.MaritalStatusType, req.body.DOB, req.body.Address, req.body.password, req.body.TelephoneNo || "", req.body.MobileNo, req.body.Email, req.body.WeddingAnniversaryDate, req.body.DonatedOn, req.body.isActive || "1", function(err, model){
        if(!err){
          res.status(200);
          res.send({SUCCESS: true, message: 'donor updated successfully'});
        }
        else {
          res.send(500, err);
        }
      });

    });

    router.post('/delete', function (req, res){
      DonorModel.deleteDonor(req.body.Email, function(err, model){
        if(!err){
          res.status(200);
          res.send({SUCCESS: true, message: 'donor deletesssss successfully'});
        }
        else {
          res.send(500, err);
        }
      });

    });

};
