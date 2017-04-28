/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json;



import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


/**
 *
 * @author Jagat
 */
public class Ex2 {

    public static void main(String[] args) {

        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("/Users/Jagat/Desktop/html_spec.json"));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

         // store string in JSON Object
         // convert JSON Object to HashMap
        JSONObject obj = new JSONObject(jsonData);
        System.out.println("Entire JSON JSON Object" + obj);
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap = jsonToMap(obj);

        // print hasMap using iterator
        Set set = myMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        // get values based on key
        getVal("metadata", myMap);
        getVal("main", myMap);
        
        
        // convert HashMap to JSON String
        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        System.out.println("JSON converted from HashMap: " + json);
    }

  
    public static Object getVal(String key, Map<String, Object> tempMap) {

        if (tempMap.containsKey(key)) {
            System.out.println("value for key " + key + " is :" + tempMap.get(key));
        }

        return tempMap.get(key);
    }

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

}
