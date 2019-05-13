package org.android_take_home_project_v20.ui.detail;

import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;

/**
 * Created by Erald Haka.
 */
public interface DetailView {
    void showProgress();

    void hideProgress();

    void displayDetailItems(DetailModel items);

}
