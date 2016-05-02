package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock.MockRepository;

public class FavouritesFragment extends Fragment implements FavouritesScreen {

    public static final String FRAGMENT_FAVOURITES = "FRAGMENT_FAVOURITES";

    Random random = new Random(); //TODO remove

    @Inject
    FavouritesPresenter presenter;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.elementsView)
    TextView elementsView;

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

    @OnClick({R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Country country = new Country(random.nextLong(), "Test Country", "Test region", 546464L, 8464, MockRepository.getList("RAND"), MockRepository.getList("100"), MockRepository.getList(".rand"), "http://small.hu", "http://normal.hu");
                presenter.addToDB(country);
                break;
        }
    }

    @Override
    public void refresh() {
        presenter.getFavourites();
    }

    @Override
    public void showFavourites(List<Country> favourites) {
        StringBuffer stringBuffer = new StringBuffer();

        for (Country country : favourites) {
            stringBuffer.append("Id: " + country.getId() + "           Name: " + country.getName() + "\n");
        }

        elementsView.setText(stringBuffer.toString());
    }
}
