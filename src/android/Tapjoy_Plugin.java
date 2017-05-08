package cordovaPluginTapjoyPro;

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

    private native void initCppSide();

    public static void setup(boolean requestSuccess,boolean requestError,boolean debug,int userId, String appkey) {

        Tapjoy_Plugin.setDebugEnabled(debug);

        Tapjoy_Plugin.setUserID(userId);

        Tapjoy_Plugin.connect(appkey);

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
