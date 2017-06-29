package com.example.bordia98.drawer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class final_compress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_compress);
        setTitle("Compress");

        Bundle extras = getIntent().getExtras();
        byte[] byteArraycompress = extras.getByteArray("compress_transfer_image");
        Bitmap bmp_compress = BitmapFactory.decodeByteArray(byteArraycompress, 0, byteArraycompress.length);   // converting byte array to bitmap again
        if (bmp_compress != null) {
            // setting image
            ImageView final_compress_image = (ImageView)findViewById(R.id.final_compress_imageview);
            final_compress_image.setImageBitmap(bmp_compress);

        }
    }
}
