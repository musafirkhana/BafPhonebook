package com.baf.musafir.bafphonebook.util;



import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import com.baf.musafir.bafphonebook.R;


public class AlertMessage {

	public static void cancelProgress(final Context c,
			final ProgressDialog progressDialog) {

		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();

		}
	}

	public static void showMessage(final Context c,
			final String s) {
		final AlertDialog.Builder aBuilder = new AlertDialog.Builder(c);
//		aBuilder.setTitle(title);
		aBuilder.setIcon(R.drawable.ic_launcher);
		aBuilder.setMessage(s);

		aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				dialog.dismiss();
//				c.startActivity(new Intent(Settings.ACTION_SETTINGS));
				
			}

		});

		aBuilder.show();
	}
	
	public static void showBanglalinkMessage(final Context c,
			final String s) {
		final AlertDialog.Builder aBuilder = new AlertDialog.Builder(c);
//		aBuilder.setTitle(title);
		aBuilder.setIcon(R.drawable.ic_launcher);
		aBuilder.setMessage(s);

		aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				dialog.dismiss();
				c.startActivity(new Intent(Settings.ACTION_SETTINGS));
				
				
			}

		});
		aBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				dialog.dismiss();
				
			}

		});

		aBuilder.show();
	}
	public static void showErrorMessage(final Context c, final String title,
			final String s) {
		final AlertDialog.Builder aBuilder = new AlertDialog.Builder(c);
		aBuilder.setTitle(title);
		aBuilder.setIcon(R.drawable.ic_launcher);
		aBuilder.setMessage(s);

		aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				
				dialog.dismiss();
			}

		});

		aBuilder.show();
	}
	
	public static void showInternetMessage(final Context c, final String title,
			final String s) {
		final AlertDialog.Builder aBuilder = new AlertDialog.Builder(c);
		aBuilder.setTitle(title);
		aBuilder.setMessage(s);

		aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(final DialogInterface dialog, final int which) {
				dialog.dismiss();
			}

		});

		aBuilder.show();
	}
	public static void showProgress(final Context c,
			ProgressDialog progressDialog) {
		if (progressDialog == null) {
			progressDialog = new ProgressDialog(c);
		}
		if (progressDialog != null && !progressDialog.isShowing()) {
			progressDialog = ProgressDialog.show(c, "Please wait...",
					"Buffering...", true, true);
		}

	}
}
