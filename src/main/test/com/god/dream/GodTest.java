package com.god.dream;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Willer on 16/4/4.
 */
public class GodTest {

    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("/Users/Hack/Pictures/a7a90ce0aa79d532aec3eca73a1b3513.jpg");
        OutputStream out = new FileOutputStream(new File("/Users/lab/a.jpg"));

        int read = -1;
        byte[] bytes = new byte[1024];
        while ((read = in.read()) != -1) {
            out.write(bytes);
        }
        out.close();

        System.out.println("OK");
    }



}
