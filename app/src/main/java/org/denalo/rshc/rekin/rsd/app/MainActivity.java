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
				Button quit = ( Button ) findViewById ( R.id.quit );
				quit.setOnClickListener ( new Button.OnClickListener ( ) {
							@Override
							public void onClick ( View view )
								{
									System.exit ( 0 ) ;
								}
						} );
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
						Intent setting = new Intent ( this , ConfigActivity.class );
						startActivity ( setting );
					}
				if ( id == R.id.action_aboutus )
					{
						startActivity ( new Intent ( this , AboutUs.class ) );
					}
				return super.onOptionsItemSelected ( item );
			}

		public void showDialog ( )
			{

			}
	}
