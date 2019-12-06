package com.example.logwithfrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fillExampleList();
        setUpRecyclerView();
        getSupportActionBar().setTitle("Cars");
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.volvo, "Volvo", "Volvo S60 Cross Country"));
        exampleList.add(new ExampleItem(R.drawable.mercedez, "Mercedez", "Mercedez Benz CLS"));
        exampleList.add(new ExampleItem(R.drawable.audi, "Audi", "Audi A3 Cabriolet"));
        exampleList.add(new ExampleItem(R.drawable.toyota, "Toyota", "Toyota camry sedan"));
        exampleList.add(new ExampleItem(R.drawable.porche, "Porche", "Porsche-911"));
        exampleList.add(new ExampleItem(R.drawable.jaguar, "Jaguar", "Jaguar convertible"));
        exampleList.add(new ExampleItem(R.drawable.range, "Range Rover", "Range rover sport"));
        exampleList.add(new ExampleItem(R.drawable.bmw, "BMW", "BMW 5803"));
        exampleList.add(new ExampleItem(R.drawable.chevy, "Chevy", "Chevy corvette"));
        exampleList.add(new ExampleItem(R.drawable.jaguar1, "Jaguar", "Jaguar XK"));


    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
