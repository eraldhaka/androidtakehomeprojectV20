package org.android_take_home_project_v20.ui.main;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.android_take_home_project_v20.R;
import org.android_take_home_project_v20.data.model.restaurant_data.DataModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import static org.android_take_home_project_v20.utils.Utils.loadImage;

/**
 * Created by Erald Haka.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<DataModel> items;
    private Listener listener;

    MainAdapter(List<DataModel> items, Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    interface Listener {
        void onItemClicked(DataModel item);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =  inflater.inflate(R.layout.adapter_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final DataModel item = items.get(position);
        holder.constraintLayout.setOnClickListener(v -> listener.onItemClicked(item));
        loadImage(item.getCoverImageUrl(),holder.imgLogo);
        holder.txtName.setText(item.getName());
        holder.txtDescription.setText(item.getDescription());
        holder.txtStatus.setText(item.getStatus());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.constraintLayout)
        ConstraintLayout constraintLayout;
        @BindView(R.id.imageView_logo)
        ImageView imgLogo;
        @BindView(R.id.textView_name)
        TextView txtName;
        @BindView(R.id.textView_description)
        TextView txtDescription;
        @BindView(R.id.textView_status)
        TextView txtStatus;

        MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

