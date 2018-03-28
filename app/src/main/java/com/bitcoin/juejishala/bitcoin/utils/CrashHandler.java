package com.bitcoin.juejishala.bitcoin.utils;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.bitcoin.juejishala.bitcoin.BuildConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrashHandler implements UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    /**
     * 程序的Context对象
     */
    private Context mContext;
    private static CrashHandler INSTANCE = new CrashHandler();

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        // 设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        boolean result = handleException(ex);
        if (!result) {
            // 如果自定义的没有处理则让系统默认的异常处理器来处理
            UncaughtExceptionHandler exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (exceptionHandler != null) {
                exceptionHandler.uncaughtException(thread, ex);
            }
        }
        // 退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param ex 异常信息
     * @return true 如果处理了该异常信息;否则返回false.
     */
    public boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        saveCrashInfo2File(ex);
        if (!BuildConfig.DEBUG) {
        }
        ex.printStackTrace();
        return true;
    }

    private void saveCrashInfo2File(Throwable ex) {
        String logName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        File logFile = new File(ConstantModule.homeFolder + File.separator + "log", logName);

        StringWriter sw = new StringWriter();
        sw.append(timeStr).append('\n');
        try {
            PackageInfo pi = null;
            if (mContext != null) {
                pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            }
            if (pi != null) {
                sw.append((BuildConfig.DEBUG ? "d_" : "r_") + "vn" + pi.versionName + "_vc" + pi.versionCode + "\n");
            }
            sw.append(android.os.Build.BRAND + " " + android.os.Build.MODEL + " Android " + android.os.Build.VERSION.RELEASE);
            sw.append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ex.printStackTrace(new PrintWriter(sw));
        sw.append('\n');
        writeFile(logFile, sw.toString());
    }

    public static void writeFile(File file, String msg) {
        FileWriter fw = null;
        try {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            fw.append(msg);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveRecordInfo2File(Throwable ex) {
        String logName = "record_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        File logFile = new File(ConstantModule.homeFolder + File.separator + "log/temp", logName);
        clearOldFile(logFile.getParentFile());
        StringWriter sw = new StringWriter();
        sw.append(timeStr).append('\n');
        try {
            if (mContext != null) {
                PackageInfo pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
                if (pi != null) {
                    String versionName = pi.versionName;
                    int versionCode = pi.versionCode;
                    sw.append((BuildConfig.DEBUG ? "d_" : "r_") + "vn" + versionName + "_vc" + versionCode + "\n");
                    sw.append(android.os.Build.BRAND + " " + android.os.Build.MODEL + " Android " + android.os.Build.VERSION.RELEASE);
                    sw.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ex.printStackTrace(new PrintWriter(sw));
        sw.append('\n');
        writeFile(logFile, sw.toString());
    }

    public void saveRecordInfo2File(String msg) {
        String logName = "record_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        File logFile = new File(ConstantModule.homeFolder + File.separator + "log/temp", logName);
        clearOldFile(logFile.getParentFile());

        StringWriter sw = new StringWriter();
        sw.append(timeStr).append('\n');
        try {
            if (mContext != null) {
                PackageInfo pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
                if (pi != null) {
                    String versionName = pi.versionName;
                    int versionCode = pi.versionCode;
                    sw.append((BuildConfig.DEBUG ? "d_" : "r_") + "vn" + versionName + "_vc" + versionCode + "\n");
                    sw.append(android.os.Build.BRAND + " " + android.os.Build.MODEL + " Android " + android.os.Build.VERSION.RELEASE);
                    sw.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sw.append(msg).append("\n");
        writeFile(logFile, sw.toString());
    }

    public void saveThreadLogInfo2File(String msg) {
        String logName = "thread_log_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log";
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        StringWriter sw = new StringWriter();
        sw.append(timeStr).append('\n');
        try {
            if (mContext != null) {
                PackageInfo pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
                if (pi != null) {
                    String versionName = pi.versionName;
                    int versionCode = pi.versionCode;
                    sw.append((BuildConfig.DEBUG ? "d_" : "r_") + "vn" + versionName + "_vc" + versionCode + "\n");
                    sw.append(android.os.Build.BRAND + " " + android.os.Build.MODEL + " Android " + android.os.Build.VERSION.RELEASE);
                    sw.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sw.append(msg).append("\n");
    }

    private static void clearOldFile(File fileDir) {
        int saveDays = 10;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -saveDays);
        if (fileDir.isDirectory()) {
            File[] subFiles = fileDir.listFiles();
            if (subFiles == null) {
                return;
            }
            for (File subFile : subFiles) {
                try {
                    long updateTime = subFile.lastModified();
                    Calendar fileTime = Calendar.getInstance();
                    fileTime.setTimeInMillis(updateTime);
                    if (fileTime.before(calendar)) {
                        if (subFile.exists()) {
                            File reFile = new File(System.currentTimeMillis() + ".log");
                            boolean result = subFile.renameTo(reFile);
                            if (result) {
                                reFile.delete();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
