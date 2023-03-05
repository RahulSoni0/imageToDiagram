package com.example.imagetodiagram;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;

public class MainActivity extends AppCompatActivity {


    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.ivMain);

        MultiTransformation<Bitmap> multi = new MultiTransformation<>(
                new SketchFilterTransformation(),
                new GrayscaleTransformation()


        );

        Glide.with(this).load(R.drawable.image2).apply(RequestOptions.bitmapTransform(multi)).into(image);


    }
}