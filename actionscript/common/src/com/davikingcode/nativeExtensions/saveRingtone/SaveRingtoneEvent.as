package com.davikingcode.nativeExtensions.saveRingtone {

	import flash.events.Event;

	public class SaveRingtoneEvent extends Event {

		static public const OK:String = "OK";

		public function SaveRingtoneEvent( type : String, bubbles : Boolean = false, cancelable : Boolean = false )
		{
			super( type, bubbles, cancelable );
		}
	}
}
