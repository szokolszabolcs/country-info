package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;

public class FavouritesFragment extends Fragment implements FavouritesScreen {

    public static final String FRAGMENT_FAVOURITES = "FRAGMENT_FAVOURITES";

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

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_favourites);
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

}
