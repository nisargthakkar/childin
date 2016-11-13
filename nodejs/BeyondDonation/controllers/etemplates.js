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
      etemplatesModel.insertetemplates(req.params.templateName, req.body.Subject, req.body.Description, req.body.isActive, function(err, model){
        if(!err){
          res.status(200);
          res.send({SUCCESS: true, TemplateId: model.insertId, message: 'template insterted successfully'});
        }
        else {
          res.send(500, err);
        }
      });
    });

};
