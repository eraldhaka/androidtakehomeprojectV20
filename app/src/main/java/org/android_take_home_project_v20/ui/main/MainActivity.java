package org.android_take_home_project_v20.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import org.android_take_home_project_v20.R;
import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import org.android_take_home_project_v20.ui.detail.DetailActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

import static org.android_take_home_project_v20.utils.Constants.RESTAURANT_ID;

/**
 * Created by Erald Haka.
 */

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new MainPresenter(this, new MainListItemsInteractor());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayItems(List<DataModel> items) {
        recyclerView.setAdapter(new MainAdapter(items, this::onItemClicked));
    }

    @Override
    public void onItemClicked(DataModel dataModel) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(RESTAURANT_ID,dataModel.getId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

}
