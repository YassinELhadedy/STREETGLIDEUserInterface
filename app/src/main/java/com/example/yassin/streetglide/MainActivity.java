package com.example.yassin.streetglide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView zXingScannerView;
    private static int cam_scan=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);




    }
    public void home(View view){

        startActivity(new Intent(this,RunnerDashbord.class));
    }
    public void scan(View view){




            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        0);

            } else {
                getSupportActionBar().hide();
                cam_scan=1;
                zXingScannerView =new ZXingScannerView(getApplicationContext());
                setContentView(zXingScannerView);
                zXingScannerView.setResultHandler(this);
                zXingScannerView.startCamera();
            }



    }
    public void history(View view){
        startActivity(new Intent(this,History.class));
    }
    public void profile(View view){startActivity(new Intent(this,Profile.class));}


    @Override
    public void onBackPressed() {
        if (cam_scan==1){
            startActivity(new Intent(MainActivity.this,MainActivity.class));
            cam_scan=0;
        }
        else {
            moveTaskToBack(true);
        }

    }

    public void map(View view){
        String uri = "http://maps.google.com/";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);

    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    // scan();
//                    Intent i = new Intent(MainActivity.this, SimpleScannerActivity.class);
//                    startActivityForResult(i, 750);
//scan2
                    getSupportActionBar().hide();
                    zXingScannerView =new ZXingScannerView(getApplicationContext());
                    setContentView(zXingScannerView);
                    zXingScannerView.setResultHandler(this);
                    zXingScannerView.startCamera();
                    cam_scan=1;


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    startActivity(new Intent(MainActivity.this,MainActivity.class));


                    Toast.makeText(MainActivity.this, "You need to grant the application permission to use the camera, permession was denied earlier", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}