package com.example.bordia98.drawer;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.UriPermission;
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

public class edit_preview extends AppCompatActivity {
    String epickuri_str;

    private static final int PIC_CROP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_activity);
        setTitle("Preview");

        Bundle b = getIntent().getExtras();
<<<<<<< HEAD
        if (getIntent().hasExtra("cropped_image")) {

            byte[] byteArrayedit = b.getByteArray("cropped_image");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArrayedit, 0, byteArrayedit.length);   // converting byte array to bitmap again
            if (bmp != null) {
                // setting image
                ImageView iv = (ImageView) findViewById(R.id.edit_upload);
                iv.setImageBitmap(bmp);

            }
=======
        if (getIntent().hasExtra("epickuri")){
            epickuri_str = b.getString("epickuri");
            Uri epickuri = Uri.parse(epickuri_str);
            ImageView galleryupload = (ImageView) findViewById(R.id.edit_upload);
            galleryupload.setImageURI(epickuri);
        }
        if(getIntent().hasExtra("euri"))
        {

          /*  ImageView galleryupload = (ImageView) findViewById(R.id.edit_upload);
            File file = new File(android.os.Environment.getExternalStorageDirectory(), "edit.jpeg");
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            galleryupload.setImageBitmap(bitmap);
        */
            epickuri_str = b.getString("euri");
            Uri epickuri = Uri.parse(epickuri_str);
            ImageView galleryupload = (ImageView) findViewById(R.id.edit_upload);
            galleryupload.setImageURI(epickuri);
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
        }

        final Button enextbutton = (Button) findViewById(R.id.enextbutton);
        final Button ebackbutton = (Button) findViewById(R.id.ebackbutton);

        enextbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
<<<<<<< HEAD
                        Intent k = new Intent(edit_preview.this, final_edit.class);
=======

                        Intent k = new Intent(edit_preview.this,final_edit.class);
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a

                        ImageView edit_transfer_image = (ImageView) findViewById(R.id.edit_upload);
                        edit_transfer_image.buildDrawingCache();   // building bitmap
                        Bitmap edit_transfer_bitmap = edit_transfer_image.getDrawingCache(); // getting bitmap object

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();     // converting bitmap to byte array
                        edit_transfer_bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);  // compressing in order to transfer

                        byte[] byteArrayedit = stream.toByteArray();  // converting stream to byte array

<<<<<<< HEAD
                        k.putExtra("edit_transfer_image", byteArrayedit);

=======
                        k.putExtra("edit_transfer_image",byteArrayedit);
                        k.putExtra("etransferuri",epickuri_str);
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
                        startActivity(k);
                    }

                }
        );

        ebackbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent w = new Intent(edit_preview.this, MainActivity.class);
                        startActivity(w);
                    }
                }
        );


    }

<<<<<<< HEAD
=======


>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
}
