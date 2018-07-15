package practicaltask.riseapps.com.practicaltask.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.callback.OnMenuItemClickListener;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<String> regionsData;
    private OnMenuItemClickListener onItemClicked;

    public MenuAdapter(@NonNull final List<String> regionsData, final OnMenuItemClickListener onItemClicked) {
        this.regionsData = new ArrayList<>();
        this.regionsData.addAll(regionsData);
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_region, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.tvRegionName.setText(regionsData.get(position));
    }

    @Override
    public int getItemCount() {
        return regionsData.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvRegionName;

        MenuViewHolder(View itemView) {
            super(itemView);
            tvRegionName = itemView.findViewById(R.id.tvRegionName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClicked.onMenuItemClicked(v, regionsData.get(this.getAdapterPosition()));
        }
    }
}
