'use strict';

var passport = require('passport')
  , LocalStrategy = require('passport-local').Strategy;

var DBConnector = require('../../lib/dbconnector');

passport.use(new LocalStrategy(function(Email, password, done) {
  process.nextTick(function() {
        var userDetail = DBConnector.query("SELECT Email,password FROM Donor WHERE Email="+Email, function(err, user) {
      if (err) {
        return done(err);
      }

      if (!userDetail.Email) {
        return done(null, false);
      }

      if (userDetail.password != password) {
        return done(null, false);
      }

      return done(null, user);
    });
    
  });
}));


module.exports = function (router) {

	router.get('/', function (req, res) {
		var test = '<form action="/login" method="post"><div><label>Username:</label><input type="text" name="username"/></div><div><label>Password:</label><input type="password" name="password"/></div>';
		test += '<div><input type="submit" value="Log In"/></div></form>';
		res.send(test);
	});

	router.post('/',
  passport.authenticate('local', { successRedirect: '/',
                                   failureRedirect: '/login',
                                   failureFlash: true })
);
};
