package com.baf.musafir.bafphonebook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.baf.musafir.bafphonebook.R;
import com.baf.musafir.bafphonebook.databse.DataBaseUtility;
import com.baf.musafir.bafphonebook.holder.AllLocationListVector;
import com.baf.musafir.bafphonebook.model.LocationListModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

public class LocationMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private String TAG="LocationMapActivity";
private Context mContext;
    private GoogleMap mMap;
    static LatLng LAT_LONG = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);
        mContext=this;
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**********************************************************
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device.
     * This method will only be triggered once the user has installed
     Google Play services and returned to the app.
     **********************************************************/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMyLocationEnabled(true);


        try {
            GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.bdallgeo, getApplicationContext());

            GeoJsonPolygonStyle style = layer.getDefaultPolygonStyle();
            style.setFillColor(Color.GREEN);
            style.setStrokeColor(Color.RED);
            style.setStrokeWidth(5F);

            layer.addLayerToMap();

        } catch (IOException ex) {
            Log.e("IOException", ex.getLocalizedMessage());
        } catch (JSONException ex) {
            Log.e("JSONException", ex.getLocalizedMessage());
        }


        getLocation();
    }
    private void getLocation() {
        for (int i = 0; i < AllLocationListVector.getAllLocationlist().size(); i++) {
            LocationListModel query = AllLocationListVector.getAllLocationlist().elementAt(i);

            try {
                LAT_LONG = new LatLng(Double.parseDouble(query.getLatitude()), Double.parseDouble(query.getLongitude()));
                drawMarker(new LatLng(Double.parseDouble(query.getLatitude()), Double.parseDouble(query.getLongitude())),query.getPlace_name(),query.getService_id());
                // Move the camera instantly to hamburg with a zoom of 15.
                CameraPosition cameraPosition = new CameraPosition.Builder().target(
                        new LatLng(Double.parseDouble(AllLocationListVector.getAllLocationlist().elementAt(2).getLatitude()),
                                Double.parseDouble(AllLocationListVector.getAllLocationlist().elementAt(2).getLongitude()))).zoom(7).build();
                Log.i(TAG,"Location ARe "+AllLocationListVector.getAllLocationlist().elementAt(2).getLatitude());
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                // Zoom in, animating the camera.
                //mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void drawMarker(LatLng point,String title,String serviceId) {
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions=null;
        if(serviceId.equalsIgnoreCase("1")){
             markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory
                    .fromResource(R.drawable.location));
        }else if(serviceId.equalsIgnoreCase("2")){
            markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory
                    .fromResource(R.drawable.army_loc));
        }


        // Setting latitude and longitude for the marker
        markerOptions.position(point);
        mMap.addMarker(markerOptions.title(title));

        // Adding marker on the Google Map


    }




}
