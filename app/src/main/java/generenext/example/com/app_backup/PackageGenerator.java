package generenext.example.com.app_backup;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nihar on 23-10-2017.
 */

public class PackageGenerator {
    File ApkSourcePath;
    String AppName,mFolderName;
    ArrayList dataModels = new ArrayList();

    public void CreateFolder(Context context,String name){
        mFolderName=name;
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + name);

    }
    public void ImportToFolder(Context context){
        if (AppName != null) {
            try {
                CopyDtoD(ApkSourcePath,AppName,context);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

        }
    }

    public static void CopyDtoD(File sourceLocation, String appname, Context context) throws IOException {
        File folder = new File("/storage/emulated/0/mFolderName/"+appname+".apk");
        String FileName = appname+".apk" ;
        File Source = sourceLocation;
        doInBAckground doInBAckground = new doInBAckground(context,folder,FileName,Source);
        doInBAckground.execute();

    }


    public void installedApps( Context context ) {
        List<PackageInfo> packList = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packList.size(); i++) {
            final PackageManager pm = context.getPackageManager();
            ApplicationInfo applicationInfo = null;
            PackageInfo packInfo = packList.get(i);
            if ((packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                String appName = packInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                Drawable appicon = packInfo.applicationInfo.loadIcon(pm);
                try {
                    applicationInfo = pm.getApplicationInfo(packList.get(i).packageName.toString(), 0);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                File file = new File(applicationInfo.publicSourceDir);
                long size = file.length();
                String apkSize = Utils.formatFileSize(size);

                dataModels.add(new DataModel(appName, appicon, apkSize, false, file));
                Log.e("Nihar_installedApk " + Integer.toString(i), appName + "  " + size / (1024 * 1024) + "MB");
            }
        }
    }
}
