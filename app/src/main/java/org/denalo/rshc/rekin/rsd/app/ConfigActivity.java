/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class ConfigActivity extends ListActivity
{
	
	protected ListView list;
	protected String[] item;
	
	@Override
	public void onCreate ( Bundle b ) {
		super.onCreate ( b );
		setContentView ( R.layout.activity_setting );
		list = getListView ( );
		item = getResources ( ).getStringArray ( R.array.config_menu );
		list.setAdapter ( new ArrayAdapter<String> ( this , android.R.layout.simple_list_item_1 , item ) );
        list.setOnItemClickListener (
            new AdapterView.OnItemClickListener ( ) {
                @Override
                public void onItemClick ( AdapterView<?> parent, View view, int position, long id ) {
                    Toast.makeText ( getApplicationContext ( ), String.valueOf ( id ), Toast.LENGTH_LONG).show();
                	if ( id == 3 ) {
						startActivity ( new Intent ( ConfigActivity.this , Version.class ) );
					}
				}
            });
        }
	
}
