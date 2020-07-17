package com.example.bumpapp;

import android.support.v4.app.INotificationSideChannel;

public class IBumpAPI {
    public static INotificationSideChannel.Stub Stub;

    public String userIDForChannelID(long channelID) {
        return null;
    }

    public void confirm(long proposedChannelID, boolean b) {

    }

    public void send(long channelID, byte[] bytes) {
    }

    public void enableBumping() {
    }

    public void configure(String your_api_key, String bump_user) {
    }

    //insert api key here
    IBumpAPI() {
        new String("your_api_key");
        new String("bump_user");
    }
}
