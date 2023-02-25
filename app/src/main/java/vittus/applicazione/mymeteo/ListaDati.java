package vittus.applicazione.mymeteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaDati extends AppCompatActivity {
    ListView listView;
    TrasformaDate tr = new TrasformaDate();
    String url, citta;
    TextView citta_lista;
    Button btnTorna;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<String> umid = new ArrayList<>();
    ArrayList<String> dewpoint = new ArrayList<>();
    ArrayList<String> percepita = new ArrayList<>();
    ArrayList<String> pressione = new ArrayList<>();
    ArrayList<String> vel_vento = new ArrayList<>();
    ArrayList<String> dir_vento = new ArrayList<>();
    ArrayList<String> raffica = new ArrayList<>();
    ArrayList<String> pioggia = new ArrayList<>();
    RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dati);

        mQueue = Volley.newRequestQueue(this);

        url = getIntent().getExtras().getString("url");
        citta = getIntent().getExtras().getString("citta");

        citta_lista = (TextView) findViewById(R.id.citta_lista);
        citta_lista.setText(citta);
        listView = (ListView) findViewById(R.id.lista_dati);

        btnTorna = (Button) findViewById(R.id.btnTornaDaLista);
        btnTorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        preparaLista(url);

    }

    public void preparaLista(String url){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            data.clear();
                            temp.clear();
                            umid.clear();
                            dewpoint.clear();
                            percepita.clear();
                            pioggia.clear();
                            pressione.clear();
                            vel_vento.clear();
                            dir_vento.clear();
                            raffica.clear();
                            JSONArray jsonArray_time = response.getJSONObject("hourly").getJSONArray("time");
                            JSONArray jsonArray_temp = response.getJSONObject("hourly").getJSONArray("temperature_2m");
                            JSONArray jsonArray_umid = response.getJSONObject("hourly").getJSONArray("relativehumidity_2m");
                            JSONArray jsonArray_dewpoint = response.getJSONObject("hourly").getJSONArray("dewpoint_2m");
                            JSONArray jsonArray_percepita = response.getJSONObject("hourly").getJSONArray("apparent_temperature");
                            JSONArray jsonArray_pioggia = response.getJSONObject("hourly").getJSONArray("rain");
                            JSONArray jsonArray_pressione = response.getJSONObject("hourly").getJSONArray("pressure_msl");
                            JSONArray jsonArray_vel_vento = response.getJSONObject("hourly").getJSONArray("windspeed_10m");
                            JSONArray jsonArray_dir_vento = response.getJSONObject("hourly").getJSONArray("winddirection_10m");
                            JSONArray jsonArray_raffica = response.getJSONObject("hourly").getJSONArray("windgusts_10m");
                            for(int i = 0; i < jsonArray_time.length(); i++){
                                data.add(tr.trasformaData(
                                        "yyy-MM-dd'T'HH:mm",
                                        "EEEE dd MMMM yyyy HH:mm",
                                        jsonArray_time.get(i).toString()
                                ));
                                temp.add(jsonArray_temp.get(i).toString());
                                umid.add(jsonArray_umid.get(i).toString());
                                dewpoint.add(jsonArray_dewpoint.get(i).toString());
                                percepita.add(jsonArray_percepita.get(i).toString());
                                pioggia.add(jsonArray_pioggia.get(i).toString());
                                pressione.add(jsonArray_pressione.get(i).toString());
                                vel_vento.add(jsonArray_vel_vento.get(i).toString());
                                dir_vento.add(jsonArray_dir_vento.get(i).toString());
                                raffica.add(jsonArray_raffica.get(i).toString());
                            }
                            faiLista();
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

    public void faiLista(){
        CustomAdapterLista cu = new CustomAdapterLista(
                getApplicationContext(),
                data,
                temp,
                umid,
                dewpoint,
                percepita,
                pressione,
                vel_vento,
                dir_vento,
                raffica,
                pioggia
        );
        listView.setAdapter(cu);
    }

}