package org.android_take_home_project_v20.ui.detail;

import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;

/**
 * Created by Erald Haka.
 */
public class DetailPresenter {

    private DetailView detailView;
    private DetailListItemsInteractor detailListItemsInteractor;
    private int restaurantId;

    public DetailPresenter(DetailView mainView, DetailListItemsInteractor listItemsInteractor, int restaurantId) {
        this.detailView = mainView;
        this.detailListItemsInteractor = listItemsInteractor;
        this.restaurantId = restaurantId;
    }


    public void onResume() {
        if (detailView != null) {
            detailView.showProgress();
        }
        detailListItemsInteractor.getDetailItems(this::onFinished,restaurantId);
    }

    public void onFinished(DetailModel items) {
        if (detailView != null) {
            detailView.displayDetailItems(items);
            detailView.hideProgress();
        }
    }

    public DetailView getDetailView() {
        return detailView;
    }

    public void onDestroy() {
        detailView = null;
    }
}
