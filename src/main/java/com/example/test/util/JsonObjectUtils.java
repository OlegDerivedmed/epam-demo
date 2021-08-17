package com.example.test.util;

import org.json.JSONObject;

public class JsonObjectUtils {

    public static JSONObject getNestedJsonObjByPropName(JSONObject outer, String propName) {
        return (JSONObject) outer.get(propName);
    }
}
