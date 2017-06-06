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

package com.baf.musafir.bafphonebook.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Provides helpful getter/setter methods to wrap shared preferences
 * (application prefs + user prefs + manifest properties).
 * 
 */

public final class SharedPreferencesHelper {

	private static final String FIRSTTime = "FIRSTTime";
	private static final String PREFS_FILE_NAME = "TrelloAppPreference";
	private static final String PREFS_USR_NAME= "CHECK_PREV_LOGED";
	private static final String TRELLO_TOKEN = "trello_token";

	public static boolean getFirstTime(final Context ctx) {
		return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getBoolean(FIRSTTime, true);
	}

	public static void setFirstTime(final Context ctx, final boolean flag) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putBoolean(FIRSTTime, flag);
		editor.commit();
	}
	
	
	public static String getTrelloAuth(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.TRELLO_TOKEN, "");
	}
	public static void setTrelloAuth(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.TRELLO_TOKEN, user);
		editor.commit();
	}

	public static String getUserName(final Context ctx) {
		return ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE)
				.getString(SharedPreferencesHelper.PREFS_USR_NAME, "");
	}
	public static void setuserName(final Context ctx, final String user) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferencesHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putString(SharedPreferencesHelper.PREFS_USR_NAME, user);
		editor.commit();
	}


	public static boolean isOnline(final Context ctx) {

		try {
			final ConnectivityManager cm = (ConnectivityManager) ctx
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			final NetworkInfo ni = cm.getActiveNetworkInfo();
			if (ni != null) {
				return ni.isConnectedOrConnecting();
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
