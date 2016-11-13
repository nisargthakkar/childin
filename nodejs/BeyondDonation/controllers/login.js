'use strict';


module.exports = function (router) {

	router.get('/login', function (req, res) {
		var test = '<form action="/login" method="post"><div><label>Username:</label><input type="text" name="username"/></div><div><label>Password:</label><input type="password" name="password"/></div>';
		test += '<div><input type="submit" value="Log In"/></div></form>';
		res.render(test);
	});

	router.post('/login',
  passport.authenticate('local', { successRedirect: '/',
                                   failureRedirect: '/login',
                                   failureFlash: true })
);
};
