package cordova-plugin-tapjoy-pro;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * This class echoes a string called from JavaScript.
 */
public class Tapjoy_Plugin extends CordovaPlugin {

    static {
        System.loadLibrary("TapjoyCpp_h");
    }

    Tapjoy_Plugin()  {
        initCppSide();
    }

    public static void setup(RequestSuccess requestSuccess,RequestError requestError,boolean debug,int userId, String appkey) {

        TapjoyCpp_h.setDebugEnabled(debug);

        TapjoyCpp_h.setUserID(userId);

        TapjoyCpp_h.connect(appkey);

    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
