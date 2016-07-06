package com.lin.mytaskhomework.Utils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by my on 2016/6/25.
 */
public class HttpUtils {
    public static byte[] request(String urlPath) {
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[1024 * 4];
                int len = 0;
                while ((len = is.read(b)) != -1) {
                    baos.write(b, 0, len);
                }
                is.close();
                Log.i("aaa","HttpUtils执行了");
                return baos.toByteArray();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
