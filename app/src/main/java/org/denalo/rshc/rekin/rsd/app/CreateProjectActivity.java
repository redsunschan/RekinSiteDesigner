/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.io.*;

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
                                    if (project_name.getText() != null) {
                                        projectName = project_name.getText ( ).toString ( )+File.separator;
									createIndex = create_index.isChecked ( );
									createFileTemplate = create_file_template.isChecked ( );
									project_dir = new File ( Rekin.rootPath+projectName );
									if ( !project_dir.exists ( ) ) {
										project_dir.mkdirs ( );
										new Toast ( getApplicationContext ( ) ).makeText ( getApplicationContext() , "Created Project Dir : "+projectName , Toast.LENGTH_SHORT ).show ( );
									}
									if ( createIndex ) {
										try {
											File index_file = new File ( Rekin.rootPath+projectName+"index.php" );
											if ( ! index_file.exists ( ) ) {
												index_file.createNewFile ( );
											}
                                            FileOutputStream fos = openFileOutput(Rekin.rootPath + projectName + "index.php", MODE_PRIVATE);
                                            BufferedOutputStream bos = new BufferedOutputStream(fos);
                                            bos.write("<?php\n\r/**\n\r * Auto-Generate Index File\n\r */\n\r\n\r".getBytes());
                                            bos.close();
                                        } catch (Exception exc) {
                                        }
                                    }
									if ( createFileTemplate ) {
										File lib_dir = new File ( Rekin.rootPath+projectName+"library"+File.separator );
										File res_dir = new File ( Rekin.rootPath+projectName+"resource"+File.separator );
										File mod_dir = new File ( Rekin.rootPath+projectName+"module"+File.separator );
										lib_dir.mkdir ( );
										res_dir.mkdir ( );
										mod_dir.mkdir ( );
									}
                                    } else {
                                        finish();
                                    }
                                }

							
						} );
			}

	}
