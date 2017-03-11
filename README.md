# cordova-plugin-tapjoy
Tapjoy ads for Apache Cordova

###### WARNING: This plugin available only for iOS.

# Install plugin

```
$ cordova plugin add cordova-plugin-tapjoy
```

The plugin.xml doesn't have ablity to put embedded frameworks to your project automaticly (or I didn't find the solution), so find Tapjoy.embeddedFramework in sources (src/ios) and drag & drop it to the directory into Xcode under Frameworks.

IMPORTANT: The Tapjoy.embeddedframework folder should be added as a group (yellow folder) and not as a reference (blue folder).

# Methods

#### Tapjoy.setup(success_cb, error_cb, debugMode, userID, appKey)
Initial method wich connect to Tapjoy.  
(boolean) debugMode - if set to true you could see debug output from Tapjoy SDK.  
(string) userID - the unique userID need if you use self managed currency otherwise it should be null.  
(string) appKey - the appKey of your app in Tapjoy Dashboard.

#### Tapjoy.setUserID(userID)
Additional method to set unique userID.  
You can use this method to set or edit userID whenever after tapjoy already connected.
(string) userID

#### Tapjoy.createPlacement(success_cb, error_cb, name)
###### IMPORTANT: Create for every type of ad new placement in your Tapjoy Dashboard.  
In Tapjoy you can have many placements and types like Rewarded Videos, Skippable Videos, Offerwall etc.  
You need to initialize every placements you have, using this method.  
(string) - name of your placement

#### Tapjoy.requestContent(success_cb, error_cb, name)
When success callback was emitted you can show an ad.  
(string) - name of your placement

#### Tapjoy.showContent(success_cb, error_cb, name)
Show an ad.  
(string) - name of your placement

# Example

In this sample I use [async.js](https://caolan.github.io/async/docs.html#each) but you can use what you want.

```js
import async from 'async';

let appKey = 'TapjoyAppKey';
let userID = "Unique ID can be null";
let debugMode = true;
let tapjoyPlacements = ['MyOfferwall', 'MyRewardedVideo', 'MySkippableVideo']

Tapjoy.setup(() => {
  async.each(tapjoyPlacements, (placement, callback) => {
    Tapjoy.createPlacement(() => {
      callback();
    }, (error) => {
      callback(error)
    }, placement);
  }, (error) => {
    if (error) {
      console.log(error);
    } else {     
      Tapjoy.requestContent(() => {
        Tapjoy.showContent(() => {
          console.log('User watched an ad');
        }, (error) => {
          console.log(error);
        }, tapjoyPlacements[0]);
      }, (error) => {
        console.log(error);        
      }, tapjoyPlacements[0])
    }
  })  
}, (error) => {
  console.log(error);
}, debugMode, userID, appKey)
```

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=QVU9KQVD2VZML)