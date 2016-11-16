package com.davikingcode.nativeExtensions.saveRingtone {

	import flash.events.EventDispatcher;
	import flash.external.ExtensionContext;
	import flash.filesystem.File;

	public class SaveRingtone extends EventDispatcher {

		private static var _instance:SaveRingtone;

		public var extensionContext:ExtensionContext;

		public static function getInstance():SaveRingtone {
			return _instance;
		}

		public function SaveRingtone() {

			_instance = this;

			extensionContext = ExtensionContext.createExtensionContext("com.davikingcode.nativeExtensions.SaveRingtone", null);

			if (!extensionContext)
				throw new Error( "SaveRingtone native extension is not supported on this platform." );
		}

		public function copyRingtoneTo(source:File, destinationFileName:String):void {

			var sourceURL:String = getNativePath(source);

			extensionContext.call("copyRingtoneTo", sourceURL, destinationFileName);
		}

		// many thanks to https://github.com/DigitalStrawberry/ANE-Sounds
		private function getNativePath(file:File):String {

			// Files located in the Application directory need to be moved so they can be properly read by the ANE.
			// This is due to a bug in AIR that compresses embedded media assets in the Android package, even though
			// the Android documentation states that these assets should not be compressed.
			if(file.nativePath == "") {

				var tmpArray:Array = file.url.split('/');
				var filename:String = tmpArray.pop();

				var newFilename:String = filename.replace('/', '_');
				var newFile:File = File.applicationStorageDirectory.resolvePath(newFilename);

				file.copyTo(newFile, true);
				return newFile.nativePath;
			}

			return file.nativePath;
		}
	}
}