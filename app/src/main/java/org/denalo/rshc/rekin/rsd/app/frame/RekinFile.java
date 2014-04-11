package org.denalo.rshc.rekin.rsd.app.frame;

import java.io.*;

public class RekinFile
	{
		public static void createFile ( String path , String name , String suffix )
			{
				File file = new File ( path + File.separator + name + "." + suffix );
				if ( !file.exists ( ) )
					{
						try
							{
								file.createNewFile ( );
							}
						catch ( Exception exc )
							{
								exc.printStackTrace ( );
							}
					}
			}

		public static void createDir ( String path )
			{
				File file = new File ( path );
				if ( !file.exists ( ) )
					{
						file.mkdirs ( );
					}
			}

		public static void createTemp (  String filename , String name ) {
			File file = new File ( filename );
		}
			
		public static void write ( String filePath , String msg )
			{

				try
					{
						FileOutputStream fos = new FileOutputStream ( filePath );
						try
							{
								fos.write ( msg.getBytes ( ) );
								fos.close ( );
							}
						catch (IOException exc)
							{
								exc.printStackTrace ( );
							}
					}
				catch (FileNotFoundException exc)
					{
						exc.printStackTrace ( );
					}

			}
		
		public static void deletePath ( String path ) {
			File file = new File ( path );
			if ( file.exists ( ) ) {
				file.delete ( );
			}
		}
		
		public static void deleteFile ( String path , String name ) {
			File file = new File ( path+File.separator+name );
			if ( file.exists ( ) ) {
				file.delete ( );
			}
		}
		
		public static void rename ( String old_path , String new_path ) {
			File file = new File ( old_path );
			if ( file.exists ( ) ) {
				file.renameTo ( new File ( new_path ) );
				if ( file.getName ( ) != new_path ) {
					new IOException ( ).printStackTrace ( );
				}
			}
		}
		
	}
