package com.example.actividad_4.Model;

import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.actividad_4.Tools.Cliente;
import com.example.actividad_4.R;
import com.example.actividad_4.Presenter.SecondFragmentPresenter;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class SecondFragmentModel implements SecondFragmentPresenter {
    View view;
    public SecondFragmentModel(View view){
        this.view = view;
    }
    @Override
    public void performSecondFragment() {

        Cliente.getAllClient(null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    final TableLayout stk = (TableLayout) view.findViewById(R.id.table_main2);
                    TableRow tbrow0 = new TableRow(view.getContext());
                    TextView tv0 = new TextView(view.getContext());
                    tv0.setText("Apellido ");
                    tv0.setGravity(Gravity.CENTER);
                    tbrow0.addView(tv0);
                    stk.addView(tbrow0);


                    for (int i=0 ;i<response.length();i++){
                        TableRow tbrow = new TableRow(view.getContext());
                        JSONObject jsonObject;
                        jsonObject = response.getJSONObject(i);
                        TextView t1v = new TextView(view.getContext());
                        t1v.setText("" + jsonObject.getString("apellido"));
                        t1v.setGravity(Gravity.CENTER);
                        tbrow.addView(t1v);


                        final Button btn = new Button(view.getContext());
                        btn.setText("ver Mas");
                        btn.setTag(jsonObject.getString("id"));
                        btn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Cliente.getByidClient(btn.getTag().toString(),null,new JsonHttpResponseHandler(){
                                    @Override
                                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                        try {

                                            AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
                                            alerta.setMessage("nombre "+response.getString("Nombre")+" apellido "+response.getString("apellido")+" edad "+response.getString("edad")+" sexo "+response.getString("sexo")+" carrera "+response.getString("carrera"));
                                            alerta.setCancelable(false);
                                            alerta.setPositiveButton("ok",null);
                                            AlertDialog titlulo = alerta.create();
                                            titlulo.show();
                                        }catch (Exception e){

                                        }
                                    }
                                });

                            }
                        });
                        tbrow.addView(btn);
                        stk.addView(tbrow);


                    }

                }catch (JSONException e){

                };
            }


        });
    }
}
