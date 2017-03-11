var Tapjoy = {
	setup: function(success_cb, error_cb, debugMode, userID, appKey) {
		cordova.exec(success_cb, error_cb, 'TapjoyPlugin', 'setup', [debugMode, userID, appKey]);
	},
	setUserID: function(userID) {
		cordova.exec(null, null, 'TapjoyPlugin', 'setUserID', [userID]);
	},	
	createPlacement: function(success_cb, error_cb, name){
		cordova.exec(success_cb, error_cb, 'TapjoyPlugin', 'createPlacement', [name]);
	},
	requestContent: function(success_cb, error_cb, name){
		cordova.exec(success_cb, error_cb, 'TapjoyPlugin', 'requestContent', [name]);
	},
	showContent: function(success_cb, error_cb, name){
		cordova.exec(success_cb, error_cb, 'TapjoyPlugin', 'showContent', [name]);
	}
};

module.exports = Tapjoy;