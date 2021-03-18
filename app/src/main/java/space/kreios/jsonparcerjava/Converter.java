package space.kreios.jsonparcerjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;


public class Converter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RequestQueue mQueue;

    private TextView mTextValuteValue;
    private TextView mTextViewResult;
    public String valuteSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);



        mQueue = Volley.newRequestQueue(this);

        Button buttonBack = findViewById(R.id.button_back);
        Button buttonCalc = findViewById(R.id.button_calc);
        mTextValuteValue = findViewById(R.id.text_valute_value);
        mTextViewResult = findViewById(R.id.text_view_result);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.valuteString, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

// кнопка назад - начало
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Converter.this, MainActivity.class);
                startActivity(intent);
            }
        });
// кнопка назад - конец

// кнопка конвертации - начало
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnClick();
            }
        });
// кнопка конвертации - начало
    }

    public void onBtnClick() {
        EditText valuteRub = (EditText)findViewById(R.id.editText_input);
        TextView resText = (TextView)findViewById(R.id.text_view_result);

        double num1 = 0.0;
        double valuteValue = 0.0;

        String vV = mTextValuteValue.getText().toString();

        try {
            num1 = Double.parseDouble(valuteRub.getText().toString());
            valuteValue = Double.parseDouble(vV);

            double resSum = num1 / valuteValue;
            resText.setText(Double.toString(resSum));
        } catch (Exception e) {
            Toast toast = Toast.makeText(this,"Введите число в рублях", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String textValute = parent.getItemAtPosition(position).toString();
        valuteSelected = textValute;
        jsonParse();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void jsonParse() {
        String url = "https://www.cbr-xml-daily.ru/daily_json.js";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                //request successful
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("Valute");

                            JSONObject selected = jsonObject.getJSONObject(valuteSelected);
                            double selectedValue = selected.getDouble("Value");



                            mTextValuteValue.setText(String.valueOf(selectedValue));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                //request error
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        mQueue.add(request);
    }

}