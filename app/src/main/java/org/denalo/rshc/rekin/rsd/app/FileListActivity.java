/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;
import android.app.*;
import android.content.Intent;
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
                getFile(new File("/sdcard/").listFiles());
            }

		@Override
		public boolean onCreateOptionsMenu ( Menu menu )
			{
				getMenuInflater ( ).inflate ( R.menu.file_list , menu );
				return super.onCreateOptionsMenu ( menu );
			}

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {

            }
            return super.onOptionsItemSelected(item);
        }

        protected void onListItemClick(ListView listView, View view, int position, long id) {
            super.onListItemClick(listView, view, position, id);
            Intent it = new Intent(Intent.ACTION_VIEW);
            String selectedFile = this.items.get(position);
            new Toast(getApplicationContext()).makeText(getApplicationContext(), selectedFile, Toast.LENGTH_LONG);
            if (selectedFile == "../") {
                getFile(new File(this.getTitle().toString()).getParentFile().listFiles());
            } else {
                File file = new File(this.getTitle() + selectedFile);
                if (file.isDirectory()) {
                    getFile(file.listFiles());
                }
                if (file.isFile()) {
                    it.putExtra("path", file.getPath());
                    setResult(RESULT_OK, getIntent());
                    finish();
                }
            }
        }

        private void getFile ( File[] files ) {
            items.clear ( );

            for ( File file : files ) {
                if (file.getParent() != "/") {
                    if (!items.contains("../")) {
                        items.add("../");
                    }
                }
                if ( file.getParentFile ( ) != null && file.getParentFile ( ).getParent ( ) != null ) {
                    parentPath = file.getParentFile().getParent();
                }

                if ( file.isDirectory ( ) ) {
                    if (file.getParent().length() > 1) {
                        items.add(file.getPath().substring(file.getParent().length()));
                    } else {
                        items.add(file.getPath());
                    }
                } else {
					items.add ( file.getName ( ) );
                }
				setTitle ( file.getParent ( ) );
            }

            adapter = new ArrayAdapter<String>( this , android.R.layout.simple_list_item_1 , items );
            this.setListAdapter ( adapter );
        }

}
