package com.r.myapplication;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String DESCRIPTION_KEY = "description";
    public static final String IMAGE_KEY = "image";
    public static final String USER_KEY = "user";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getDescription(){
        return getString(DESCRIPTION_KEY);
    }

    public void setDescription(String description){
        put(DESCRIPTION_KEY, description);
    }

    public ParseFile getImage() {
        return getParseFile(IMAGE_KEY);
    }

    public void setImage(ParseFile parseFile){
        put(IMAGE_KEY, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(USER_KEY);
    }

    public void setUser(ParseUser user){
        put(USER_KEY, user);

        }
    }

