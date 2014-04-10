package org.denalo.rshc.rekin.rsd.app;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;

public class FileListActivity extends Activity
	{
		
		public ListView view;
		public ArrayAdapter<String> adapter;
		public String[] list;
		
		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
				// TODO: Implement this method
				view = new ListView ( this );
				list = new File ( Rekin.rootPath ).list ( );
				adapter = new ArrayAdapter<String> ( getApplicationContext ( ) , android.R.layout.simple_list_item_1 , list );
				view.setAdapter ( adapter );
				setContentView ( view );
				super.onCreate ( savedInstanceState );
			}

		@Override
		public boolean onCreateOptionsMenu ( Menu menu )
			{
				getMenuInflater ( ).inflate ( R.menu.file_list , menu );
				return super.onCreateOptionsMenu ( menu );
			}
		
}
