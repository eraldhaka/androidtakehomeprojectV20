package org.android_take_home_project_v20.data.network;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import java.util.List;
import rx.Observable;
/**
 * Created by Erald Haka.
 */
public interface ApiHelper {
    Observable<List<DataModel>> getData();

    Observable<DetailModel> getDetailItems(int id);
}
