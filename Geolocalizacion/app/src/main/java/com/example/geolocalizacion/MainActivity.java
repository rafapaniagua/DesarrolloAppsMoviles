package com.example.geolocalizacion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    TextView latitud_info, longitud_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitud_info = findViewById(R.id.latitud_info);
        longitud_info = findViewById(R.id.longitud_info);

        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void getLocation (View v){
        if(ActivityCompat.checkSelfPermission(
                MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else {
            this.fusedLocationClient.getLastLocation().addOnSuccessListener(
                    this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        latitud_info.setText(Double.toString(location.getLatitude()));
                        longitud_info.setText(Double.toString(location.getLongitude()));

                        Toast.makeText(getApplicationContext(),
                                location.getLatitude() + " --- " + location.getLongitude(),
                                Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "No tenemos ubicación", Toast.LENGTH_LONG).show();
                        latitud_info.setText("Nel");
                        longitud_info.setText("No hay");
                    }
                }
            });
        }
    }
}
