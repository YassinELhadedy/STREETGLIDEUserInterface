package com.example.yassin.streetglide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yassin.streetglide.Fragments.CashCollect;
import com.example.yassin.streetglide.Fragments.DeliveryStatus;
import com.example.yassin.streetglide.adapter.DataAdapter;
import com.example.yassin.streetglide.model.Shipment;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class RunnerDashbord extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    LinearLayout scanshipment,deliverystatus,cashcollect;
    private ZXingScannerView zXingScannerView;
    private static int cam_scan=0;
    private FragmentTransaction fragmentTransaction;


    private RecyclerView recyclerView;
    private ArrayList<Shipment> pickUpList;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_dashbord);
        scanshipment=(LinearLayout)findViewById(R.id.scanshipment);
        deliverystatus=(LinearLayout)findViewById(R.id.deliverystatus);
        cashcollect=(LinearLayout)findViewById(R.id.cashcollect);




        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.homebar);


     //  set_recycleview("#FEDD00");
        setStart();

    }
    @Override
    public void onBackPressed() {
        if (cam_scan==1){
            startActivity(new Intent(RunnerDashbord.this,RunnerDashbord.class));
            cam_scan=0;
        }
        else {
           startActivity(new Intent(RunnerDashbord.this,MainActivity.class));
        }
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
                    startActivity(new Intent(RunnerDashbord.this,RunnerDashbord.class));


                    Toast.makeText(RunnerDashbord.this, "You need to grant the application permission to use the camera, permession was denied earlier", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);

    }


    public void scanshipment(View v){
        scanshipment.setBackgroundColor(Color.parseColor("#FEDD00"));
        deliverystatus.setBackgroundColor(0x00000000);


        if (ContextCompat.checkSelfPermission(RunnerDashbord.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(RunnerDashbord.this,
                    new String[]{Manifest.permission.CAMERA},
                    0);

        } else {
            getSupportActionBar().hide();
            zXingScannerView =new ZXingScannerView(getApplicationContext());
            setContentView(zXingScannerView);
            zXingScannerView.setResultHandler(this);
            zXingScannerView.startCamera();
            cam_scan=1;
        }


    }
    public void cashcollect(View view){
        cashcollect.setBackgroundColor(Color.parseColor("#FEDD00"));
        deliverystatus.setBackgroundColor(0x00000000);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment cashCollect=new CashCollect();
        fragmentTransaction.replace(R.id.framelayout, cashCollect,"cashCollect");
        fragmentTransaction.commit();





    }
    public void deliverystatus(View view){
        deliverystatus.setBackgroundColor(Color.parseColor("#FEDD00"));
        cashcollect.setBackgroundColor(0x00000000);
      //  set_recycleview("#FEDD00");
        setStart();


    }
    public void menu(View view){

        startActivity(new Intent(RunnerDashbord.this,MainActivity.class));
    }
    public void setStart(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment deliveryStatus=new DeliveryStatus();
        fragmentTransaction.replace(R.id.framelayout, deliveryStatus,"deliveryStatus");
        fragmentTransaction.commit();
    }

    public void set_recycleview(String color){
        recyclerView= (RecyclerView) findViewById(R.id.recycleviewh);
        pickUpList = new ArrayList<>();

        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        adapter= new DataAdapter(pickUpList, RunnerDashbord.this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(RunnerDashbord.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
//    public void pending(View view){
//        set_recycleview("#FEDD00");
//        adapter.notifyDataSetChanged();
//    }
//    public void delivered(View view){
//        set_recycleview("#43CD80");
//        adapter.notifyDataSetChanged();
//    }
//    public void undelivered(View view){
//        set_recycleview("#FF4500");
//        adapter.notifyDataSetChanged();
//    }

}
