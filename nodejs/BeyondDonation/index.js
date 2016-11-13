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
