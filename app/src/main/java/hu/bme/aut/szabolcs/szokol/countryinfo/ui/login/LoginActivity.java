package hu.bme.aut.szabolcs.szokol.countryinfo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.email_sign_in_button)
    AppCompatButton emailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CountyInfoApplication.injector.inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.email_sign_in_button)
    public void onClick() {
        loginPresenter.login(email.getText().toString(), password.getText().toString());
    }

}