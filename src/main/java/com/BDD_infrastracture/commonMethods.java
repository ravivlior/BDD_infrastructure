package com.BDD_infrastracture;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class commonMethods {

    public static String parseItemFromObjectRepository(String objectRepoPath, String fieldNameParam) throws Throwable {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/ObjectRepository/"+objectRepoPath));
        JSONObject jsonObject = (JSONObject) obj;
        String fieldName = (String) jsonObject.get(fieldNameParam);
        return fieldName;
    }
}
