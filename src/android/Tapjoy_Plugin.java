package cordovaPluginTapjoyPro.TapjoyPlugin;

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
    public native void setDebugEnabled(boolean debug);
    public native void setUserID(int id);
    public native void connect(String appkey);


    public void setup(boolean debug,int userId, String appkey) {

        Tapjoy_Plugin tapjoy_plugin = new Tapjoy_Plugin();

        tapjoy_plugin.setDebugEnabled(debug);

        tapjoy_plugin.setUserID(userId);

        tapjoy_plugin.connect(appkey);

    }

}
