'use strict';

var DonorModel = require('../../models/users/donor.js');


module.exports = function (router) {

    router.get('/:id', function (req, res) {
        DonorModel.getDonor(req.params.id, function(err, model){
          if(!err){
            res.json(model);
          }
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/', function (req, res) {
        DonorModel.getAllDonor(function(err, model){
          if(!err){
            res.json(model);
          }
          else {
            res.send(500, err)
          }
        });
    });

    router.post('/', function (req, res){
      DonorModel.insertDonor(req.body.Name, req.body.GenderType, req.body.MaritalStatusType || "NA", req.body.DOB, req.body.Address, 
      req.body.TelephoneNo || "", req.body.MobileNo, req.body.Email, req.body.WeddingAniversayDate || '1970-01-01', req.body.isActive, function(err, model){
        if(!err) {
          res.status(200);
          res.send({SUCCESS: true, DonorId: model.insertId, message: 'User Registered Successfully'});
        }
        else {
          res.send(500, err);
        }
      });

    });

};
