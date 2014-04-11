/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import org.denalo.rshc.rekin.rsd.app.frame.alert.ExitAlert;

public class MainActivity extends Activity
	{

		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
				super.onCreate ( savedInstanceState );
				setContentView ( R.layout.activity_main );
				Button new_project = ( Button ) findViewById ( R.id.new_project );
				Button open_project = ( Button ) findViewById ( R.id.open_project );
				Button quit = ( Button ) findViewById ( R.id.quit );
				new_project.setOnClickListener ( new Button.OnClickListener ( ) {
					@Override
					public void onClick ( View view )
						{
							startActivity ( new Intent ( MainActivity.this , CreateProjectActivity.class ) );
						}
				} );
				open_project.setOnClickListener ( new Button.OnClickListener ( ) {
							@Override
							public void onClick ( View view )
								{
									startActivity ( new Intent ( MainActivity.this , FileListActivity.class ) );
								}
						} );
				quit.setOnClickListener ( new Button.OnClickListener ( ) {
							@Override
							public void onClick ( View view )
								{
                                    new ExitAlert(MainActivity.this).create();
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
						startActivity ( new Intent ( this , ConfigActivity.class ) );
					}
				if ( id == R.id.action_aboutus )
					{
						startActivity ( new Intent ( this , AboutUsActivity.class ) );
					}
				return super.onOptionsItemSelected ( item );
			}

        @Override
        public void onBackPressed() {
            new ExitAlert(this).create();
        }


    }
