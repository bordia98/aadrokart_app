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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

public class compress_preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compress_preview);
        setTitle("Preview");

        Bundle b = getIntent().getExtras();
        if(getIntent().hasExtra("path"))
        {
            String cpickuri_str = b.getString("path");
            //Uri cpickuri = Uri.parse(cpickuri_str);
            Bitmap bitmap = BitmapFactory.decodeFile(cpickuri_str);
            ImageView compress_upload = (ImageView)findViewById(R.id.compress_upload);
            compress_upload.setImageBitmap(bitmap);
        }

        final Button cnextbutton = (Button)findViewById(R.id.cnextbutton);


        cnextbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent k = new Intent(compress_preview.this,MainActivity.class);

                        ImageView compress_transfer_image = (ImageView)findViewById(R.id.compress_upload);
                        compress_transfer_image.buildDrawingCache();   // building bitmap
                        Bitmap compress_transfer_bitmap =compress_transfer_image.getDrawingCache(); // getting bitmap object

                      //  ByteArrayOutputStream stream_compress = new ByteArrayOutputStream();     // converting bitmap to byte array
                     //   compress_transfer_bitmap.compress(Bitmap.CompressFormat.PNG, 1000, stream_compress);  // compressing in order to transfer
//
                      //  byte[] byteArraycompress = stream_compress.toByteArray();  // converting stream to byte array
                        String title = UUID.randomUUID().toString();
                        MediaStore.Images.Media.insertImage(getContentResolver(),compress_transfer_bitmap,title,"compressed");
                        Toast.makeText(compress_preview.this,"image saved to gallery",Toast.LENGTH_LONG).show();


                        startActivity(k);
                    }
                }
        );


    }

}

