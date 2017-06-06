package com.example.asus.listviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public class Fruit {
        private String name;
        private int imageId;

        public Fruit(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }
    }

    public class FruitAdapter extends ArrayAdapter<Fruit> {
        private int resourceId;

        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }

        class ViewHolder{
            ImageView fruitImage;
            TextView fruitName;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Fruit fruit = getItem(position);
            View view;
            ViewHolder viewHolder;
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
                view.setTag(viewHolder);
            }else{
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getName());
            return view;
        }
    }

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for(int i = 0; i < 3; i++){
            Fruit apple = new Fruit("Apple", R.drawable.bg);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.bg);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.bg);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.bg);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.bg);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.bg);
            fruitList.add(grape);
            Fruit mango = new Fruit("Mango", R.drawable.bg);
            fruitList.add(mango);
            Fruit cherry = new Fruit("Cherry", R.drawable.bg);
            fruitList.add(cherry);


        }
    }
}
