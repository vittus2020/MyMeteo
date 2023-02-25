package vittus.applicazione.mymeteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
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

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Liste liste = new Liste();
    TrasformaDate tr = new TrasformaDate();
    String[] citta;
    String url, citta_selezionata;
    String time ,temp, vel_vento, dir_vento, code, codice;
    Map<Integer, String> tipo_tempo;
    Map<Integer, Integer> imgCondizioni;
    RequestQueue mQueue;
    Spinner sceltaCitta;
    TextView dataDettaglio, condizioneAttuale, tempAttuale, ventoAttuale, direzAttuale;
    ImageView imgDettaglio;
    Button btnEsci, btnGrafici, btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);

        citta = getResources().getStringArray(R.array.listaCitta);
        citta_selezionata = citta[0];
        url = liste.listaCoordinate().get(citta_selezionata)+"&current_weather=true";
        tipo_tempo = liste.tipoWeather();
        imgCondizioni = liste.imgCondizioni();


        sceltaCitta = (Spinner) findViewById(R.id.lista_citta);
        dataDettaglio = (TextView) findViewById(R.id.dataDettaglio);
        condizioneAttuale = (TextView) findViewById(R.id.condizioneAttuale);
        tempAttuale = (TextView) findViewById(R.id.tempAttuale);
        ventoAttuale = (TextView) findViewById(R.id.ventoAttuale);
        direzAttuale = (TextView) findViewById(R.id.direzAttuale);

        imgDettaglio = (ImageView) findViewById(R.id.imgDettaglio);

        btnEsci = (Button) findViewById(R.id.btnEsci);
        btnGrafici = (Button) findViewById(R.id.btnGrafici);
        btnLista = (Button) findViewById(R.id.btnLista);

        preparaDati();

        sceltaCitta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                citta_selezionata = citta[position];
                url = liste.listaCoordinate().get(citta_selezionata)+"&current_weather=true";
                preparaDati();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnEsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListaDati.class);
                i.putExtra("url", url);
                i.putExtra("citta", citta_selezionata);
                startActivity(i);
            }
        });

        btnGrafici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VisualizzaGrafici.class);
                i.putExtra("url", url);
                i.putExtra("citta", citta_selezionata);
                startActivity(i);
            }
        });

    }

    public void preparaDati(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject current = response.getJSONObject("current_weather");
                            time = tr.trasformaData(
                                    "yyy-MM-dd'T'HH:mm",
                                    "EEEE dd MMMM yyyy HH:mm",
                                    current.getString("time")
                            );
                            temp = current.getString("temperature");
                            vel_vento = current.getString("windspeed");
                            dir_vento = current.getString("winddirection");
                            codice = current.getString("weathercode");
                            code = tipo_tempo.get(Integer.valueOf(codice));
                            scriviCondizioni();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) ;
        mQueue.add(request);
    }

    public void scriviCondizioni(){
        dataDettaglio.setText(time);
        imgDettaglio.setImageResource(imgCondizioni.get(Integer.parseInt(codice)));
        condizioneAttuale.setText(code);
        tempAttuale.setText(temp);
        ventoAttuale.setText(vel_vento);
        direzAttuale.setText(dir_vento);
    }

}