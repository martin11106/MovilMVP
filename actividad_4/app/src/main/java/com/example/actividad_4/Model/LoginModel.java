package com.example.actividad_4.Model;

import android.content.Context;

import com.example.actividad_4.Tools.Cliente;
import com.example.actividad_4.LoginActivity;
import com.example.actividad_4.Presenter.LoginPresenter;
import com.example.actividad_4.View.ViewLogin;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class LoginModel implements LoginPresenter {
    ViewLogin viewLogin;
    Context context;
    ArrayList<String> datos = new ArrayList<>();
    public  LoginModel(LoginActivity viewLogin){
        this.viewLogin = viewLogin;
    }
    @Override
    public void performLogin(String username, String password) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("username",username);
        requestParams.put("password",password);

        Cliente.postLogin(requestParams,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    for (int j=0 ;j<response.length();j++) {
                        datos.add(response.getString("token"));
                        datos.add(response.getString("username"));
                        datos.add(response.getString("email"));
                        viewLogin.loginSucces(response.getString("username"));

                    }
                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                viewLogin.loginError();
            }

        });
    }
}
