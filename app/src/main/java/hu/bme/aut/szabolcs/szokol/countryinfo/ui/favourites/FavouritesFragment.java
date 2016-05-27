package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;

public class FavouritesFragment extends Fragment implements FavouritesScreen {

    public static final String FRAGMENT_FAVOURITES = "FRAGMENT_FAVOURITES";

    Random random = new Random(); //TODO remove

    @Bind(R.id.favourites_rv)
    RecyclerView favouritesRv;

    private List<Country> favourites;
    private FavouritesAdapter adapter;

    @Inject
    FavouritesPresenter presenter;

    public FavouritesFragment() {
        CountyInfoApplication.injector.inject(this);
    }

    public static FavouritesFragment newInstance() {
        FavouritesFragment fragment = new FavouritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        ButterKnife.bind(this, view);

        favouritesRv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        favouritesRv.setLayoutManager(linearLayoutManager);

        favourites = new ArrayList<>();
        adapter = new FavouritesAdapter(favourites, getContext());
        favouritesRv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_favourites);

        presenter.getFavourites();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        presenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void refresh() {
        presenter.getFavourites();
    }

    @Override
    public void showFavourites(List<Country> favourites) {
        this.favourites.clear();
        this.favourites.addAll(favourites);
        adapter.notifyDataSetChanged();
    }
}
