/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app.config;

import android.os.*;
import android.preference.PreferenceActivity;
import org.denalo.rshc.rekin.rsd.app.*;

public class AppConfigActivity extends PreferenceActivity {

    @Override
    @SuppressWarnings("deprecation")
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        addPreferencesFromResource ( R.xml.config_app );
    }

}
