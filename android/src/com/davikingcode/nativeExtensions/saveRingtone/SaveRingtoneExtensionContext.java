package com.davikingcode.nativeExtensions.saveRingtone;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class SaveRingtoneExtensionContext extends FREContext {

	@Override
	public void dispose() {
		SaveRingtoneExtension.context = null;

		getActivity().getContentResolver();

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
		functionMap.put("copyRingtoneTo", new CopyRingtoneToFunction());
		return functionMap;
	}

	public void makeRingtone(File soundFile, String fileName) {

		String path = soundFile.getAbsolutePath();

		// http://stackoverflow.com/questions/11396725/android-saving-sound-as-ringtone-title-not-being-used-in-ringtone-list

		// Plug in same important values
		ContentValues values = new ContentValues();
		values.put(MediaStore.MediaColumns.DATA, path);
		values.put(MediaStore.MediaColumns.TITLE,
				fileName.split(Pattern.quote("."))[0]);
		values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
		values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
		values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
		values.put(MediaStore.Audio.Media.IS_ALARM, true);
		values.put(MediaStore.Audio.Media.IS_MUSIC, false);

		// The ol' delete then insert trick:
		Uri uri = MediaStore.Audio.Media.getContentUriForPath(path);

		getActivity().getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + path + "\"", null);
		getActivity().getContentResolver().insert(uri, values);
	}
}
