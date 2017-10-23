package generenext.example.com.app_backup;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by nihar on 23-10-2017.
 */

public  class doInBAckground  extends AsyncTask<Void,Void,Void> {

    File folder,source;
    String FileName;
    Context context;
    File FileMain;

    public doInBAckground(Context context, File folder, String fileName, File source) {
        this.context=context;
        this.folder=folder;
        this.FileName=fileName;
        this.source=source;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... params) {
        FileMain = new File(folder, FileName);
        try {
            FileUtils.copyFile(source, folder);

        } catch (IOException e) {
            Log.v("Nihar@@",e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (FileMain.exists()){
            Toast.makeText(context, "Done sucessful", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Done Unsucessful", Toast.LENGTH_SHORT).show();
        }
    }
}
