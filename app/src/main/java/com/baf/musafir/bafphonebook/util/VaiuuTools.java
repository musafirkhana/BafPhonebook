package com.baf.musafir.bafphonebook.util;

import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;

public class VaiuuTools {
	public static final String TAG = "KissTools";
	private static WeakReference<Context> contextRef;

	public static void setContext(Context context) {
		if (context == null) {
			throw new InvalidParameterException("Invalid context parameter!");
		}

		Context appContext = context.getApplicationContext();
		contextRef = new WeakReference<Context>(appContext);
	}

	public static Context getApplicationContext() {
		Context context = contextRef.get();
		if (context == null) {
			throw new InvalidParameterException("Context parameter not set!");
		} else {
			return context;
		}
	}

	public static boolean isDebugable() {
		try {
			ApplicationInfo info = getApplicationContext().getApplicationInfo();
			return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void runOnMain(Runnable runnable) {
		if (runnable == null) {
			return;
		}

		boolean isMain = Looper.getMainLooper() == Looper.myLooper();
		if (isMain) {
			runnable.run();
		} else {
			Handler handler = new Handler(Looper.getMainLooper());
			handler.post(runnable);
		}
	}

	public static void runOnMain(Runnable runnable, long delay) {
		if (runnable == null) {
			return;
		}
		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(runnable, delay);
	}
}
