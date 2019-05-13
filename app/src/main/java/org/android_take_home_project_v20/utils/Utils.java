package org.android_take_home_project_v20.utils;

import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Erald Haka.
 */
public class Utils {

    public static void loadImage(String url, ImageView image){
        Picasso.get()
                .load(url)
                .into(image);
    }
}
