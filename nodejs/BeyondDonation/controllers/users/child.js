'use strict';

var ChildModel = require('../../models/users/child.js');


module.exports = function (router) {

    router.get('/:id', function (req, res) {
        ChildModel.getChild(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.get('/', function (req, res) {
        var model = ChildModel.getAllChild(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, err)
          }
        });
    });

    router.post('/', function (req, res){
      ChildModel.insertChild(req.body.Name, req.body.GenderType, req.body.MaritalStatusType, req.body.DOB, req.body.CreatedOn, req.body.isActive, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });

    });

};
