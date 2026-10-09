package com.prank.thailandgabilet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

import java.io.InputStream;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 24, 24, 24);
        layout.setBackgroundColor(Color.BLACK);

        TextView title = new TextView(this);
        title.setText("THAILANDGABILET 😂");
        title.setTextColor(Color.WHITE);
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 24);
        layout.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageView imageView = new ImageView(this);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        try (InputStream input = getAssets().open("gorilla.jpg")) {
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            TextView error = new TextView(this);
            error.setText("Rasm topilmadi. gorilla.jpg faylini assets ichiga qo‘ying.");
            error.setTextColor(Color.WHITE);
            layout.addView(error);
        }

        layout.addView(imageView, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));

        TextView footer = new TextView(this);
        footer.setText("Bu shunchaki prank 😄");
        footer.setTextColor(Color.LTGRAY);
        footer.setTextSize(16);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 20, 0, 0);
        layout.addView(footer, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        setContentView(layout);
    }
}
