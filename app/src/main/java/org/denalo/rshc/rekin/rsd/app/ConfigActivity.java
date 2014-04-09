package org.denalo.rshc.rekin.rsd.app;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

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
	}
	@Override
	protected void onListItemClick ( ListView l, View v, int position, long id )
		{
			super.onListItemClick ( l, v, position, id );
		}
	
}
