package com.davikingcode.nativeExtensions.saveRingtone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class CopyRingtoneToFunction implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] passedArgs) {

		try {

			String sourceURL = passedArgs[0].getAsString();
			String destinationFileName = passedArgs[1].getAsString();

			copy(sourceURL, destinationFileName);

		} catch (Exception e) {

		}

		return null;
	}

	public void copy(String src, String destinationFileName) throws IOException {

		InputStream in = null;
		OutputStream out = null;

		try {
			
			File sdCard = Environment.getExternalStorageDirectory();
			
			File dir = new File (sdCard.getAbsolutePath() + "/Ringtones/");
			
			if (!dir.exists())
				dir.mkdirs();
			
			File outFile = new File(dir, destinationFileName);

			in = new FileInputStream(src);
			out = new FileOutputStream(outFile);

			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			in = null;
			out.flush();
			out.close();
			out = null;
			
			SaveRingtoneExtension.context.makeRingtone(outFile, destinationFileName);

		} catch (FileNotFoundException fnfe1) {
			
			Log.e("ANE", fnfe1.getMessage());
			
		} catch (Exception e) {
			
			Log.e("ANE", e.getMessage());
		}
	}
}
