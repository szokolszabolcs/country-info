package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.ViewHolder> {

    List<Country> favourites;
    Context context;
    LayoutInflater inflater;

    public FavouritesAdapter(List<Country> favourites, Context context) {
        this.favourites = favourites;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public FavouritesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.li_country, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(favourites.get(position).getName());
        holder.capital.setText(favourites.get(position).getCapital());
    }

    @Override
    public int getItemCount() {
        return favourites.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.capital)
        TextView capital;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
