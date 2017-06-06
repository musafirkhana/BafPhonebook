/*
 * Copyright (C) 2010 Mathieu Favez - http://mfavez.com
 *
 *
 * This file is part of FeedGoal.
 * 
 * FeedGoal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FeedGoal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FeedGoal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.baf.musafir.bafphonebook.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public final class SharedPreferencesHelper {

	private static final String LOG_TAG = "SharedPreferencesHelper";
	public static final String REMEMBER = "remember";
	// App Preferences
	private static final String PREFS_FILE_NAME = "AppPreferences";
	private static final String USER_NAME = "user_name";
	private static final String DRIVER_ID = "driver_id";
	private static final String DRIVER_PIN = "driver_pin";
	private static final String PASS = "pass";
	private static String ONLINE = "online";

	private static final String OUTLET_IMAGE = "outlet_image_url";
	private static final String OUTLET_NAME = "outlet_name";
	private static final String OUTLET_ADDRESS = "outlet_address";
	private static final String OUTLET_PHONE = "outlet_phone";
	private static final String OUTLET_LAT= "outlet_lat";
	private static final String OUTLET_LONG = "outlet_long";
//start jani
	private static final String DRIVER_JOB_ID = "job_id";

	private static final String OUTLET_UPDATE_REASON = "update_Reason";


	public static String getFlurryAnalyticsApiKey(final Context ctx) {
		String flurryAnalyticsApiKey = null;
		try {
			final ApplicationInfo ai = ctx.getPackageManager()
					.getApplicationInfo(ctx.getPackageName(),
							PackageManager.GET_META_DATA);
			flurryAnalyticsApiKey = ai.metaData.getString("FLURRY_API_KEY");
		} catch (final NameNotFoundException nnfe) {
			Log.e(SharedPreferencesHelper.LOG_TAG, "", nnfe);
		}
		return flurryAnalyticsApiKey;
	}

	public static String getGoogleAnalyticsProfileId(final Context ctx) {
		String googleAnalyticsProfileId = null;
		try {
			final ApplicationInfo ai = ctx.getPackageManager()
					.getApplicationInfo(ctx.getPackageName(),
							PackageManager.GET_META_DATA);
			googleAnalyticsProfileId = ai.metaData
					.getString("GOOGLE_ANALYTICS_PROFILE_ID");
		} catch (final NameNotFoundException nnfe) {
			Log.e(SharedPreferencesHelper.LOG_TAG, "", nnfe);
		}
		return googleAnalyticsProfileId;
	}

	public static String getMobclixApplicationId(final Context ctx) {
		String mobclixApplicationId = null;
		try {
			final ApplicationInfo ai = ctx.getPackageManager()
					.getApplicationInfo(ctx.getPackageName(),
							PackageManager.GET_META_DATA);
			mobclixApplicationId = ai.metaData
					.getString("com.mobclix.APPLICATION_ID");
		} catch (final NameNotFoundException nnfe) {
			Log.e(SharedPreferencesHelper.LOG_TAG, "", nnfe);
		}
		return mobclixApplicationId;
	}





	public static boolean getRemember(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getBoolean(SharedPreferencesHelper.REMEMBER, false);
	}

	public static int getSplashDuration(final Context ctx) {
		int splashScreenDuration = 2000;
		try {
			final ApplicationInfo ai = ctx.getPackageManager()
					.getApplicationInfo(ctx.getPackageName(),
							PackageManager.GET_META_DATA);
			splashScreenDuration = ai.metaData.getInt("splash_screen_duration");
		} catch (final NameNotFoundException nnfe) {
			Log.e(SharedPreferencesHelper.LOG_TAG, "", nnfe);
		}
		return splashScreenDuration;
	}

	public static String getUser(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.USER_NAME, "");
	}
	public static String getImageUrl(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.OUTLET_IMAGE, "");
	}
	public static String getOutletName(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.OUTLET_NAME, "");

	}
	public static String getOutletAddress(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.OUTLET_ADDRESS, "");
	}
	public static String getOutletPhone(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.OUTLET_PHONE, "");
	}
	public static String getDriverId(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.DRIVER_ID, "");
	}
	public static String getDriverPin(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.DRIVER_PIN, "");
	}

	public static String getDriverJobId(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.DRIVER_JOB_ID, "");

	}
	public static String getOutletUpadte(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.OUTLET_UPDATE_REASON, "");

	}

	public static CharSequence getVersionName(final Context ctx) {
		CharSequence version_name = "";
		try {
			final PackageInfo packageInfo = ctx.getPackageManager()
					.getPackageInfo(ctx.getPackageName(), 0);
			version_name = packageInfo.versionName;
		} catch (final NameNotFoundException nnfe) {
			Log.e(SharedPreferencesHelper.LOG_TAG, "", nnfe);
		}
		return version_name;
	}

	public static boolean isOnline(final Context ctx) {
		final ConnectivityManager cm = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni != null) {
			return ni.isConnectedOrConnecting();
		} else {
			return false;
		}
	}

	public static void setPass(final Context ctx, final String pass) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.PASS, pass);
		editor.commit();
	}
	public static void setRemember(final Context ctx, final boolean flag) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putBoolean(SharedPreferencesHelper.REMEMBER, flag);
		editor.commit();
	}

	public static void setOutletName(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_NAME, user);
		editor.commit();
	}
	public static void setOutletAddress(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_ADDRESS, user);
		editor.commit();
	}


	public static void setOutlatLat(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_MULTI_PROCESS);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_LAT, user);
		editor.commit();
	}
	public static String getOutlatLat(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_MULTI_PROCESS)
				.getString(SharedPreferencesHelper.OUTLET_LAT, "");
	}

	public static void setOutlatLong(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_MULTI_PROCESS);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_LONG, user);
		editor.commit();
	}
	public static String getOutlatLong(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_MULTI_PROCESS)
				.getString(SharedPreferencesHelper.OUTLET_LONG, "");
	}
	public static void setOutletPhone(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_PHONE, user);
		editor.commit();
	}

	public static void setDriverJobId(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.DRIVER_JOB_ID, user);
		editor.commit();
	}

	public static void setOutletUpadte(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_UPDATE_REASON, user);
		editor.commit();
	}



	public static void setUser(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.USER_NAME, user);
		editor.commit();
	}
	public static void setImageUrl(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.OUTLET_IMAGE, user);
		editor.commit();
	}
	public static void setDriverID(final Context ctx, final String driverID) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.DRIVER_ID, driverID);
		editor.commit();
	}
	public static void setDriverPIN(final Context ctx, final String driverID) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.DRIVER_PIN, driverID);
		editor.commit();
	}



	public static void logOut(Context c) {
		final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
				Context.MODE_PRIVATE);
		prefs.edit().putBoolean("LOGIN", false).commit();

	}

	public static void setLogin(Context c) {
		final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
				Context.MODE_PRIVATE);
		prefs.edit().putBoolean("LOGIN", true).commit();
	}

	public static boolean isLogged(Context c) {
		final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
				Context.MODE_PRIVATE);
		return prefs.getBoolean("LOGIN", true);
	}

	public static boolean trackFlurryAnalytics(final Context ctx) {
		boolean track = true;
		final String flurryAnalyticsApiKey = SharedPreferencesHelper
				.getFlurryAnalyticsApiKey(ctx);

		if (flurryAnalyticsApiKey == null
				|| flurryAnalyticsApiKey
						.equalsIgnoreCase("xxxxxxxxxxxxxxxxxxxx")) {
			track = false;
		} else {
			track = true;
		}

		return track;
	}

	// Shared getter util methods

	public static boolean trackGoogleAnalytics(final Context ctx) {
		boolean track = true;
		final String googleAnalyticsProfileId = SharedPreferencesHelper
				.getGoogleAnalyticsProfileId(ctx);

		if (googleAnalyticsProfileId == null
				|| googleAnalyticsProfileId.equalsIgnoreCase("UA-xxxxx-xx")) {
			track = false;
		} else {
			track = true;
		}

		return track;
	}

	public static boolean trackMobclixSession(final Context ctx) {
		boolean track = true;
		final String mobclixApplicationId = SharedPreferencesHelper
				.getMobclixApplicationId(ctx);

		if (mobclixApplicationId == null
				|| mobclixApplicationId
						.equalsIgnoreCase("xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx")) {
			track = false;
		} else {
			track = true;
		}

		return track;
	}

	public static void setOnlineOrOffline(final Context ctx, final boolean flag) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putBoolean(SharedPreferencesHelper.ONLINE, flag);
		editor.commit();
	}

	public static boolean getOnlineOrOffline(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getBoolean(SharedPreferencesHelper.ONLINE, false);
	}

}
