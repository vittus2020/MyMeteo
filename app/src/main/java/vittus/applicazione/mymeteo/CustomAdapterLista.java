package vittus.applicazione.mymeteo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterLista extends BaseAdapter {
    Context context;
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
    LayoutInflater inflater;

    public CustomAdapterLista(Context context, ArrayList<String> data, ArrayList<String> temp, ArrayList<String> umid, ArrayList<String> dewpoint, ArrayList<String> percepita, ArrayList<String> pressione, ArrayList<String> vel_vento, ArrayList<String> dir_vento, ArrayList<String> raffica, ArrayList<String> pioggia) {
        this.context = context;
        this.data = data;
        this.temp = temp;
        this.umid = umid;
        this.dewpoint = dewpoint;
        this.percepita = percepita;
        this.pressione = pressione;
        this.vel_vento = vel_vento;
        this.dir_vento = dir_vento;
        this.raffica = raffica;
        this.pioggia = pioggia;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
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
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_dettaglio_lista, null);
        TextView dat = (TextView) convertView.findViewById(R.id.data_lista);
        TextView t = (TextView) convertView.findViewById(R.id.temp_lista);
        TextView u = (TextView) convertView.findViewById(R.id.huLista);
        TextView dw = (TextView) convertView.findViewById(R.id.dwLista);
        TextView per = (TextView) convertView.findViewById(R.id.percLista);
        TextView pres = (TextView) convertView.findViewById(R.id.pressLista);
        TextView v = (TextView) convertView.findViewById(R.id.windLista);
        TextView d = (TextView) convertView.findViewById(R.id.dirLista);
        TextView raff = (TextView) convertView.findViewById(R.id.gustLista);
        TextView pio = (TextView) convertView.findViewById(R.id.pioggiaLista);
        dat.setText(data.get(i));
        t.setText(temp.get(i));
        u.setText(umid.get(i));
        dw.setText(dewpoint.get(i));
        per.setText(percepita.get(i));
        pres.setText(pressione.get(i));
        v.setText(vel_vento.get(i));
        d.setText(dir_vento.get(i));
        raff.setText(raffica.get(i));
        pio.setText(pioggia.get(i));
        return convertView;
    }
}
