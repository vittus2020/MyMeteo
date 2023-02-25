package vittus.applicazione.mymeteo;

import java.util.HashMap;
import java.util.Map;

public class Liste {

    public Map<String, String> listaCoordinate(){
        HashMap<String, String> coordinate = new HashMap<String, String>();
        coordinate.put("Roma", "https://api.open-meteo.com/v1/forecast?latitude=41.87&longitude=12.43&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Milano", "https://api.open-meteo.com/v1/forecast?latitude=45.46&longitude=9.19&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Bologna", "https://api.open-meteo.com/v1/forecast?latitude=44.49&longitude=11.34&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Torino", "https://api.open-meteo.com/v1/forecast?latitude=45.07&longitude=7.69&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Udine", "https://api.open-meteo.com/v1/forecast?latitude=46.03&longitude=13.18&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Bergamo", "https://api.open-meteo.com/v1/forecast?latitude=45.70&longitude=9.67&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Venezia", "https://api.open-meteo.com/v1/forecast?latitude=45.60&longitude=11.46&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Genova", "https://api.open-meteo.com/v1/forecast?latitude=44.40&longitude=8.94&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Firenze", "https://api.open-meteo.com/v1/forecast?latitude=45.60&longitude=11.46&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Ancona", "https://api.open-meteo.com/v1/forecast?latitude=43.80&longitude=11.23&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Viterbo", "https://api.open-meteo.com/v1/forecast?latitude=42.42&longitude=12.11&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Pescara", "https://api.open-meteo.com/v1/forecast?latitude=42.46&longitude=14.20&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Napoli", "https://api.open-meteo.com/v1/forecast?latitude=40.88&longitude=14.52&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Reggio Calabria", "https://api.open-meteo.com/v1/forecast?latitude=38.11&longitude=15.66&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Palermo", "https://api.open-meteo.com/v1/forecast?latitude=38.13&longitude=13.34&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Catania", "https://api.open-meteo.com/v1/forecast?latitude=37.49&longitude=15.07&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Alessandria", "https://api.open-meteo.com/v1/forecast?latitude=44.91&longitude=8.61&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Cuneo", "https://api.open-meteo.com/v1/forecast?latitude=44.39&longitude=7.55&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Como", "https://api.open-meteo.com/v1/forecast?latitude=45.81&longitude=9.08&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Trento", "https://api.open-meteo.com/v1/forecast?latitude=46.07&longitude=11.12&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Gorizia", "https://api.open-meteo.com/v1/forecast?latitude=45.94&longitude=13.62&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Cagliari", "https://api.open-meteo.com/v1/forecast?latitude=39.23&longitude=9.12&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Sassari", "https://api.open-meteo.com/v1/forecast?latitude=40.73&longitude=8.56&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Budapest", "https://api.open-meteo.com/v1/forecast?latitude=47.50&longitude=19.04&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Mosca", "https://api.open-meteo.com/v1/forecast?latitude=55.75&longitude=37.62&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Stoccolma", "https://api.open-meteo.com/v1/forecast?latitude=59.33&longitude=18.07&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Helsinki", "https://api.open-meteo.com/v1/forecast?latitude=60.32&longitude=24.96&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Londra", "https://api.open-meteo.com/v1/forecast?latitude=51.51&longitude=-0.13&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        coordinate.put("Toronto", "https://api.open-meteo.com/v1/forecast?latitude=43.70&longitude=-79.42&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,pressure_msl,windspeed_10m,winddirection_10m,windgusts_10m");
        return coordinate;
    }

    public Map<Integer, String> tipoWeather(){
        HashMap<Integer, String> weather = new HashMap<Integer, String>();
        weather.put(0, "Sereno");
        weather.put(1, "Variabile");
        weather.put(2, "Parzialmente nuvoloso");
        weather.put(3, "Coperto");
        weather.put(45, "Nebbia");
        weather.put(48, "Brina");
        weather.put(51, "Leggera pioviggine");
        weather.put(53, "Moderata pioviggine");
        weather.put(55, "Densa pioviggine");
        weather.put(56, "Leggera pioviggine gelata");
        weather.put(57, "Densa pioviggine gelata");
        weather.put(61, "Pioggia leggera");
        weather.put(63, "Pioggia moderata");
        weather.put(65, "Pioggia intensa");
        weather.put(66, "Pioggia gelata leggera");
        weather.put(67, "Pioggia gelata intensa");
        weather.put(71, "Neve leggera");
        weather.put(73, "Neve moderata");
        weather.put(77, "Granelli di neve");
        weather.put(80, "Leggero rovescio di pioggia");
        weather.put(81, "Moderato rovescio di pioggia");
        weather.put(82, "Intenso rovescio di pioggia");
        weather.put(85, "Leggero rovescio di neve");
        weather.put(86, "Intenso rovescio di neve");
        weather.put(95, "Temporale");
        weather.put(96, "Temporale con leggera grandine");
        weather.put(99, "Temporale con intensa grandine");
        return weather;
    }

    public Map<Integer, Integer> imgCondizioni(){
        HashMap<Integer, Integer> condizioni = new HashMap<Integer, Integer>();
        condizioni.put(0, R.drawable.sereno);
        condizioni.put(1, R.drawable.variabile);
        condizioni.put(2, R.drawable.variabile);
        condizioni.put(3, R.drawable.coperto);
        condizioni.put(45, R.drawable.nebbia);
        condizioni.put(48, R.drawable.nebbia);
        condizioni.put(51, R.drawable.pioggia);
        condizioni.put(53, R.drawable.pioggia);
        condizioni.put(55, R.drawable.pioggia);
        condizioni.put(56, R.drawable.neve);
        condizioni.put(57, R.drawable.neve);
        condizioni.put(61, R.drawable.pioggia);
        condizioni.put(63, R.drawable.pioggia);
        condizioni.put(65, R.drawable.pioggia);
        condizioni.put(66, R.drawable.pioggia);
        condizioni.put(67, R.drawable.pioggia);
        condizioni.put(71, R.drawable.neve);
        condizioni.put(73, R.drawable.neve);
        condizioni.put(77, R.drawable.neve);
        condizioni.put(80, R.drawable.pioggia);
        condizioni.put(81, R.drawable.pioggia);
        condizioni.put(82, R.drawable.pioggia);
        condizioni.put(85, R.drawable.neve);
        condizioni.put(86, R.drawable.neve);
        condizioni.put(95, R.drawable.temporale);
        condizioni.put(96, R.drawable.temporale);
        condizioni.put(99, R.drawable.temporale);
        return condizioni;
    }

}
