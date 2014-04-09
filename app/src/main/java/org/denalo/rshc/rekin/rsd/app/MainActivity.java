/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
	{

		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
				super.onCreate ( savedInstanceState );
				setContentView ( R.layout.activity_main );
			}


		@Override
		public boolean onCreateOptionsMenu ( Menu menu )
			{

				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater ( ).inflate ( R.menu.main, menu );
				return true;
			}

		@Override
		public boolean onOptionsItemSelected ( MenuItem item )
			{
				// Handle action bar item clicks here. The action bar will
				// automatically handle clicks on the Home/Up button, so long
				// as you specify a parent activity in AndroidManifest.xml.
				int id = item.getItemId ( );
				if ( id == R.id.action_settings )
					{
						new Toast ( getApplicationContext ( ) ).makeText ( this , "Jump To Setting" , Toast.LENGTH_SHORT ).show ( );
						Intent setting = new Intent ( this , ConfigActivity.class );
						startActivity ( setting );
					}
				return super.onOptionsItemSelected ( item );
			}

	}
