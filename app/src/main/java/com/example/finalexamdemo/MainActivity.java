package com.example.finalexamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] menuArray = {"Viet nam", "Lao", "Campuchia", "Thai Lan"};
    int[] flag = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        CustomApdater customApdater = new CustomApdater();
        listView.setAdapter(customApdater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), Insert.class);
                intent.putExtra("name", menuArray[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomApdater extends BaseAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.activity_item_linee, null);
            //menuArray = getResources().getStringArray(R.array.array_country);
            TextView nameView = view1.findViewById(R.id.txtName);
            TextView zipcodeView = view1.findViewById(R.id.txtZipcode);
            ImageView image = view1.findViewById(R.id.image);

            Intent intent = getIntent();
            String nameIntent = intent.getStringExtra("name");
            String zipcodeIntent = intent.getStringExtra("zipcode");

            Log.d(nameIntent, "nameIntent");
            Log.d(zipcodeIntent, "zipcodeIntent");

            nameView.setText(nameIntent);
            zipcodeView.setText(zipcodeIntent);

//            for(int i = 0; i < flag.length; i++)
//            {
//                nameView.setText(menuArray[i]);
//                image.setImageResource(flag[i]);
//                zipcodeView.setText("123456");
//            }

            return view1;
        }
    }
}