package com.example.mohammad.assignmentfour;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    ImageView mImg;
    Bitmap photo;
    Button picgit,getlocc;
    GPStracker2 g2;
    Location l2;
    static EditText lone,late;
    static double lon2;
    static double lat2;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picgit = (Button) findViewById(R.id.Getpic);
        getlocc = (Button) findViewById(R.id.getloc);

        mImg = (ImageView) findViewById(R.id.imageView);
        lone = (EditText) findViewById(R.id.lon);
        late = (EditText) findViewById(R.id.lat);

        picgit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


        }
    });
        getlocc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g2 = new GPStracker2(getApplicationContext());
                l2 = g2.getLocation2();
                if (l2 != null) {

                    lon2 = l2.getLongitude();
                    lat2 = l2.getLatitude();
                    Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 500 milliseconds
                    vv.vibrate(500);
                    lone.setText(String.valueOf(lon2));
                    late.setText(String.valueOf(lat2));


                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {

            Picasso.with(MainActivity.this).load(data.getData()).noPlaceholder().fit()
                    .into((ImageView) findViewById(R.id.imageView));


        }

    }
    }