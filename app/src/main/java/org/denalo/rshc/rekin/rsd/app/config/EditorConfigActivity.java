/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app.config;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import org.denalo.rshc.rekin.rsd.app.*;

public class EditorConfigActivity extends PreferenceActivity {

    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.config_editor);
    }
}
