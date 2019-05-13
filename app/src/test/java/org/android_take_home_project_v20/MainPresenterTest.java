package org.android_take_home_project_v20;

import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.ui.main.MainListItemsInteractor;
import org.android_take_home_project_v20.ui.main.MainPresenter;
import org.android_take_home_project_v20.ui.main.MainView;
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
public class MainPresenterTest {

    @Mock
    MainView view;

    @Mock
    MainListItemsInteractor interactor;

    private MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenter(view, interactor);
    }

    @Test
    public void checkIfShowsProgressOnResume() {
        presenter.onResume();
        verify(view, times(1)).showProgress();
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getMainView());
    }

    @Test
    public void checkIfItemsArePassedToView() {
        List<DataModel> items = new ArrayList<>();
        DataModel dataModel = new DataModel(1,"name","description","https://cdn.doordash.com/media/restaurant/cover/Biryaniz.png","closed",1);
        items.add(dataModel);
        presenter.onFinished(items);
        verify(view, times(1)).displayItems(items);
        verify(view, times(1)).hideProgress();
    }

}
