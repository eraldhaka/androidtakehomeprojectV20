package org.android_take_home_project_v20.ui.main;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import java.util.List;

/**
 * Created by Erald Haka.
 */
public class MainPresenter {

    private MainView mainView;
    private MainListItemsInteractor listItemsInteractor;

    public MainPresenter(MainView mainView, MainListItemsInteractor listItemsInteractor) {
        this.mainView = mainView;
        this.listItemsInteractor = listItemsInteractor;
    }

    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }

        listItemsInteractor.displayItems(this::onFinished);
    }

    public void onDestroy() {
        mainView = null;
    }

    public void onFinished(List<DataModel> items) {
        if (mainView != null) {
            mainView.displayItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}
