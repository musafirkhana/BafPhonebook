package com.baf.musafir.bafphonebook.util;

import java.util.List;

import org.apache.http.cookie.Cookie;

import android.content.SharedPreferences;
import android.util.Log;

public class CurrentData {

	private static List<Cookie> cookies = null;
	static SharedPreferences myprefer;
	static SharedPreferences.Editor editor;

	/**
	 * @return the cookies
	 */
	public static List<Cookie> getCookies() {
		//
		// List<Cookie> temp = new ArrayList<Cookie>();
		// // Cookie cookie = new MyCookie();
		//
		// BasicClientCookie newCookie = new BasicClientCookie("cookiesare",
		// "awesome");
		//
		// int size = myprefer.getInt(SharedPreferenceTag.SIZE, 0);
		//
		// for (int i = 0; i < size; i++) {
		//
		// newCookie.setVersion(1);
		// newCookie.setDomain("mydomain.com");
		// newCookie.setPath("/");
		//
		// temp.add(newCookie);
		//
		// }
		// return temp;

		return CurrentData.cookies;

	}

	/**
	 * @param cookies
	 *            the cookies to set
	 */
	public static void setCookies(final List<Cookie> cookies1) {
		Log.w("web browser", "started");

		CurrentData.cookies = cookies1;

	}

	public static void resetCookies() {
		CurrentData.cookies = null;

	}

}
