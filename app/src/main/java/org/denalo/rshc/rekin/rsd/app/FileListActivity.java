/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileListActivity extends ListActivity
	{

        private List<String> items = new ArrayList<String>();
        private String parentPath = "/";
        private ArrayAdapter<String> adapter;

		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
                super.onCreate ( savedInstanceState );
                setContentView ( R.layout.activity_file );
                getFile ( new File( "/sdcard/" ).listFiles ( ) );
			}

		@Override
		public boolean onCreateOptionsMenu ( Menu menu )
			{
				getMenuInflater ( ).inflate ( R.menu.file_list , menu );
				return super.onCreateOptionsMenu ( menu );
			}

        private void getFile ( File[] files ) {
            items.clear ( );
            items.add ( "../ ( Parent Path )" );//Add Parent Path Item

            for ( File file : files ) {
                if ( file.getParentFile ( ) != null && file.getParentFile ( ).getParent ( ) != null ) {
                    parentPath = file.getParentFile().getParent();
                }

                if ( file.isDirectory ( ) ) {
                    items.add ( file.getPath() );
                } else {
                    items.add ( file.getName ( ) );
                }
            }

            adapter = new ArrayAdapter<String>( this , android.R.layout.simple_list_item_1 , items );
            this.setListAdapter ( adapter );
        }

}
