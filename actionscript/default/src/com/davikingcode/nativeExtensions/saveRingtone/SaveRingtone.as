package com.davikingcode.nativeExtensions.saveRingtone {

	import flash.events.EventDispatcher;
	import flash.filesystem.File;

	public class SaveRingtone extends EventDispatcher {

		private static var _instance:SaveRingtone;

		public static function getInstance():SaveRingtone {
			return _instance;
		}

		public function SaveRingtone() {

			_instance = this;
		}

		public function copyRingtoneTo(source:File, destinationFileName:String):void {
		}
	}
}