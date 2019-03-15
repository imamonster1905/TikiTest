package vn.tiki.tikitest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import vn.tiki.tikitest.R;
import vn.tiki.tikitest.adapters.HotkeyAdapter;
import vn.tiki.tikitest.common.Constants;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotkeyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        fetchJson();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.main_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void fetchJson() {
        StringRequest request = new StringRequest(Constants.KEYWORDS_JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String response = "";
                try{
                    InputStream inputStream = getAssets().open("json.txt");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    response = new String(buffer);

                    showData(response);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
    }

    private void showData(String response) {
        String[] arrKey = new Gson().fromJson(response, String[].class);
        adapter = new HotkeyAdapter(MainActivity.this, Arrays.asList(arrKey));
        recyclerView.setAdapter(adapter);
    }

}
