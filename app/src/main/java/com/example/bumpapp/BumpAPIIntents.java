package com.example.bumpapp;

public class BumpAPIIntents {
    //Broadcast when the api has successfully connected to the server
    public static final String CONNECTED = "com.bumptech.api.connected";
    //Broadcast when the api has been disconnected from the server.
    public static final String DISCONNECTED = "com.bumptech.api.disconnected";
    //Broadcast when the phone triggers a bump.
    public static final String BUMPED = "com.bumptech.api.bumped";
    //Broadcast when the api fails to match someone.
    public static final String NOT_MATCHED = "com.bumptech.api.notMatched";
    //Broadcast when the api has matched with someone.
    public static final String MATCHED = "com.bumptech.api.matched";
    public static final String MATCHED_EXTRA_PROPOSED_CHANNEL_ID = "proposedChannelID";
    //Broadcast when the channel has been confirmed by both parties.
    public static final String CHANNEL_CONFIRMED = "com.bumptech.api.channelConfirmed";
    public static final String CHANNEL_CONFIRMED_EXTRA_CHANNEL_ID = "channelID";
    //Broadcast when data has been received from the other user's session.
    public static final String DATA_RECEIVED = "com.bumptech.api.dataReceived";
    public static final String DATA_RECEIVED_EXTRA_CHANNEL_ID = "channelID";
    public static final String DATA_RECEIVED_EXTRA_DATA = "data";
}
