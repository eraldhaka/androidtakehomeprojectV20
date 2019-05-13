package org.android_take_home_project_v20.ui.detail;

import android.util.Log;
import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import org.android_take_home_project_v20.data.network.ApiHelper;
import org.android_take_home_project_v20.data.network.AppApiHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Erald Haka.
 */
public class DetailListItemsInteractor {

    interface OnFinishedListener {
        void onFinished(DetailModel items);
    }

    public void getDetailItems(final OnFinishedListener listener, int restaurantId) {

        ApiHelper apiHelper = new AppApiHelper();
        apiHelper.getDetailItems(restaurantId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DetailModel>() {
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
                    public void onNext(DetailModel detailModels) {
                        listener.onFinished(detailModels);
                    }
                });
    }
}
