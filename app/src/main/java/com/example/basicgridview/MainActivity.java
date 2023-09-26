package com.example.basicgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Country> arrayList;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gv);
        arrayList = new ArrayList<>();

        arrayList.add(new Country("Vietnam", R.drawable.vietnam));
        arrayList.add(new Country("Chinese", R.drawable.chinese));
        arrayList.add(new Country("Japan", R.drawable.japan));
        arrayList.add(new Country("South Korea", R.drawable.southkorea));

        adapter = new CountryAdapter(this, R.layout.view_country, arrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayList.get(i).countryName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}