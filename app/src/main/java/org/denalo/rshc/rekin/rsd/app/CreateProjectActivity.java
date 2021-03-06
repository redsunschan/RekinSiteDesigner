/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import org.denalo.rshc.rekin.rsd.app.frame.*;

public class CreateProjectActivity extends Activity
	{

		private String projectName;
		private boolean createIndex;
		private boolean createFileTemplate;

		EditText project_name;
		CheckBox create_index;
		CheckBox create_file_template;
		Button confirm;
		File project_dir;

		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
				// TODO: Implement this method
				setContentView ( R.layout.activity_create_project );
				super.onCreate ( savedInstanceState );

				project_name = ( EditText )findViewById ( R.id.project_name );
				create_index = ( CheckBox ) findViewById ( R.id.create_index_file );
				create_file_template = ( CheckBox ) findViewById ( R.id.create_folder_template );
				confirm = ( Button ) findViewById ( R.id.confirm_create );

				confirm.setOnClickListener ( new Button.OnClickListener ( ) {

							@Override
							public void onClick ( View view )
								{
                                    if ( project_name.getText ( ) != null )
										{
											projectName = project_name.getText ( ).toString ( ) + File.separator;
											createIndex = create_index.isChecked ( );
											createFileTemplate = create_file_template.isChecked ( );
											RekinFile.createDir ( Rekin.rootPath + projectName );
											new Toast ( getApplicationContext ( ) ).makeText ( getApplicationContext ( ), "Created Project Dir : " + projectName, Toast.LENGTH_SHORT ).show ( );
											if ( createIndex )
												{
													RekinFile.createFile ( Rekin.rootPath + projectName , "index" , "php" );
													RekinFile.write ( Rekin.rootPath + projectName+"index.php" , "<?php\n\r/**\n\r * Auto-Generated By Rekin Site Designer\n\r */\n\r\n\r" );
												}
											if ( createFileTemplate )
												{
													RekinFile.createDir ( Rekin.rootPath + projectName + "library" + File.separator );
													RekinFile.createDir ( Rekin.rootPath + projectName + "resource" + File.separator );
													RekinFile.createDir ( Rekin.rootPath + projectName + "module" + File.separator );
												}
										}
									else
										{
											finish ( );
										}
                                }


						} );
			}

	}
