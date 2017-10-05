package com.example.dpl.photoviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.io.InputStream;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/*
加载网络图片和本地图片
PhotoView进行缩放处理
 */
public class MainActivity extends AppCompatActivity {
    private PhotoView iv_photo,iv_photo1;
    private PhotoViewAttacher attacher;
    private ImageLoader loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_photo= (PhotoView) findViewById(R.id.iv_photo);
        iv_photo1= (PhotoView) findViewById(R.id.iv_photo1);
        attacher=new PhotoViewAttacher(iv_photo);//PhotoViewAttacher测量了图片宽高,进行缩放
        //加载本地图片，缩放处理
        try {
            InputStream is=getAssets().open("xin.png");
            Bitmap bm= BitmapFactory.decodeStream(is);
            //BitmapFactory.decodeStream(）从资源files, streams, and byte-arrays中解码生成Bitmap对象。
            iv_photo.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //加载网络图片
        loader=ImageLoader.getInstance();
        loader.init(ImageLoaderConfiguration.createDefault(MainActivity.this));//loader初始化
        loader.displayImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=167154" +
                "952,3594779114&fm=200&gp=0.jpg",iv_photo1);//展示图片
        iv_photo1.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {//图片监听
            @Override
            public void onPhotoTap(View view, float x, float y) {

            }
        });
    }
}
