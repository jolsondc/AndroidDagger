package com.jolly.androiddagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jolly.androiddagger.Adapter.RecycleViewAdapter;
import com.jolly.androiddagger.Model.Model;
import com.jolly.androiddagger.Network.Http;
import com.jolly.androiddagger.UI.CustomProgressDialog;
import com.jolly.androiddagger.Network.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomProgressDialog progressDialog;

    @Inject Http http;
    private RecyclerView recycleview;
    private RecycleViewAdapter recycleViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplicationContext()).getmAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        progressDialog= new CustomProgressDialog(this);
        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        recycleViewAdapter = new RecycleViewAdapter();
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setAdapter(recycleViewAdapter);

        makeHttpCall();


    }

    private void makeHttpCall() {
        progressDialog.showDialog();

        Call<ResponseBody> call =http.makeCall();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.cancelDialog();
                String res = NetworkUtils.convertTypedBodyToString(response.body());
                recycleViewAdapter.update(parseJson(res));
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.cancelDialog();

            }
        });

    }

    private ArrayList<Model> parseJson(String res) {
        ArrayList<Model> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(res);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                list.add(new Model(obj.getString("id"),obj.getString("title")));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;

    }


}
