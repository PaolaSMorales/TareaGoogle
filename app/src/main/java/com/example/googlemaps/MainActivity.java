package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
GoogleMap Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
    Mapa=googleMap;
    moverMapa();
    CambiarVista();
    pintarPoligono();
    marcadores();
    //Mapa.setOnMapClickListener(this);
    }

    public void CambiarVista()
    {
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void moverMapa()
    {
        CameraUpdate camUpd1 =CameraUpdateFactory.newLatLngZoom(new LatLng(-1.012941, -79.469499), 17);
        Mapa.moveCamera(camUpd1);
    }
    public void pintarPoligono()
    {
        PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(-1.011906, -79.467090))
                .add(new LatLng(-1.013820, -79.467294))
                .add(new LatLng(-1.013622, -79.471934))
                .add(new LatLng(-1.011782, -79.471875))
                .add(new LatLng(-1.011906, -79.467090));
        lineas.width(8);
        lineas.color(Color.RED);
        Mapa.addPolyline(lineas);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Mapa.addMarker(new MarkerOptions().position(latLng).title("Hola"));
        Projection proj = Mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(MainActivity.this,"Click\n" +"Lat: " + latLng.latitude + "\n" +"Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,Toast.LENGTH_SHORT).show();
    }
    public void marcadores()
    {

        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012587, -79.470598)).title("Facultad Ciencias de la Ingeniería"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012673, -79.471108)).title("Facultad Ciencias Ambientales"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012168, -79.470164)).title("Facultad Ciencias Empresariales"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012238, -79.470738)).title("Agroindustrial"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012243, -79.469649)).title("Instituto de Informática"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012957, -79.469965)).title("Comedor"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012941, -79.469354)).title("Facultad Ciencias Agrarias"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012286, -79.468823)).title("Departamento Médico"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012957, -79.467707)).title("Auditorio"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.013053, -79.467980)).title("Prodeuteq"));
    }
}