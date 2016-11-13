'use strict';

var IndexModel = require('../models/index'),
    DBConnector = require('../lib/dbconnector');

module.exports = function (router) {

    var model = new IndexModel();

    router.get('/', function (req, res) {
        
        // DBConnector.query('SELECT * FROM DONOR', function(err, model){
            res.render('index', model);
        // });
        
    });

};
