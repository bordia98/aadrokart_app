package com.example.bordia98.drawer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class final_resize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_resize);
        Bundle extras = getIntent().getExtras();
        byte[] byteArrayresize = extras.getByteArray("resize_transfer_image");
        final Bitmap bmp_resize = BitmapFactory.decodeByteArray(byteArrayresize, 0, byteArrayresize.length);   // converting byte array to bitmap again
        if (bmp_resize != null) {
            // setting image
            ImageView final_resize_image = (ImageView) findViewById(R.id.final_resize_imageview);
            final_resize_image.setImageBitmap(bmp_resize);

        }

        Button resize_done = (Button) findViewById(R.id.resize_done);
        Button save = (Button)findViewById(R.id.save_resized);

        resize_done.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView resize_image = (ImageView) findViewById(R.id.final_resize_imageview);
                        resize_image.setDrawingCacheEnabled(true);
                            Bitmap b =resize_image.getDrawingCache();
                            int Width=(int)(1.4*b.getWidth());
                            int Height =(int)(1.4*b.getHeight());

                        Bitmap scaledbitmap = getResizedBitmap(b,Width,Height);
                            BitmapDrawable bmd = new BitmapDrawable(scaledbitmap);
                           resize_image.setImageDrawable(bmd);

                    }
                }
        );
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView resize_image = (ImageView) findViewById(R.id.final_resize_imageview);
                        resize_image.setDrawingCacheEnabled(true);
                        Bitmap saveimage =resize_image.getDrawingCache();
                        String title = UUID.randomUUID().toString();
                        MediaStore.Images.Media.insertImage(getContentResolver(),saveimage,title,"resized");
                        Toast.makeText(final_resize.this,"image saved to gallery",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(final_resize.this,MainActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
// RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);
        return resizedBitmap;
    }

}




