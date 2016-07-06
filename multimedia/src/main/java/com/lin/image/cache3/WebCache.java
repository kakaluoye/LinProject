package com.lin.image.cache3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.security.auth.callback.Callback;

/**
 * Created by my on 2016/6/27.
 */
public class WebCache {

    public void getWebCache(final String urlpath, final CallBack callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] b = getWebFile(urlpath);
                    callback.getResult(b);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public byte[] getWebFile(String urlPath) throws MalformedURLException {
        URL url = new URL(urlPath);
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream is = connection.getInputStream();
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = is.read(b)) != -1) {
                    baos.write(b, 0, len);
                }
                if (is != null) {
                    is.close();
                }
                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public interface CallBack {
        public void getResult(byte[] data);
    }

}
