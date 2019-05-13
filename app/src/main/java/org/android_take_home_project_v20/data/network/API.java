package org.android_take_home_project_v20.data.network;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Erald Haka.
 */

public interface API {
    @GET("/v2/restaurant/?lat=37.422740&lng=-122.139956&offset=0&limit=50")
    Observable<List<DataModel>> getData();

    @GET("/v2/restaurant/{id}/")
    Observable<DetailModel> getDetailItems(@Path("id") int id);

}
