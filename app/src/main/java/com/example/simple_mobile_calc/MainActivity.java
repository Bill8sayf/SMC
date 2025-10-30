package com.example.simple_mobile_calc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private Spinner spinner;
    private EditText Fnum;
    private EditText Snum;
    private Button button;
    private TextView Rview;


    private float calculate(String operation, float num1, float num2) {
        switch (operation) {
            case "Сложение":
                return num1 + num2;
            case "Вычитание":
                return num1 - num2;
            case "Умножение":
                return num1 * num2;
            case "Деление":
                if (num2 == 0) {
                    throw new ValidationException("Деление на ноль невозможно");
                }
                return num1 / num2;
            default:
                throw new ValidationException("Неизвестная операция");
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        Fnum = findViewById(R.id.FRST_num);
        Snum = findViewById(R.id.SCND_num);
        button = findViewById(R.id.button1);
        Rview = findViewById(R.id.RES_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"Сложение", "Вычитание", "Умножение", "Деление"}
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(v -> {
            try {
                float fnum = InputValidator.validateFloat(Fnum.getText().toString(), "Первое число");
                float snum = InputValidator.validateFloat(Snum.getText().toString(), "Второе число");

                String selectedOperation = spinner.getSelectedItem().toString();
                float result = calculate(selectedOperation, fnum, snum);

                //Toast.makeText(MainActivity.this, "Результат: " + result, Toast.LENGTH_SHORT).show();
                Rview.setText("Результат: " + result);

            } catch (ValidationException e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
