package org.android_take_home_project_v20.ui.main;

import android.util.Log;
import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.data.network.ApiHelper;
import org.android_take_home_project_v20.data.network.AppApiHelper;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Erald Haka.
 */
public class MainListItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<DataModel> items);
    }

     void displayItems(final OnFinishedListener listener) {
         ApiHelper apiHelper = new AppApiHelper();
         apiHelper.getData()
                 .subscribeOn(Schedulers.newThread())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<List<DataModel>>() {
                     @Override
                     public void onCompleted() {
                         //
                     }

                     @Override
                     public void onError(Throwable e) {
                         //hideProgress
                         Log.d("MainListItemsInteractor","OnError");
                     }

                     @Override
                     public void onNext(List<DataModel> dataModels) {
                         listener.onFinished(dataModels);
                     }
                 });

    }
}
