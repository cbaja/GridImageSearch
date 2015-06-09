package com.codepath.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carlybaja on 6/9/15.
 */
public class ImageResult implements Serializable {
    public String fullUrl;
    public String thumbUrl;
    public String title;

    // Constructor : new ImageResult
    public ImageResult(JSONObject json){
        try {
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
            this.title = json.getString("title");

        }catch (JSONException e){
            e.printStackTrace();
        }

    }
    // ImageResult.fromJSONArray([..,...])
    public static ArrayList<ImageResult> fromJSONArray(JSONArray array){
       ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for (int i=0; i<array.length();i++) {
            try{
                results.add(new ImageResult(array.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results ;
    }
}
