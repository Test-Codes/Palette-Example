package com.thefinestaritst.palette.example;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

  private static String TAG = "Palette Example";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    long bitmap_create_time = System.currentTimeMillis();
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yosemite_small);
    bitmap_create_time = System.currentTimeMillis() - bitmap_create_time;
    Log.d(TAG, "Bitmap create time: " + bitmap_create_time + " millisecond");

    long palette_generation_time = System.currentTimeMillis();
    Palette palette = Palette.from(bitmap).resizeBitmapArea(-1).generate();
    palette_generation_time = System.currentTimeMillis() - palette_generation_time;
    Log.d(TAG, "Palette generation time: " + palette_generation_time + " millisecond");

    Palette.Swatch dominant = palette.getDominantSwatch();
    Log.d(TAG, "Dominant color: #" + Integer.toHexString(dominant.getRgb()));
  }
}
