package generenext.example.com.app_backup;

import android.graphics.drawable.Drawable;

import java.io.File;

/**
 * Created by nihar on 31-07-2017.
 */

public class DataModel {

    public String name,apkSize;
    public boolean checked;
    File ApkPath;
    String getAppname ;

    public String getName() {
        return name;
    }

    public File getApkPath() {
        return ApkPath;
    }

    public void setApkPath(File apkPath) {
        ApkPath = apkPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApkSize() {
        return apkSize;
    }

    public void setApkSize(String apkSize) {
        this.apkSize = apkSize;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Drawable getmAppicon() {
        return mAppicon;
    }

    public void setmAppicon(Drawable mAppicon) {
        this.mAppicon = mAppicon;
    }

    public Drawable mAppicon;

    public DataModel(String name, Drawable app_icon, String apkSize, boolean checked, File ApkPath) {
        this.name = name;
        this.checked = checked;
        this.mAppicon=app_icon;
        this.apkSize=apkSize;
        this.ApkPath=ApkPath;
    }
}