package com.convipro.unknown.convipro;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 19/07/2016.
 */
public class Converter extends AppCompatActivity {
    private int id; // convertion type (0 = length, 1 = weight ...)
    private double valueFrom, result;

    // views:
    private Spinner spinFrom, spinTo;
    private EditText etValueFrom, etValueTo;
    private Button btnConvert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_convertor);

        // setting up all views
        spinFrom = (Spinner) findViewById(R.id.spinner_from);
        spinTo = (Spinner) findViewById(R.id.spinner_to);
        etValueFrom = (EditText) findViewById(R.id.value_from);
        etValueTo = (EditText) findViewById(R.id.value_to);
        btnConvert = (Button) findViewById(R.id.button_convert);
    }

    @Override
    public void onResume() {
        super.onResume();
        id = (int) getIntent().getLongExtra(MainActivityListFragment.EXTRA_OPTION_ID, 0);
        setEntries();
    }

    public void setEntries() {
        ArrayAdapter<CharSequence> adapter;

        // Create an ArrayAdapter using the string array and a default spinner layout
        switch(id) {
            default:
            case Convertions.LENGTH:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_lengths, android.R.layout.simple_spinner_item);
                break;
            case Convertions.MASS:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_masses, android.R.layout.simple_spinner_item);
                break;
            case Convertions.SPEED:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_speeds, android.R.layout.simple_spinner_item);
                break;
            case Convertions.TEMPERATURE:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_temperatures, android.R.layout.simple_spinner_item);
                break;
            case Convertions.VOLUME:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_volumes, android.R.layout.simple_spinner_item);
                break;
            case Convertions.PRESSURE:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_pressures, android.R.layout.simple_spinner_item);
                break;
            case Convertions.ANGLE:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_angles, android.R.layout.simple_spinner_item);
                break;
            case Convertions.FREQUENCY:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_frequencies, android.R.layout.simple_spinner_item);
                break;
            case Convertions.ENERGY:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_energies, android.R.layout.simple_spinner_item);
                break;
            case Convertions.DIGITAL:
                adapter = ArrayAdapter.createFromResource(this, R.array.name_digital_storages, android.R.layout.simple_spinner_item);
                break;
        }

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinFrom.setAdapter(adapter);
        spinTo.setAdapter(adapter);
    }

    public void convert(View v) {
        double minVal = 1;
        double result = 1;

        if (etValueFrom.getText().toString().length() != 0) {
            valueFrom = Double.parseDouble(etValueFrom.getText().toString());

            if (id != Convertions.TEMPERATURE) {
                minVal = valueFrom * Convertions.getConv(id)[spinFrom.getSelectedItemPosition()];
                result = minVal / Convertions.getConv(id)[spinTo.getSelectedItemPosition()];
            } else {
                result = Convertions.convertTemp(valueFrom, spinFrom.getSelectedItemPosition(), spinTo.getSelectedItemPosition());
            }

            etValueTo.setText(Double.toString(result));

            Toast.makeText(getApplicationContext(), Double.toString(result), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.enter_value, Toast.LENGTH_SHORT).show();
        }
    }

    public void switchUnits(View v) {
        int temp = spinFrom.getSelectedItemPosition();
        spinFrom.setSelection(spinTo.getSelectedItemPosition());
        spinTo.setSelection(temp);
    }
}
