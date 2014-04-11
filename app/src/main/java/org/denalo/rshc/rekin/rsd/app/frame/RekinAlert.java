/*******************************************************************************
 * Copyright (c) Denalo Entertainment Organization
 ******************************************************************************/

package org.denalo.rshc.rekin.rsd.app.frame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Basic Alert of Rekin Application
 */
public class RekinAlert {

    protected AlertDialog.Builder builder;
    protected Activity activity;
    protected String confirm;
    protected String cancel;

    public RekinAlert(final Activity act, String title, String confirm) {
        this.activity = act;
        builder = new AlertDialog.Builder(activity);
        builder.setMessage(title);
        builder.setTitle(title);
        builder.setPositiveButton(confirm, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setPositiveAction(dialog, which);
            }
        });
    }

    public RekinAlert(final Activity activity, String title, String msg, String confirm) {
        builder = new AlertDialog.Builder(activity);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton(confirm, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setPositiveAction(dialog, which);
            }
        });
    }

    public RekinAlert(final Activity activity, String title, String msg, String confirm, String cancel) {
        builder = new AlertDialog.Builder(activity);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton(confirm, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setPositiveAction(dialog, which);
            }
        });
        builder.setNegativeButton(cancel, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setNegativeAction(dialog, which);
            }
        });
    }

    public void setPositiveAction() {
    }

    public void setPositiveAction(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    public void setNegativeAction() {
    }

    public void setNegativeAction(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    public void create() {
        builder.show();
    }

}
