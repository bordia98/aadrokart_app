package com.example.bordia98.drawer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

public class insert_text extends AppCompatActivity {

    byte[] byteArraycompress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_text);

        Bundle extras = getIntent().getExtras();
        byte[] byteArrayedit = extras.getByteArray("edit_transfer_image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayedit, 0, byteArrayedit.length);

        if (bmp != null) {
            // setting image
            ImageView insert_image = (ImageView) findViewById(R.id.insert_imageview);
            insert_image.setImageBitmap(bmp);
        }

        Button write = (Button) findViewById(R.id.write);
        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {


                ImageView resize_image = (ImageView) findViewById(R.id.insert_imageview);
                resize_image.setDrawingCacheEnabled(true);
                Bitmap saveimage =resize_image.getDrawingCache();

                TextView text = (TextView)findViewById(R.id.textinserted);
                text.buildDrawingCache();
                Bitmap textbitmap = text.getDrawingCache();

                float y = text.getY();
                float x = text.getX();
                byteArraycompress = mergeImages(saveimage,textbitmap,x,y);

               // Toast.makeText(insert_text.this,"image saved to gallery",Toast.LENGTH_LONG).show();
               // String title = UUID.randomUUID().toString();
                //MediaStore.Images.Media.insertImage(getContentResolver(),bmp_compress,title,"edited");
                Intent i = new Intent(insert_text.this,final_edit.class);

                i.putExtra("filtered_image",byteArraycompress);

                startActivity(i);


            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.write:{
                        EditText insertedtext = (EditText)findViewById(R.id.edittext);
                        String insert = insertedtext.getText().toString();
                        final TextView textinsert = (TextView)findViewById(R.id.textinserted);
                        textinsert.setText(insert);

                        final int windowwidth = getWindowManager().getDefaultDisplay().getWidth();

                        final int windowheight = getWindowManager().getDefaultDisplay().getHeight();
                        textinsert.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {

                                RelativeLayout.LayoutParams layoutParams1=(RelativeLayout.LayoutParams) textinsert.getLayoutParams();
                                switch(event.getActionMasked())
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        int x_cord = (int) event.getRawX();
                                        int y_cord = (int) event.getRawY();
                                        if (x_cord > windowwidth) {
                                            x_cord = windowwidth;
                                        }
                                        if (y_cord > windowheight) {
                                            y_cord = windowheight;
                                        }
                                        layoutParams1.leftMargin = x_cord-200;
                                        layoutParams1.topMargin = y_cord-300 ;
                                        textinsert.setLayoutParams(layoutParams1);
                                        break;
                                    default:
                                        break;
                                }

                                return true;}

                        });

                    }

                    break;

                }
            }
        });

    }



        public static byte[] mergeImages(Bitmap baseImage, Bitmap headerImage,float x ,float y) {
        Bitmap finalImage = Bitmap.createBitmap(baseImage.getWidth(), baseImage.getHeight(), baseImage.getConfig());
        Canvas canvas = new Canvas(finalImage);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        canvas.drawBitmap(baseImage, matrix, null);

        if(headerImage != null){
            android.graphics.Matrix mat = new android.graphics.Matrix();
            mat.setTranslate(x,y);
            canvas.drawBitmap(headerImage, mat, null);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        finalImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();

        return bytes;
    }

}