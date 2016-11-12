'use strict';

var ChildModel = require('../models/users/child.js');


module.exports = function (router) {

    router.get('/:id', function (req, res) {
        ChildModel.getChild(req.params.id, function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, {err : "Can't add child details"})
          }
        });
    });

    router.get('/', function (req, res) {
        var model = ChildModel.getAllChild(function(err, model){
          if(!err)
            res.json(model);
          else {
            res.send(500, {err : "Can't add child details"})
          }
        });
    });

    router.post('/:id', function (req, res){
      ChildModel.insertChild(req.params.id, req.body.info, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, {err : "Can't add child details"});
        }
      });

    });

};
