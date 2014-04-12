/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app.frame.alert;

import android.app.Activity;
import android.content.DialogInterface;

import org.denalo.rshc.rekin.rsd.app.frame.RekinAlert;

public class ExitAlert extends RekinAlert {
    public ExitAlert(final Activity activity) {
        super(activity, "Confirm Exit", "Are you sure to exit?", "Confirm", "Cancel");
    }

    @Override
    public void setPositiveAction(DialogInterface dialog, int which) {
        dialog.dismiss();
        activity.finish();
    }

    @Override
    public void setNegativeAction(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    @Override
    public void create() {
        super.create();
    }
}
