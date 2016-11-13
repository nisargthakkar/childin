'use strict';

var express = require('express');
var kraken = require('kraken-js');
var dbconnector = require('./lib/dbconnector');

var options, app;

/*
 * Create and configure application. Also exports application instance for use by tests.
 * See https://github.com/krakenjs/kraken-js#options for additional configuration options.
 */
options = {
    onconfig: function (config, next) {
        /*
         * Add any additional config setup or overrides here. `config` is an initialized
         * `confit` (https://github.com/krakenjs/confit/) configuration object.
         */
        next(null, config);
    }
};

app = module.exports = express();
app.use(kraken(options));

var fs = require('fs');
var http = require("https");
var path = require('path');
var http = require("http");
var url = require("url");
var req = require('request')
var pem = require('pem');
var cors = require("cors");
 
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.use(express.static(path.join(__dirname, '../')));
 
app.listen(process.env.PORT || 8080);
 
app.options('*', cors());
 
app.all('/*', function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "http://localhost:8080");
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header("Access-Control-Allow-Headers", "X-Requested-With,     Content-Type");
    next();
});
 
app.get('/', function (req, res) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.writeHead(200, {'Content-Type': 'text/plain'});
    contents = fs.readFileSync("sliderImages.json", "utf8");
    console.log(path.join(__dirname, '/sliderImages.json'));
    res.end(contents);
});

app.on('start', function () {
    console.log('Application ready to serve requests.');
    console.log('Environment: %s', app.kraken.get('env:env'));
    dbconnector.createConnection();

    var CronJob = require('cron').CronJob;
    var job = new CronJob('00 00 09 * * *', function() {
    /*
    * Runs every day
    * at 9:00:00 AM.
    */
    
    }, function () {
        /* This function is executed when the job stops */
    },
    true, /* Start the job right now */
    'Asia/Kolkata' /* Time zone of this job. */
    );
    job.start();

});
