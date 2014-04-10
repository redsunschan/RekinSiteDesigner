package org.denalo.rshc.rekin.rsd.app;
import android.os.*;
import java.io.*;

public class Rekin
{
	public final static String sdcardPath = Environment.getExternalStorageDirectory ( ).getPath ( );
	public final static String rootPath = Environment.getExternalStorageDirectory ( ).getPath ( )+File.separator+"RSD"+File.separator;
}
