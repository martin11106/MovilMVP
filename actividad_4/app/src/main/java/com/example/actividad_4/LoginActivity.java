package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.actividad_4.Model.LoginModel;
import com.example.actividad_4.Presenter.LoginPresenter;
import com.example.actividad_4.View.ViewLogin;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements ViewLogin {
    EditText usuario;
    EditText password;
    Button entrar;
    LoginPresenter presenter;
    ArrayList<String> datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        presenter = new LoginModel(LoginActivity.this);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        entrar = (Button)findViewById(R.id.login);
    }
    public void logear(View view){
        presenter.performLogin(usuario.getText().toString(),password.getText().toString());
    }

    @Override
    public void loginSucces(String key) {
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("dato",key);
        startActivity(intent);
    }

    @Override
    public void loginError() {
Toast.makeText(this,"error al loguearse",Toast.LENGTH_SHORT).show();
    }
}
