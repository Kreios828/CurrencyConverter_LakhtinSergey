package space.kreios.jsonparcerjava;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        Button buttonConverter = findViewById(R.id.button_converter);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });

        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Converter.class);
                startActivity(intent);

            }
        });

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

//Парсинг необходимых валют - начало
                            JSONObject aud = jsonObject.getJSONObject("AUD");
                                final String audCode = aud.getString("CharCode");
                                final double audValue = aud.getDouble("Value");

                            JSONObject azn = jsonObject.getJSONObject("AZN");
                                final String aznCode = azn.getString("CharCode");
                                final double aznValue = azn.getDouble("Value");

                            JSONObject gbp = jsonObject.getJSONObject("GBP");
                                final String gbpCode = gbp.getString("CharCode");
                                final double gbpValue = gbp.getDouble("Value");

                            JSONObject amd = jsonObject.getJSONObject("AMD");
                                final String amdCode = amd.getString("CharCode");
                                final double amdValue = amd.getDouble("Value");

                            JSONObject byn = jsonObject.getJSONObject("BYN");
                                final String bynCode = byn.getString("CharCode");
                                final double bynValue = byn.getDouble("Value");

                            JSONObject bgn = jsonObject.getJSONObject("BGN");
                                final String bgnCode = bgn.getString("CharCode");
                                final double bgnValue = bgn.getDouble("Value");

                            JSONObject brl = jsonObject.getJSONObject("BRL");
                                final String brlCode = brl.getString("CharCode");
                                final double brlValue = brl.getDouble("Value");

                            JSONObject huf = jsonObject.getJSONObject("HUF");
                                final String hufCode = huf.getString("CharCode");
                                final double hufValue = huf.getDouble("Value");

                            JSONObject hkd = jsonObject.getJSONObject("HKD");
                                final String hkdCode = hkd.getString("CharCode");
                                final double hkdValue = hkd.getDouble("Value");

                            JSONObject dkk = jsonObject.getJSONObject("DKK");
                                final String dkkCode = dkk.getString("CharCode");
                                final double dkkValue = dkk.getDouble("Value");

                            JSONObject usd = jsonObject.getJSONObject("USD");
                                final String usdCode = usd.getString("CharCode");
                                final double usdValue = usd.getDouble("Value");

                            JSONObject eur = jsonObject.getJSONObject("EUR");
                                final String eurCode = eur.getString("CharCode");
                                final double eurValue = eur.getDouble("Value");

                            JSONObject inr = jsonObject.getJSONObject("INR");
                                final String inrCode = inr.getString("CharCode");
                                final double inrValue = inr.getDouble("Value");

                            JSONObject kzt = jsonObject.getJSONObject("KZT");
                                final String kztCode = kzt.getString("CharCode");
                                final double kztValue = kzt.getDouble("Value");

                            JSONObject cad = jsonObject.getJSONObject("CAD");
                                final String cadCode = cad.getString("CharCode");
                                final double cadValue = cad.getDouble("Value");

                            JSONObject kgs = jsonObject.getJSONObject("KGS");
                                final String kgsCode = kgs.getString("CharCode");
                                final double kgsValue = kgs.getDouble("Value");

                            JSONObject cny = jsonObject.getJSONObject("CNY");
                                final String cnyCode = cny.getString("CharCode");
                                final double cnyValue = cny.getDouble("Value");

                            JSONObject mdl = jsonObject.getJSONObject("MDL");
                                final String mdlCode = mdl.getString("CharCode");
                                final double mdlValue = mdl.getDouble("Value");

                            JSONObject nok = jsonObject.getJSONObject("NOK");
                                final String nokCode = nok.getString("CharCode");
                                final double nokValue = nok.getDouble("Value");

                            JSONObject pln = jsonObject.getJSONObject("PLN");
                                final String plnCode = pln.getString("CharCode");
                                final double plnValue = pln.getDouble("Value");

                            JSONObject ron = jsonObject.getJSONObject("RON");
                                final String ronCode = ron.getString("CharCode");
                                final double ronValue = ron.getDouble("Value");

                            JSONObject xdr = jsonObject.getJSONObject("XDR");
                                final String xdrCode = xdr.getString("CharCode");
                                final double xdrValue = xdr.getDouble("Value");

                            JSONObject sgd = jsonObject.getJSONObject("SGD");
                                final String sgdCode = sgd.getString("CharCode");
                                final double sgdValue = sgd.getDouble("Value");

                            JSONObject tjs = jsonObject.getJSONObject("TJS");
                                final String tjsCode = tjs.getString("CharCode");
                                final double tjsValue = tjs.getDouble("Value");

                            JSONObject tri = jsonObject.getJSONObject("TRY");
                                final String triCode = tri.getString("CharCode");
                                final double triValue = tri.getDouble("Value");

                            JSONObject tmt = jsonObject.getJSONObject("TMT");
                                final String tmtCode = tmt.getString("CharCode");
                                final double tmtValue = tmt.getDouble("Value");

                            JSONObject uzs = jsonObject.getJSONObject("UZS");
                                final String uzsCode = uzs.getString("CharCode");
                                final double uzsValue = uzs.getDouble("Value");

                            JSONObject uah = jsonObject.getJSONObject("UAH");
                                final String uahCode = uah.getString("CharCode");
                                final double uahValue = uah.getDouble("Value");

                            JSONObject czk = jsonObject.getJSONObject("CZK");
                                final String czkCode = czk.getString("CharCode");
                                final double czkValue = czk.getDouble("Value");

                            JSONObject sek = jsonObject.getJSONObject("SEK");
                                final String sekCode = sek.getString("CharCode");
                                final double sekValue = sek.getDouble("Value");

                            JSONObject chf = jsonObject.getJSONObject("CHF");
                                final String chfCode = chf.getString("CharCode");
                                final double chfValue = chf.getDouble("Value");

                            JSONObject zar = jsonObject.getJSONObject("ZAR");
                                final String zarCode = zar.getString("CharCode");
                                final double zarValue = zar.getDouble("Value");

                            JSONObject krw = jsonObject.getJSONObject("KRW");
                                final String krwCode = krw.getString("CharCode");
                                final double krwValue = krw.getDouble("Value");

                            JSONObject jpy = jsonObject.getJSONObject("JPY");
                                final String jpyCode = jpy.getString("CharCode");
                                final double jpyValue = jpy.getDouble("Value");

//Парсинг необходимых валют - конец

// Установка таймера обновления курса на 30 сек - начало
                            CountDownTimer myCountDownTimer = new CountDownTimer(1000000000, 30000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    //Toast toast = Toast.makeText(MainActivity.this ,"Обновлено", Toast.LENGTH_SHORT);
                                    //toast.show();

                                    mTextViewResult.setText("");
                                    appending(audCode, audValue);
                                    appending(aznCode, aznValue);
                                    appending(gbpCode, gbpValue);
                                    appending(amdCode, amdValue);
                                    appending(bynCode, bynValue);
                                    appending(bgnCode, bgnValue);
                                    appending(brlCode, brlValue);
                                    appending(hufCode, hufValue);
                                    appending(hkdCode, hkdValue);
                                    appending(dkkCode, dkkValue);
                                    appending(usdCode, usdValue);
                                    appending(eurCode, eurValue);
                                    appending(inrCode, inrValue);
                                    appending(kztCode, kztValue);
                                    appending(cadCode, cadValue);
                                    appending(kgsCode, kgsValue);
                                    appending(cnyCode, cnyValue);
                                    appending(mdlCode, mdlValue);
                                    appending(nokCode, nokValue);
                                    appending(plnCode, plnValue);
                                    appending(ronCode, ronValue);
                                    appending(xdrCode, xdrValue);
                                    appending(sgdCode, sgdValue);
                                    appending(tjsCode, tjsValue);
                                    appending(triCode, triValue);
                                    appending(tmtCode, tmtValue);
                                    appending(uzsCode, uzsValue);
                                    appending(uahCode, uahValue);
                                    appending(czkCode, czkValue);
                                    appending(sekCode, sekValue);
                                    appending(chfCode, chfValue);
                                    appending(zarCode, zarValue);
                                    appending(krwCode, krwValue);
                                    appending(jpyCode, jpyValue);
                                }

                                @Override
                                public void onFinish() {
                                    Toast toast = Toast.makeText(MainActivity.this ,"Больше не обновляет", Toast.LENGTH_SHORT);
                                    toast.show();
                                    mTextViewResult.setText("");
                                }
                            } .start();
// Установка таймера обновления курса на 30 сек - конец

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
    private void appending(String charCode, Double value) {
        mTextViewResult.append("\n" + charCode + " : " + String.valueOf(value));
    }



}