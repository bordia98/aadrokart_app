package com.example.bordia98.drawer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class resize_preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize_preview);
        setTitle("Preview");

        if(getIntent().hasExtra("gallery_image"))
        {
            Bundle b = getIntent().getExtras();

            byte[] byteArray_resize = b.getByteArray("gallery_image");
            final Bitmap bmp = BitmapFactory.decodeByteArray(byteArray_resize, 0, byteArray_resize.length);
            ImageView resize_upload = (ImageView)findViewById(R.id.resize_upload);
            resize_upload.setImageBitmap(bmp);
        }

        final Button rnextbutton = (Button)findViewById(R.id.rnextbutton);
        final Button rbackbutton = (Button)findViewById(R.id.rbackbutton);

        rnextbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent k = new Intent(resize_preview.this,final_resize.class);

                        ImageView resize_transfer_image = (ImageView)findViewById(R.id.resize_upload);
                        resize_transfer_image.buildDrawingCache();   // building bitmap
                        Bitmap resize_transfer_bitmap =resize_transfer_image.getDrawingCache(); // getting bitmap object

                        ByteArrayOutputStream stream_resize = new ByteArrayOutputStream();     // converting bitmap to byte array
                        resize_transfer_bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream_resize);  // compressing in order to transfer

                        byte[] byteArrayresize = stream_resize.toByteArray();  // converting stream to byte array

                        k.putExtra("resize_transfer_image",byteArrayresize);

                        startActivity(k);
                    }
                }
        );

        rbackbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent w = new Intent(resize_preview.this,MainActivity.class);
                        startActivity(w);
                    }
                }
        );


    }

}
