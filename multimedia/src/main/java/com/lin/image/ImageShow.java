package com.lin.image;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lin.image.cache3.ImageCompression;
import com.lin.multimedia.R;

/**
 * Created by my on 2016/6/27.
 */
public class ImageShow extends AppCompatActivity {

    Button btn;
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        btn = (Button) findViewById(R.id.imageshow_avtivity_btn);
        iv = (ImageView) findViewById(R.id.iamgeshow_activity_iv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            byte[] b = DownLoadImage.downloadFile("http://img2.imgtn.bdimg.com/it/u=84478850,4038519792&fm=21&gp=0.jpg");
                            Bitmap bitmap = ImageCompression.getCompressionImage(b,100,100);
                            Message message = Message.obtain();
                            message.obj =bitmap;
                            handler.sendMessage(message);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap = (Bitmap) msg.obj;
            iv.setImageBitmap(bitmap);
        }
    };


}
