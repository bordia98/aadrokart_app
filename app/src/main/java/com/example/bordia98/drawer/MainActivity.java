package com.example.bordia98.drawer;

<<<<<<< HEAD

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
=======
import android.app.DatePickerDialog;
import android.app.Dialog;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
<<<<<<< HEAD
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
=======
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
=======
import android.widget.Button;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
<<<<<<< HEAD
=======

>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
<<<<<<< HEAD
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.w3c.dom.Text;

=======
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
=======
import java.util.Calendar;

import static android.os.Environment.*;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,edit.editclickListener,resize.resizeclickListener,compress.compressclickListener, GoogleApiClient.OnConnectionFailedListener,signout.signoutclicklistner {

        private static final int Result_load_image=1;
<<<<<<< HEAD
    private static final int PIC_CROP =233 ;
    private static final int RC_SIGN_IN = 2000;
    String epickuri,rpickuri;
    GoogleApiClient mGoogleApiClient;



    TextView username;
    TextView emailid;



=======
        String epickuri,rpickuri;
    private static final int RC_SIGN_IN = 100;
    GoogleApiClient mGoogleApiClient;
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a


    @Override
    public void oncpick() {
        Intent gallery_compress = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery_compress,5);
    }





    @Override
    public void onrpick() {
        Intent gallery_resize = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery_resize,3);

    }








    @Override // method for edit pick to open
    public void onepick() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,1);

    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null) {// code to gallery to get the image
            {
<<<<<<< HEAD

               Uri selectedimage = data.getData();
                performCrop(selectedimage);
            }
        }

     else if(requestCode==PIC_CROP&&resultCode==RESULT_OK&&data!=null){
            Bundle b = data.getExtras();
            Bitmap k = b.getParcelable("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();     // converting bitmap to byte array
            k.compress(Bitmap.CompressFormat.PNG, 100, stream);  // compressing in order to transfer

            byte[] byteArrayedit = stream.toByteArray();
             Intent i = new Intent(this,edit_preview.class);
            i.putExtra("cropped_image",byteArrayedit);
            startActivity(i);
        }

        else if(requestCode==3 && resultCode==RESULT_OK && data!=null) {// code to gallery to get the image for resize
=======


                Uri selectedimage = data.getData();
                epickuri = selectedimage.toString();

                Intent i = new Intent(this, edit_preview.class);
                i.putExtra("epickuri", epickuri);
                startActivity(i);

            }
        }
         if(requestCode==0&&resultCode==RESULT_OK&&data!=null) { // code for camera to get the image
             Bitmap camerabitmap = (Bitmap) data.getExtras().get("data");
             //File outFile = new File(Environment.getExternalStorageDirectory(), "edit.jpeg");
             //FileOutputStream fos = null;
             Uri tempUri = getImageUri(getApplicationContext(), camerabitmap);



             Intent j = new Intent(MainActivity.this,edit_preview.class);
             j.putExtra("euri",tempUri.toString());
             startActivity(j);

            /* try {
                 fos = new FileOutputStream(outFile);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
             camerabitmap.compress(Bitmap.CompressFormat.JPEG, 100,fos);
             try {
                 fos.flush();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             try {
                 fos.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }*/
         }
        if(requestCode==3 && resultCode==RESULT_OK && data!=null) {// code to gallery to get the image for resize
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
            {
                Uri selectedimage = data.getData();
             //   rpickuri = selectedimage.toString();
                String x  = getpath(selectedimage);
                Bitmap b =decodeSampledBitmapFromFile(x,300,300);



                ByteArrayOutputStream stream = new ByteArrayOutputStream();     // converting bitmap to byte array
                b.compress(Bitmap.CompressFormat.PNG, 100, stream);  // compressing in order to transfer

                byte[] byteArrayedit = stream.toByteArray();

                Intent i = new Intent(this, resize_preview.class);
                i.putExtra("gallery_image", byteArrayedit);
                startActivity(i);
            }
        }
     else if(requestCode==2&&resultCode==RESULT_OK&&data!=null) { // code for camera to get the image for resize

<<<<<<< HEAD
           Bundle extras = data.getExtras();

            Intent intent = new Intent(MainActivity.this,resize_preview.class);

            intent.putExtras(extras);

            startActivity(intent);

       }
        else if(requestCode==5 && resultCode==RESULT_OK && data!=null) {// code to gallery to get the image for compress
=======
            Intent j = new Intent(MainActivity.this,resize_preview.class);
            startActivity(j);

           try {
                fos = new FileOutputStream(outFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            camerabitmap.compress(Bitmap.CompressFormat.JPEG, 100,fos);
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(requestCode==5 && resultCode==RESULT_OK && data!=null) {// code to gallery to get the image for compress
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
            {
                Uri selectedimage = data.getData();
                String   cpickuri = selectedimage.toString();
                String x = compressiImage(cpickuri);

                Intent i = new Intent(this, compress_preview.class);
                i.putExtra("path", x);
                startActivity(i);
            }
        }
       else  if (requestCode == RC_SIGN_IN&&resultCode==RESULT_OK) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private String compressiImage(String cpickuri) {

        String filePath = getRealPathFromURI(cpickuri);
        Bitmap scaledBitmap = null;

        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculate_InSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);

//          write the compressed bitmap at the destination specified by filename.
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return filename;

    }


    public String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "MyFolder/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
<<<<<<< HEAD
        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;
=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a

    }


<<<<<<< HEAD

    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }



    private String getpath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index =             cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(column_index);
        cursor.close();
        return s;
    }


    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.

            GoogleSignInAccount acct = result.getSignInAccount();


            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();

            username = (TextView)findViewById(R.id.username);
            emailid  = (TextView)findViewById(R.id.emailid);


            username.setText(personName);
            emailid.setText(personEmail);

           findViewById(R.id.sign_in_button).setVisibility(View.GONE);

        } else {
            // Signed out, show unauthenticated UI.
            ;
            Toast.makeText(MainActivity.this,"bad network connection",Toast.LENGTH_LONG).show();
        }



    }



    public void performCrop(Uri uri){

     try {
         Intent cropIntent = new Intent("com.android.camera.action.CROP");
         //indicate image type and Uri
         cropIntent.setDataAndType(uri, "image/*");
         //set crop properties
         cropIntent.putExtra("crop", "true");
         //indicate aspect of desired crop
         cropIntent.putExtra("aspectX", 1);
         cropIntent.putExtra("aspectY", 1);
         //indicate output X and Y
         cropIntent.putExtra("outputX", 256);
         cropIntent.putExtra("outputY", 256);
         //retrieve data on return
         cropIntent.putExtra("return-data", true);
         //start the activity - we handle returning in onActivityResult
         startActivityForResult(cropIntent, PIC_CROP);
     }
     catch(ActivityNotFoundException anfe){

         //display an error message
         String errorMessage = "Whoops - your device doesn't support the crop action!";
         Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_LONG);
         toast.show();
     }
 }



=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    private Calendar calendar;
    private TextView dateView;
    private int date = 0, month = 0, year = 0;


<<<<<<< HEAD
    //----------------------------------------



=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD

       SignInButton signin = (SignInButton) findViewById(R.id.sign_in_button);



        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


       mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();



        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);

        if(opr.isDone())
        {
            signIn();
        }


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
               /*Calendar*/
        dateView = (TextView) findViewById(R.id.text1);
        calendar = Calendar.getInstance();

         year = calendar.get(Calendar.YEAR);
         month = calendar.get(Calendar.MONTH);
         date = calendar.get(Calendar.DAY_OF_MONTH);

        showDate(year, month + 1, date);

    }

<<<<<<< HEAD




    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


=======
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

<<<<<<< HEAD




=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, date, month, year);
        }
        return null;
    }

<<<<<<< HEAD




=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2 + 1, arg3);
        }
    };


<<<<<<< HEAD



=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
    private void showDate(int year, int month, int date) {
        dateView.setText(new StringBuilder().append(date).append("/").append(month).append("/").append(year));
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }






    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_resize:
                fragment = new resize();
                break;
            case R.id.nav_compress:
                fragment = new compress();
                break;
            case R.id.nav_edit:
                fragment = new edit();
                break;
            case R.id.nav_autocompress:
                fragment=new autocompress();
                break;
            case R.id.nav_signout:
                fragment = new signout();
                break;
        }



        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelectedScreen(id);


        return true;
    }


<<<<<<< HEAD

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,"not able to connect to internet . Please check your connection",Toast.LENGTH_LONG).show();
    }

    @Override
    public void yesclick() {

        signOut();
        revokeaccess();

        Intent i  = new Intent(this,MainActivity.class);
        startActivity(i);


    }

    private void revokeaccess() {

        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...  updateUI(false);

                        findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);

                    }
                });

    }

    @Override
    public void noclick() {

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

    public int calculate_InSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromFile(String filePath,int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }




=======
>>>>>>> b6cc6c87889afc452231617aded1e34f547fbc5a
}

