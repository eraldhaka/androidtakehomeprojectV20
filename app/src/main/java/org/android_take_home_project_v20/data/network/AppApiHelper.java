package org.android_take_home_project_v20.data.network;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import java.util.List;
import rx.Observable;

/**
 * Created by Erald Haka.
 */

public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<List<DataModel>> getData() {
        return APIClient.getData().getData();
    }

    @Override
    public Observable<DetailModel> getDetailItems(int id) {
        return APIClient.getData().getDetailItems(id);
    }
}
