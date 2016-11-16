package {

	import com.davikingcode.nativeExtensions.saveRingtone.SaveRingtone;

	import flash.display.Sprite;
	import flash.filesystem.File;

	[SWF(width='320', height='480', frameRate='30', backgroundColor='#000000')]

	public class SaveRingtoneTest extends Sprite {

		public function SaveRingtoneTest() {
			
			var saveRingtone:SaveRingtone = new SaveRingtone();
			
			var source:File = File.applicationDirectory.resolvePath("sounds/sonnerie.mp3");
			
			saveRingtone.copyRingtoneTo(source, "Memovox.mp3");
		}
	}
}