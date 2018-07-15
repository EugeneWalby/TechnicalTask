package practicaltask.riseapps.com.practicaltask.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.network.model.CountryData;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {
    private List<CountryData> countriesData;

    public CountriesAdapter(final List<CountryData> countriesData) {
        this.countriesData = countriesData;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.tvCountryName.setText(countriesData.get(position).getName());
        holder.tvCapitalName.setText(countriesData.get(position).getCapital());
    }

    @Override
    public int getItemCount() {
        return countriesData.size();
    }

    class CountriesViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCountryName;
        private TextView tvCapitalName;

        public CountriesViewHolder(View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            tvCapitalName = itemView.findViewById(R.id.tvCapitalName);
        }
    }
}
