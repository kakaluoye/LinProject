package com.lin.mytaskhomework.Utils;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by my on 2016/6/25.
 */
public class SDCardHelper {
    //先判断SD卡是否可用，就是是否是挂载的状态。
    public static boolean isSDCardMounted() {
        //对于SD卡  ，首先要想到的是用 环境 Environment。
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    //获取SD卡的目录  得到字符串类型地址。
    public static String getSDCardPath() {
        //SD卡里  环境得到外部卡的路径是file，file得到绝对路径才是字符串。
        if (isSDCardMounted()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    //获取SD卡的大小   字节个数  long类型
    public static long getSDCardSize() {
        //statFs对象可以获取文件系统的信息。
        String sdpath = getSDCardPath();
        if (sdpath != null) {
            StatFs statFs = new StatFs(sdpath);
            int count = statFs.getBlockCount();
            int size = statFs.getBlockSize();
            return (long) count * size;
        }
        return 0;
    }

    //获取剩余空间的大小。
    public static long getSDCardFreeSize() {
        //同上
        String sdpath = getSDCardPath();
        if (sdpath != null) {
            StatFs statFs = new StatFs(sdpath);

            int count = statFs.getFreeBlocks();
            int size = statFs.getBlockSize();
            return (long) count * size;
        }
        return 0;
    }

    //获取可用空间的大小。
    public static long getSDCardAvailableSeze() {
        String sdpath = getSDCardPath();
        if (sdpath != null) {
            StatFs statFs = new StatFs(sdpath);
            int count = statFs.getAvailableBlocks();
            int size = statFs.getBlockSize();
            return (long) count * size;
        }

        return 0;
    }

    /**
     * 保存内容到SD卡、
     */
    public static boolean saveFileToSDCard(byte[] data, String dir, String filename) {
        if (data.length < getSDCardFreeSize()) {
            //file只是个路径，不是字符串。新建对象放路径的字符串。
            File dirFile = new File(getSDCardPath() + File.separator + dir+File.separator+filename);
            //判断一个路径是否存在，file.exists()。
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            try {
                FileOutputStream fops = new FileOutputStream(dirFile);
                fops.write(data);
                fops.close();
                Log.i("aaa","saveFileToSDCard执行了");
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {//可以直接抛一个自定义的异常信息，出现这类问题会很明显的找到。
            throw new RuntimeException("SD卡内存不足！");
        }
        Log.i("aaa","SD卡内存不足");
        return false;
    }

    /**
     * 读取SD卡的内容、
     */
    public static byte[] readFileFromSDCard(String filepath) {
        //读取是读取的文件里面的内容，用文件流，即FileInputStream。读文件
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            FileInputStream is = new FileInputStream(new File(getSDCardPath() + File.separator + filepath));
            byte[] b = new byte[1024 * 4];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
