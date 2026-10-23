package com.example.kartkowka;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textViewCzas, textViewWynik;
    EditText editTextNazwa, editTextLiczba;
    SeekBar seekBar;
    Spinner spinner;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    CheckBox checkBox;

    String nazwaGry;
    int liczbaGraczy;
    String kategoria;
    String kategoriaWiekowa;
    int czasRozgrywki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNazwa = findViewById(R.id.editTextText);
        editTextLiczba = findViewById(R.id.editTextNumber);
        textViewCzas = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        checkBox = findViewById(R.id.checkBox);
        textViewWynik = findViewById(R.id.textView4);
        seekBar = findViewById(R.id.seekBar);

        editTextNazwa.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        nazwaGry = charSequence.toString();
                        textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                    }
                }
        );
        editTextLiczba.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (!editTextLiczba.getText().toString().equals("")) {
                            liczbaGraczy = Integer.parseInt(charSequence.toString());
                            textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );

                        }
                    }
                }
        );
       spinner.setOnItemSelectedListener(
               new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                       kategoria = spinner.getSelectedItem().toString();
                       textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> adapterView) {

                   }
               }
       );
       radioButton1.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                       if(radioButton1.isChecked()){
                           kategoriaWiekowa = "3+";
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                       }
                   }
               }
       );
       radioButton2.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                       if(radioButton2.isChecked()){
                           kategoriaWiekowa = "6+";
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                       }
                   }
               }
       );
       radioButton3.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                       if(radioButton3.isChecked()){
                           kategoriaWiekowa = "10+";
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                       }
                   }
               }
       );
       radioButton4.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                       if(radioButton4.isChecked()){
                           kategoriaWiekowa = "16+";
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );
                       }
                   }
               }
       );
       checkBox.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {

                       if(checkBox.isChecked()){
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy +","+kategoria +", "+kategoriaWiekowa+", "+czasRozgrywki+"minut, " + "jest dostepna w sprzedazy");
                       }else{
                           textViewWynik.setText(nazwaGry +", " + liczbaGraczy +", "+kategoria +", "+kategoriaWiekowa+", "+czasRozgrywki+"minut, " + "nie jest dostepna w sprzedazy");
                       }
                   }
               }
       );
       seekBar.setOnSeekBarChangeListener(
               new SeekBar.OnSeekBarChangeListener() {
                   @Override
                   public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                       textViewCzas.setText(i+"");
                       czasRozgrywki = i;
                       textViewWynik.setText(nazwaGry +", " + liczbaGraczy+", "+czasRozgrywki+"minut, "+kategoria+", "+kategoriaWiekowa );

                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {

                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {

                   }
               }
       );


    }
}