package com.example.bordia98.drawer;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.UUID;
import android.os.Handler;
import android.os.Message;
<<<<<<< HEAD
=======


>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import java.util.logging.LogRecord;

public class final_edit extends AppCompatActivity {

    final int PIC_CROP = 1;

    byte[] byteArrayfilter;

<<<<<<< HEAD
    Bitmap rotatedImage;

    float angle=0;
=======
    String edituri_str;
    Uri uri;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_edit);
        setTitle("EDIT");

        Bundle extras = getIntent().getExtras();
<<<<<<< HEAD
=======

        edituri_str = extras.getString("etansferuri");

        if(getIntent().hasExtra("etransferuri")) {
            byte[] byteArrayedit = extras.getByteArray("edit_transfer_image");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayedit, 0, byteArrayedit.length);   // converting byte array to bitmap again
            if (bmp != null) {
                // setting image
                ImageView iv = (ImageView) findViewById(R.id.final_edit_imageview);
                iv.setImageBitmap(bmp);

            }
        }



      if(getIntent().hasExtra("filtered_image"))
      {
          byte[] byteArrayFilter = extras.getByteArray("filtered_image");
          Bitmap filtered_image = BitmapFactory.decodeByteArray(byteArrayFilter,0,byteArrayFilter.length);
          if (filtered_image != null) {
          // setting image

          ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
          iv.setImageBitmap(filtered_image);
            }
      }




      if(getIntent().hasExtra("insertedtextimage")) {
          byte[] byteArraytext = extras.getByteArray("insertedtextimage");
          Bitmap texted_image = BitmapFactory.decodeByteArray(byteArraytext, 0, byteArraytext.length);
          if (texted_image != null) {
              // setting image

              ImageView iv = (ImageView) findViewById(R.id.final_edit_imageview);
              iv.setImageBitmap(texted_image);

          }
      }

  /*      byte[] byteArrayedit = extras.getByteArray("edit_transfer_image");
        byte[] byteArrayFilter = extras.getByteArray("filtered_image");
        Bitmap filtered_image = BitmapFactory.decodeByteArray(byteArrayFilter,0,byteArrayFilter.length);
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayedit, 0, byteArrayedit.length);   // converting byte array to bitmap again
        if (bmp != null) {
            // setting image
            ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
            iv.setImageBitmap(bmp);
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a

        if(getIntent().hasExtra("edit_transfer_image"))
       {
          byte[] byteArrayedit = extras.getByteArray("edit_transfer_image");
          Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayedit, 0, byteArrayedit.length);   // converting byte array to bitmap again
          if (bmp != null) {
              // setting image
              ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
              iv.setImageBitmap(bmp);

          }
       }

<<<<<<< HEAD
=======

    */



        ImageView rotate = (ImageView) findViewById(R.id.rotate);
        rotate.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
                    @Override
                    public void onClick(View v) {
                        ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap bMap = iv.getDrawingCache();

                       iv.setScaleType(ImageView.ScaleType.FIT_XY);
                        iv.setImageBitmap(Bitmap.createScaledBitmap(bMap, 510, 500,
                              false));
                       iv.setRotation(iv.getRotation() + 90);

                      /*   Matrix matrix = new Matrix();
                            matrix.postRotate(90);

                        int width = bMap.getWidth();
                        int height = bMap.getHeight();

                        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bMap,width,height,true);

                        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);
*/
                    //    iv.setImageBitmap(rotatedBitmap);
                    }
                }
        );




        ImageView textedit = (ImageView) findViewById(R.id.inserttext);
        textedit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent k = new Intent(final_edit.this,insert_text.class);
                        ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap c = iv.getDrawingCache();
                        ByteArrayOutputStream streamedit = new ByteArrayOutputStream();     // converting bitmap to byte array
                        c.compress(Bitmap.CompressFormat.PNG, 100, streamedit);  // compressing in order to transfer

                        byte[] byteArrayfilter = streamedit.toByteArray();  // converting stream to byte array

                        k.putExtra("edit_transfer_image",byteArrayfilter);

                        startActivity(k);


                    }
                }
        );
        ImageView crop = (ImageView) findViewById(R.id.crop);
        crop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        uri = Uri.parse(edituri_str);


                    }
                }
        );



        ImageView filterimage = (ImageView) findViewById(R.id.filter);


        filterimage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       Intent k = new Intent(final_edit.this,final_filter.class);
                        ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap c = iv.getDrawingCache();
                        ByteArrayOutputStream streamedit = new ByteArrayOutputStream();     // converting bitmap to byte array
                        c.compress(Bitmap.CompressFormat.PNG, 100, streamedit);  // compressing in order to transfer

                        byte[] byteArrayfilter = streamedit.toByteArray();  // converting stream to byte array

                        k.putExtra("edit_transfer_image",byteArrayfilter);

                        startActivity(k);



                    }
                }
        );

        Button save = (Button)findViewById(R.id.done);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView resize_image = (ImageView) findViewById(R.id.final_edit_imageview);
                        resize_image.setDrawingCacheEnabled(true);
                        Bitmap saveimage =resize_image.getDrawingCache();
                        String title = UUID.randomUUID().toString();
                        MediaStore.Images.Media.insertImage(getContentResolver(),saveimage,title,"resized");
                        Toast.makeText(final_edit.this,"image saved to gallery",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(final_edit.this,MainActivity.class);
                        startActivity(i);
                    }
                }
        );

    }
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a


      if(getIntent().hasExtra("filtered_image"))
      {
          byte[] byteArrayFilter = extras.getByteArray("filtered_image");
          Bitmap filtered_image = BitmapFactory.decodeByteArray(byteArrayFilter,0,byteArrayFilter.length);
          if (filtered_image != null) {
          // setting image

          ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
          iv.setImageBitmap(filtered_image);
            }
      }




      if(getIntent().hasExtra("insertedtextimage")) {
          byte[] byteArraytext = extras.getByteArray("insertedtextimage");
          Bitmap texted_image = BitmapFactory.decodeByteArray(byteArraytext, 0, byteArraytext.length);
          if (texted_image != null) {
              // setting image

              ImageView iv = (ImageView) findViewById(R.id.final_edit_imageview);
              iv.setImageBitmap(texted_image);

          }
      }

       final ImageView rotate = (ImageView) findViewById(R.id.rotate);
        rotate.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
                    @Override
                    public void onClick(View v) {
                        ImageView iv = (ImageView) findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap bMap = iv.getDrawingCache();
                        angle += 90;
                        rotatedImage = rotateImage(bMap, angle);
                        iv.setImageBitmap(rotatedImage);
                    }
                }
        );




        ImageView textedit = (ImageView) findViewById(R.id.inserttext);
        textedit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent k = new Intent(final_edit.this,insert_text.class);
                        ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap c = iv.getDrawingCache();
                        ByteArrayOutputStream streamedit = new ByteArrayOutputStream();     // converting bitmap to byte array
                        c.compress(Bitmap.CompressFormat.PNG, 100, streamedit);  // compressing in order to transfer

                        byte[] byteArrayfilter = streamedit.toByteArray();  // converting stream to byte array

                        k.putExtra("edit_transfer_image",byteArrayfilter);

                        startActivity(k);


                    }
                }
        );

        ImageView filterimage = (ImageView) findViewById(R.id.filter);


        filterimage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       Intent k = new Intent(final_edit.this,final_filter.class);
                        ImageView iv = (ImageView)findViewById(R.id.final_edit_imageview);
                        iv.setDrawingCacheEnabled(true);
                        Bitmap c = iv.getDrawingCache();
                        ByteArrayOutputStream streamedit = new ByteArrayOutputStream();     // converting bitmap to byte array
                        c.compress(Bitmap.CompressFormat.PNG, 100, streamedit);  // compressing in order to transfer

                        byte[] byteArrayfilter = streamedit.toByteArray();  // converting stream to byte array

                        k.putExtra("edit_transfer_image",byteArrayfilter);

                        startActivity(k);



                    }
                }
        );

        Button save = (Button)findViewById(R.id.done);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView resize_image = (ImageView) findViewById(R.id.final_edit_imageview);
                        resize_image.setDrawingCacheEnabled(true);
                        Bitmap saveimage =resize_image.getDrawingCache();
                        String title = UUID.randomUUID().toString();
                        MediaStore.Images.Media.insertImage(getContentResolver(),saveimage,title,"resized");
                        Toast.makeText(final_edit.this,"image saved to gallery",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(final_edit.this,MainActivity.class);
                        startActivity(i);
                    }
                }
        );

    }
    public static Bitmap rotateImage(Bitmap sourceImage, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(sourceImage, 0, 0, sourceImage.getWidth(), sourceImage.getHeight(), matrix, true);
    }


   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


}



