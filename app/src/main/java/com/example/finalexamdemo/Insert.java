package com.example.finalexamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Insert extends AppCompatActivity {
    private Button btnInsert;
    private EditText name, address, zipcode;
    private RadioGroup locationGroup;
    private Spinner country;
    private RadioButton location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name = findViewById(R.id.txtName);
        address = findViewById(R.id.txtAdress);
        zipcode = findViewById(R.id.txtZipcode);
        country = findViewById(R.id.country);
        locationGroup = findViewById(R.id.radio_group);
        btnInsert = findViewById(R.id.btnInsert);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_country, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        country.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInsert = name.getText().toString();
                String addressInsert = address.getText().toString();
                String zipcodeInsert = zipcode.getText().toString();

                int selectedId = locationGroup.getCheckedRadioButtonId();
                location = findViewById(selectedId);
                String locationInsert = location.getText().toString();
                String countryInsert = country.getSelectedItem().toString();

                //CONSOLE.LOG
                Log.d(nameInsert, "nameInsert");
                Log.d(addressInsert, "addressInsert");
                Log.d(zipcodeInsert, "zipcodeInsert");
                Log.d(locationInsert, "locationInsert");
                Log.d(countryInsert, "countryInsert");

                Intent intent = new Intent(Insert.this, MainActivity.class);
                intent.putExtra("name", nameInsert);
                intent.putExtra("address", addressInsert);
                intent.putExtra("zipcode", zipcodeInsert);
                intent.putExtra("location", locationInsert);
                intent.putExtra("country", countryInsert);
                startActivity(intent);
            }
        });
    }
}