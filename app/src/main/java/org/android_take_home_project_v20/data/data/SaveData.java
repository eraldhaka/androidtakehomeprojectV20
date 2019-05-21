package org.android_take_home_project_v20.data.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Erald Haka.
 */
public class SaveData {

    private static SharedPreferences sharedPreferences;

    public static void initSharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("android_take_home", MODE_PRIVATE);
    }

    public static void setDataModel(DataModel dataModel) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dataModel);
        prefsEditor.putString(String.valueOf(dataModel.getId()), json);
        prefsEditor.apply();
    }

    public static boolean getModel(Integer id) {
        boolean favourite = false;
        Gson gson = new Gson();
        String json = sharedPreferences.getString(String.valueOf(id), "");
        DataModel obj = gson.fromJson(json, DataModel.class);
        if(obj!=null){
            favourite = obj.isFavourite();
        }
        return favourite;
    }
}
