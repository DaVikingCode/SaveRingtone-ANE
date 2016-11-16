package com.davikingcode.nativeExtensions.saveRingtone;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class SaveRingtoneExtension implements FREExtension
{

	public static SaveRingtoneExtensionContext context;

	@Override
	public FREContext createContext( String label )
	{	
		return context = new SaveRingtoneExtensionContext();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void initialize()
	{
	}
}
