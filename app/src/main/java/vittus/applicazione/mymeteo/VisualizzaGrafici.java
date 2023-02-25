package vittus.applicazione.mymeteo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class VisualizzaGrafici extends AppCompatActivity {
    TrasformaDate tr = new TrasformaDate();
    String url, citta;
    Button btnTorna;
    TextView nomeCitta;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<String> umid = new ArrayList<>();
    ArrayList<String> pressione = new ArrayList<>();
    ArrayList<String> vel_vento = new ArrayList<>();
    ArrayList<String> pioggia = new ArrayList<>();
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_grafici);

        mQueue = Volley.newRequestQueue(this);

        url = getIntent().getExtras().getString("url");
        citta = getIntent().getExtras().getString("citta");

        nomeCitta = (TextView) findViewById(R.id.nomeCitta);
        nomeCitta.setText(citta);

        btnTorna = (Button) findViewById(R.id.btnTornaDaGraph);

        preparaLista(url);

        btnTorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void preparaLista(String url){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int pio = 0;
                            data.clear();
                            temp.clear();
                            umid.clear();
                            pioggia.clear();
                            pressione.clear();
                            vel_vento.clear();
                            JSONArray jsonArray_time = response.getJSONObject("hourly").getJSONArray("time");
                            JSONArray jsonArray_temp = response.getJSONObject("hourly").getJSONArray("temperature_2m");
                            JSONArray jsonArray_umid = response.getJSONObject("hourly").getJSONArray("relativehumidity_2m");
                            JSONArray jsonArray_pressione = response.getJSONObject("hourly").getJSONArray("pressure_msl");
                            JSONArray jsonArray_vel_vento = response.getJSONObject("hourly").getJSONArray("windspeed_10m");
                            JSONArray jsonArray_pioggia = response.getJSONObject("hourly").getJSONArray("rain");
                            for(int i = 0; i < jsonArray_time.length(); i++){
                                data.add(tr.trasformaData(
                                        "yyy-MM-dd'T'HH:mm",
                                        "yyyy-MM-dd HH:mm",
                                        jsonArray_time.get(i).toString()
                                ));
                                temp.add(jsonArray_temp.get(i).toString());
                                umid.add(jsonArray_umid.get(i).toString());
                                pressione.add(jsonArray_pressione.get(i).toString());
                                vel_vento.add(jsonArray_vel_vento.get(i).toString());
                                pio += Double.parseDouble(jsonArray_pioggia.get(i).toString());
                                pioggia.add(String.valueOf(pio));
                            }
                            faiGrafici();

                        } catch (JSONException e) {
                            Toast.makeText(VisualizzaGrafici.this, e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VisualizzaGrafici.this, error.toString(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) ;
        mQueue.add(request);
    }

    public void faiGrafici(){
        GraphView graphTemp;
        GraphView graphUmid;
        GraphView graphVento;
        GraphView graphPressione;
        GraphView graphPioggia;
        graphTemp = findViewById(R.id.graph_temperature);
        graphUmid = findViewById(R.id.graph_umidita);
        graphVento = findViewById(R.id.graph_velVento);
        graphPressione = findViewById(R.id.graph_pressione);
        graphPioggia = findViewById(R.id.graph_pioggia);
        LineGraphSeries<DataPoint> seriesTemp = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> seriesUmid = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> seriesVento = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> seriesPressione = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> seriesPioggia = new LineGraphSeries<>();

        for (int i = 0; i < temp.size(); i++) {
            long timeInMilliseconds = formattaData(data.get(i));
            DataPoint pointTemp = new DataPoint(timeInMilliseconds, Double.parseDouble(temp.get(i)));
            DataPoint pointUmid = new DataPoint(timeInMilliseconds, Double.parseDouble(umid.get(i)));
            DataPoint pointVento = new DataPoint(timeInMilliseconds, Double.parseDouble(vel_vento.get(i)));
            DataPoint pointPressione = new DataPoint(timeInMilliseconds, Double.parseDouble(pressione.get(i)));
            DataPoint pointPioggia = new DataPoint(timeInMilliseconds, Double.parseDouble(pioggia.get(i)));
            seriesTemp.appendData(pointTemp, true, temp.size());
            seriesUmid.appendData(pointUmid, true, umid.size());
            seriesVento.appendData(pointVento, true, vel_vento.size());
            seriesPressione.appendData(pointPressione, true, pressione.size());
            seriesPioggia.appendData(pointPioggia, true, pioggia.size());
        }
        //graphTemp.setTitle(citta);
        seriesTemp.setColor(Color.BLUE);
        seriesTemp.setTitle("Temperatura");
        graphTemp.setTitleColor(Color.BLUE);
        graphTemp.setTitleTextSize(60);
        graphTemp.addSeries(seriesTemp);
        // Legenda
//        graphTemp.getLegendRenderer().setVisible(true);
//        graphTemp.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
//        graphTemp.getLegendRenderer().setBackgroundColor(Color.CYAN);
        // Titolo degli assi
        graphTemp.getGridLabelRenderer().setVerticalAxisTitle("°C");
        graphTemp.getGridLabelRenderer().setHorizontalAxisTitle("Data");
        graphTemp.getGridLabelRenderer().setTextSize(36);
        // Per la data
        graphTemp.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));

        seriesUmid.setColor(Color.RED);
        seriesUmid.setTitle("Umidità");
        graphUmid.setTitleColor(Color.BLUE);
        graphUmid.setTitleTextSize(60);
        graphUmid.addSeries(seriesUmid);
        // Legenda
//        graphUmid.getLegendRenderer().setVisible(true);
//        graphUmid.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
//        graphUmid.getLegendRenderer().setBackgroundColor(Color.CYAN);
        // Titolo degli assi
        graphUmid.getGridLabelRenderer().setVerticalAxisTitle("%");
        graphUmid.getGridLabelRenderer().setHorizontalAxisTitle("Data");
        graphUmid.getGridLabelRenderer().setTextSize(36);
        // Per la data
        graphUmid.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));

        seriesVento.setColor(Color.DKGRAY);
        seriesVento.setTitle("Vento");
        graphVento.setTitleColor(Color.BLUE);
        graphVento.setTitleTextSize(60);
        graphVento.addSeries(seriesVento);
        // Legenda
        //graphVento.getLegendRenderer().setVisible(true);
        //graphVento.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        //graphVento.getLegendRenderer().setBackgroundColor(Color.CYAN);
        // Titolo degli assi
        graphVento.getGridLabelRenderer().setVerticalAxisTitle("Km/h");
        graphVento.getGridLabelRenderer().setHorizontalAxisTitle("Data");
        graphVento.getGridLabelRenderer().setTextSize(36);
        // Per la data
        graphVento.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));

        seriesPressione.setColor(Color.MAGENTA);
        seriesPressione.setTitle("Pressione");
        graphPressione.setTitleColor(Color.BLUE);
        graphPressione.setTitleTextSize(60);
        graphPressione.addSeries(seriesPressione);
        // Legenda
//        graphPressione.getLegendRenderer().setVisible(true);
//        graphPressione.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
//        graphPressione.getLegendRenderer().setBackgroundColor(Color.CYAN);
        // Titolo degli assi
        graphPressione.getGridLabelRenderer().setVerticalAxisTitle("hPa");
        graphPressione.getGridLabelRenderer().setHorizontalAxisTitle("Data");
        graphPressione.getGridLabelRenderer().setTextSize(36);
        // Per la data
        graphPressione.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));

        seriesPioggia.setColor(Color.BLUE);
        seriesPioggia.setTitle("Pioggia");
        graphPioggia.setTitleColor(Color.BLUE);
        graphPioggia.setTitleTextSize(60);
        graphPioggia.addSeries(seriesPioggia);
        // Legenda
//        graphPioggia.getLegendRenderer().setVisible(true);
//        graphPioggia.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
//        graphPioggia.getLegendRenderer().setBackgroundColor(Color.CYAN);
        // Titolo degli assi
        graphPioggia.getGridLabelRenderer().setVerticalAxisTitle("mm");
        graphPioggia.getGridLabelRenderer().setHorizontalAxisTitle("Data");
        graphPioggia.getGridLabelRenderer().setTextSize(36);
        // Per la data
        graphPioggia.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));

    }

    long formattaData(String da){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ITALIAN);
        LocalDateTime localDate = LocalDateTime.parse(da, formatter);
        long timeInMilliseconds = localDate.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
        return timeInMilliseconds;
    }
}