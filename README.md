SaveRingtone-ANE
=================

An ANE to save a sound file as an Android Ringtone.

```actionscript3
var saveRingtone:SaveRingtone = new SaveRingtone();

var source:File = File.applicationDirectory.resolvePath("sounds/sonnerie.mp3");

saveRingtone.copyRingtoneTo(source, "MyRingtoneName.mp3");
```

Be sure to add this permission:
`<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />`