package com.god.dream.controller.runlog;

import com.god.dream.common.exception.StatusCode;
import com.god.dream.common.response.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Hack on 16/4/30.
 */
@Controller
@RequestMapping("/runLog")
public class RunLogController {
    private static final Logger RUN_LOG = Logger.getLogger(RunLogController.class);
    private static final String LOG_DIR = "dream";
    private static final String LOG_FILE_PREFIX = "dream.log";

    @ResponseBody
    @RequestMapping("/download")
    public void download(@RequestParam(defaultValue = "0") String days, HttpServletRequest request, HttpServletResponse response) {
        synchronized (this) {
            try {
                String catalinaHome = System.getProperty("catalina.home");
                if (StringUtils.isEmpty(catalinaHome)) {
                    throw new RuntimeException("Parameter [catalina.home] Not Found!");
                }

                File logDir = new File(catalinaHome.concat("/logs/").concat(LOG_DIR));
                if (!logDir.exists()) {
                    throw new RuntimeException(String.format("Log Directory [%s] Not Found!", logDir.getAbsolutePath()));
                }

                File targetZipFile = new File(logDir.getAbsolutePath().concat("/").concat(LOG_DIR).concat(".zip"));
                if (targetZipFile.exists()) {
                    targetZipFile.deleteOnExit();
                }
                targetZipFile.createNewFile();

                // 压缩目标文件
                compress(logDir, targetZipFile, Integer.valueOf(days));

                response.setCharacterEncoding("utf-8");
                response.setContentType("multipart/form-data");
                response.setHeader("Content-Disposition", "attachment;fileName=" + LOG_DIR.concat(".zip"));

                // 将压缩好的zip文件写入响应
                InputStream in = new FileInputStream(targetZipFile);
                OutputStream out = response.getOutputStream();
                int count = -1;
                byte[] bytes = new byte[8192];
                while ((count = in.read(bytes)) != -1) {
                    out.write(bytes, 0, count);
                }
                out.close();
                in.close();

                // 下载完成，删除目标文件
                targetZipFile.deleteOnExit();
            } catch (Exception e) {
                RUN_LOG.error(e.getMessage(), e);
            }
        }
    }

    // 将指定目录中的文件压缩成zip文件
    private void compress(File srcDir, File targetZipFile, int days) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(targetZipFile);
        CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
        ZipOutputStream out = new ZipOutputStream(cos);

        doCompress(new File(srcDir.getAbsolutePath().concat("/").concat(LOG_FILE_PREFIX)), out);
        for (int i = 1; i <= days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - i);

            String targetDateStr = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            String srcFileName = srcDir.getAbsolutePath().concat("/").concat(LOG_FILE_PREFIX).concat(".").concat(targetDateStr);
            if (new File(srcFileName).exists()) {
                doCompress(new File(srcFileName), out);
            }
        }
        out.close();

    }

    // 将一个目标文件加入到zip中
    private void doCompress(File file, ZipOutputStream out) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ZipEntry entry = new ZipEntry(file.getName());
        out.putNextEntry(entry);

        int count;
        byte data[] = new byte[8192];
        while ((count = bis.read(data, 0, 8192)) != -1) {
            out.write(data, 0, count);
        }
        out.flush();
    }

}
