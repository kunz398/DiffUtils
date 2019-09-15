package com.example.diffutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.diffutils.Util.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button btn_insert,btn_update;
RecyclerView recyclerView;
List<String> datasource = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn_insert = (Button)findViewById(R.id.btn_insert);
        btn_update = (Button)findViewById(R.id.btn_update);

        initData();
        final MyAdapter adapter = new MyAdapter(datasource);
        recyclerView.setAdapter(adapter);

        //Event
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <String> insertList =  new ArrayList<>(); ///assign old data
                for (int i = 0; i<3; i++){
                    insertList.add(UUID.randomUUID().toString()); //add new data
                    adapter.insertData(insertList);
                    recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);//Auto scroll to last item
                }
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <String> update = new ArrayList<>(); ///assign old data
                for (int i = 0; i<3; i++){
                    update.add(UUID.randomUUID().toString()); //add new data
                    adapter.insertData(update);

                }
            }
        });
    }

    private void initData()
    {
        for (int i = 0; i<3; i++)
        {
            datasource.add(UUID.randomUUID().toString());
        }
    }
}
