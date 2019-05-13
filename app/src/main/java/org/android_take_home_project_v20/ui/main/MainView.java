package org.android_take_home_project_v20.ui.main;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;

import java.util.List;

/**
 * Created by Erald Haka.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void displayItems(List<DataModel> items);

    void onItemClicked(DataModel dataModel);
}
