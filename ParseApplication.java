package com.r.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the configuration Builder given this

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("K1ZBb8oblCTWdJ9iUdvfQqRZkfiZHbv5D5M0elat")
                .clientKey("ygbCRDUi9u7tO3ny9jarbrOJWfC0XaDHygTqW8cv")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
