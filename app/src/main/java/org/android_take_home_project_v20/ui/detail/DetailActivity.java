package org.android_take_home_project_v20.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.android_take_home_project_v20.R;
import org.android_take_home_project_v20.data.model.restaurant_detail.DetailModel;
import java.util.Objects;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.android_take_home_project_v20.utils.Constants.RESTAURANT_ID;
import static org.android_take_home_project_v20.utils.Utils.loadImage;

public class DetailActivity extends AppCompatActivity implements DetailView{

    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.imageView_logo)
    ImageView imgLogo;
    @BindView(R.id.textView_name)
    TextView txtName;
    @BindView(R.id.textView_description)
    TextView txtDescription;
    @BindView(R.id.textView_phone_number)
    TextView txtPhoneNumber;
    @BindView(R.id.textView_average_rating)
    TextView txtAverageRating;

    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        int restaurantId = Objects.requireNonNull(getIntent().getExtras()).getInt(RESTAURANT_ID);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        detailPresenter = new DetailPresenter(this, new DetailListItemsInteractor(),restaurantId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        detailPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        detailPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayDetailItems(DetailModel items) {
        loadImage(items.getCoverImageUrl(),imgLogo);
        txtName.setText(items.getName());
        txtDescription.setText(items.getDescription());
        txtPhoneNumber.setText(items.getPhoneNumber());
        txtAverageRating.setText(String.format(getString(R.string.average_rating), String.valueOf(items.getAverageRating())));
        recyclerView.setAdapter(new DetailAdapter(items.getMenus()));
    }
}
