package com.antelope.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private String[] data = {"Apple","Banana","Orange","Pear","Mango","Cherry","Strawberry","Pineapple"};
    private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                data);*/
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.list_item,mFruitList);
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(adapter);

        //ListView的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits(){

        for (int i = 0; i< 2; i++){
            Fruit apple = new Fruit("Apple",R.drawable.ic_launcher_foreground);
            mFruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.ic_launcher_foreground);
            mFruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.ic_launcher_foreground);
            mFruitList.add(orange);
            Fruit pear = new Fruit("Pear",R.drawable.ic_launcher_foreground);
            mFruitList.add(pear);
            Fruit mango = new Fruit("Mango",R.drawable.ic_launcher_foreground);
            mFruitList.add(mango);
            Fruit cherry = new Fruit("Cherry",R.drawable.ic_launcher_foreground);
            mFruitList.add(cherry);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.ic_launcher_foreground);
            mFruitList.add(strawberry);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.ic_launcher_foreground);
            mFruitList.add(pineapple);
        }

    }


}
