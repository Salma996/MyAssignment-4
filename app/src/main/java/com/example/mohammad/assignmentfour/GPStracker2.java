package com.example.mohammad.assignmentfour;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by Mohammed on 12/12/2017.
 */

public class GPStracker2 implements LocationListener {
    Context context;

    public GPStracker2(Context c) {
        context = c;

    }

    public Location getLocation2() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "permission not generated ", Toast.LENGTH_SHORT).show();
            return null;

        }
        LocationManager LM = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnable = LM.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isGPSEnable) {
            LM.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
            Location i2 = LM.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return i2;

        } else {
            Toast.makeText(context, "please turn on the GPS ", Toast.LENGTH_SHORT).show();
            return null;
        }

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
