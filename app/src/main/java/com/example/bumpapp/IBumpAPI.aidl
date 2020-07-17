package com.example.bumpapp;

interface IBumpAPI {
/*Parameters:
apiKey: "your_bump_api_key". Get one from http://bu.mp/apiagree
ensure that this key is moved to Production mode before shipping.
http://bu.mp/apideveloper
userID: an ID which makes sense to the user in the context of the application.
Simpler apps often use the device's name or user's name.
*/
void configure(in String key, in String userID);

//Returns the other user's ID on a given channel, if it does exist.
String userIDForChannelID(in long channelID);

//Enable Bump Detection, which will either get MATCHED or NOT_MATCHED intents.
void enableBumping();
//Disable bump detection.
void disableBumping();

//Confirm a match with another user.
void confirm(in long channelID, in boolean result);

//Send data to a channel. Should only be called after receiving a CHANNEL_CONFIRMED Intent.
void send(in long channelID, in byte[] data);

/*For Debug purposes only
*Trigger Bump */
void simulateBump();
}