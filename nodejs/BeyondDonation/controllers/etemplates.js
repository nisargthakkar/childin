'use strict';

var etemplatesModel = require('../models/etemplates.js');

module.exports = function (router) {

  router.get('/:templateName', function (req, res){
    etemplatesModel.getByTemplateName(templateName, function(err, model){
      if(!err)
        res.send(model)
      else {
        res.send(500, err);
      }
    });
  });

    router.post('/:templateName', function (req, res){
      etemplatesModel.insertetemplates(req.params.templateName, req.body.info, function(err, model){
        if(!err)
          res.sendStatus(200);
        else {
          res.send(500, err);
        }
      });
    });

};
