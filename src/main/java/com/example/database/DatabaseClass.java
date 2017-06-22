package com.example.database;

import com.example.model.Message;
import com.example.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Solbon on 2017-06-22.
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<Long, Profile> getProfiles() {
        return profiles;
    }
}
