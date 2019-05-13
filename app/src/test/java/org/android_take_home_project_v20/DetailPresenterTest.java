package org.android_take_home_project_v20;

import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import org.android_take_home_project_v20.data.model.restaurant_detail.MenuModel;
import org.android_take_home_project_v20.ui.detail.DetailListItemsInteractor;
import org.android_take_home_project_v20.ui.detail.DetailPresenter;
import org.android_take_home_project_v20.ui.detail.DetailView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Erald Haka.
 */

@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    @Mock
    DetailView view;

    @Mock
    DetailListItemsInteractor interactor;

    private DetailPresenter detailPresenter;

    @Before
    public void setUp() throws Exception {
        detailPresenter = new DetailPresenter(view, interactor,433);
    }

    @Test
    public void checkIfShowsProgressOnResume() {
        detailPresenter.onResume();
        verify(view, times(1)).showProgress();
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        detailPresenter.onDestroy();
        assertNull(detailPresenter.getDetailView());
    }

    @Test
    public void checkIfItemsArePassedToView() {
        List<MenuModel> items = new ArrayList<>();
        MenuModel menuModel = new MenuModel("name","subtitle","status","statusType");
        items.add(menuModel);
        DetailModel dataModel = new DetailModel("name","description","https://cdn.doordash.com/media/restaurant/cover/Biryaniz.png","1234567890",3.2,items);
        detailPresenter.onFinished(dataModel);
        verify(view, times(1)).displayDetailItems(dataModel);
        verify(view, times(1)).hideProgress();
    }
}
