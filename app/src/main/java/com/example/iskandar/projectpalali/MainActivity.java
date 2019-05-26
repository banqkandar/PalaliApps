package com.example.iskandar.projectpalali;

import androidx.annotation.NonNull;

import com.example.iskandar.projectpalali.fragment.home;
import com.example.iskandar.projectpalali.fragment.larangan;
import com.example.iskandar.projectpalali.fragment.peringatan;
import com.example.iskandar.projectpalali.fragment.perintah;
import com.example.iskandar.projectpalali.fragment.uuRambu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.ibm.watson.developer_cloud.android.library.camera.CameraHelper;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView hasil;

    FloatingActionButton fab_upload, fab_kamera, fab_plus;
    Animation FabOpen, FabClose, FabClockwise, FabAntiClockwise;
    boolean isOpen = false;

    private VisualRecognition vrClient;
    private CameraHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Visual Recognition client
        vrClient = new VisualRecognition(
                VisualRecognition.VERSION_DATE_2016_05_20,
                getString(R.string.api_key)
        );

        // Initialize camera helper
        helper = new CameraHelper(this);

        //Floating action Button
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_kamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        fab_upload = (FloatingActionButton) findViewById(R.id.fab_insert);

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabAntiClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_upload.startAnimation(FabClose);
                    fab_kamera.startAnimation(FabClose);
                    fab_plus.startAnimation(FabAntiClockwise);
                    fab_kamera.setClickable(false);
                    fab_upload.setClickable(false);
                    isOpen = false;
                } else {
                    fab_upload.startAnimation(FabOpen);
                    fab_kamera.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabClockwise);
                    fab_kamera.setClickable(true);
                    fab_upload.setClickable(true);
                    isOpen = true;
                }
            }
        });

        //camera
        //Disable the button if the user has no camera
        if (!hasCamera())
            fab_kamera.setEnabled(false);

        fab_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            //launching the camera
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ambil Gambar", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        });

        fab_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            //launching the camera
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Upload Image!", Toast.LENGTH_LONG).show();
            }
        });

        //Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);

        //Drawer Navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    //Bottom Navigation
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new home();
                            break;
                        case R.id.nav_uu:
                            selectedFragment = new uuRambu();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    //Drawer Navogation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new home()).commit();
                break;
            case R.id.nav_peringatan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new peringatan()).commit();
                break;
            case R.id.nav_larangan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new larangan()).commit();
                break;
            case R.id.nav_perintah:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new perintah()).commit();
                break;
            case R.id.nav_uu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new uuRambu()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //check if the user has a camera
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void takePicture(View view) {
        // More code here
        helper.dispatchTakePictureIntent();
    }




//    if you want to return take Photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //get photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            hasil.setImageBitmap(photo);
        }
    }
}
