package co.ug.skywayhotel.intents;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends Activity {
    ImageView imageView;
    private static final int REQUEST_CODE_GALLERY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK){

            try {
                Uri imageUri = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);

               imageView.setBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void link(View view) {
    }

    public void mapLink(View view) {
    }

    public void mapGeo(View view) {
    }

    public void dial(View view) {
    }

    public void gallery(View view) {
        Intent intent = new Intent();
        intent.setAction(intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, REQUEST_CODE_GALLERY);
    }

    public void sendText(View view) {
    }

    public void sendImage(View view) {
    }

    public void sendEmail(View view) {
    }
}