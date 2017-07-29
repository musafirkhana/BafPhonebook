package com.baf.musafir.bafphonebook.util;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baf.musafir.bafphonebook.R;


public class ToastUtil {
	private Activity activity;
	public static Toast mToast;

	public ToastUtil(Activity _activity) {

		this.activity = _activity;
		// other initializations...

	}

	/**
	 * Application Error Toast Message
	 * @param context
	 * @param message
	 */
	public void appErrorMsg(Context context, String message) {
		Toast toast = new Toast(context);
		toast.setDuration(Toast.LENGTH_LONG);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_message,
				(ViewGroup) this.activity.findViewById(R.id.toast_layout_root));

		TextView toast_text = (TextView) layout.findViewById(R.id.toast_text);
		toast_text.setText(message);
		toast.setView(layout);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();

	}
/**
 *  Application Success Toast Message
 * @param context
 * @param message
 */
	public void appSuccessMsg(Context context, String message) {
		Toast toast = new Toast(context);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setGravity(Gravity.BOTTOM, 0, 100);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_message,
				(ViewGroup) this.activity.findViewById(R.id.toast_layout_root));
		//layout.setBackgroundResource(R.color.counter_back);
		TextView toast_text = (TextView) layout.findViewById(R.id.toast_text);
		toast_text.setText(message);
		toast.setView(layout);
		toast.setDuration(20000);
		toast.show();

	}

	@SuppressLint("ShowToast")
	private static void initToast() {
		if (mToast != null) {
			return;
		}
		Context context = VaiuuTools.getApplicationContext();
		if (context == null) {
			return;
		}
		mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
	}

	public static void showToast(int resId) {
		initToast();
		if (resId < 0 || mToast == null) {
			return;
		}

		mToast.setText(resId);
		mToast.show();
	}

	public static void showToast(String message) {
		initToast();
		if (TextUtils.isEmpty(message) || mToast == null) {
			return;
		}

		mToast.setText(message);
		mToast.show();
	}

	public static void dismissToast() {
		if (mToast == null) {
			return;
		}
		mToast.cancel();
	}
}
