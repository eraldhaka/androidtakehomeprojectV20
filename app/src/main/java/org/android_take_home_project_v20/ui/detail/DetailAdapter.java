package org.android_take_home_project_v20.ui.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.android_take_home_project_v20.R;
import org.android_take_home_project_v20.data.model.restaurant_detail.MenuModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Erald Haka.
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MainViewHolder> {

    private List<MenuModel> items;

    DetailAdapter(List<MenuModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =  inflater.inflate(R.layout.adapter_detail, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final MenuModel item = items.get(position);

        holder.txtName.setText(item.getName());
        holder.txtSubtitle.setText(item.getSubtitle());
        holder.txtStatus.setText(item.getStatus());
        holder.txtStatusType.setText(item.getStatusType());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_name)
        TextView txtName;
        @BindView(R.id.textView_subtitle)
        TextView txtSubtitle;
        @BindView(R.id.textView_status)
        TextView txtStatus;
        @BindView(R.id.textView_status_type)
        TextView txtStatusType;

        MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

