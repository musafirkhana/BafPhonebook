package com.baf.musafir.bafphonebook.parser;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.baf.musafir.bafphonebook.holder.AllAbbrListVector;
import com.baf.musafir.bafphonebook.model.AbbrlListModel;

public class AbbriviationListParser {
	public static boolean connect(Context con, String result)
			throws JSONException, IOException {

		AllAbbrListVector.removeAbbrlist();
		if (result.length() < 1) {
			return false;

		}

		final JSONArray mainJsonObject = new JSONArray(result);

//		final JSONObject banner = mainJsonObject.getJSONObject("banner");
//		final JSONArray banner_list = mainJsonObject.getJSONArray(result);

		AbbrlListModel abbriListModel;
		for (int i = 0; i < mainJsonObject.length(); i++) {
			JSONObject banner_list_jsonObject = mainJsonObject.getJSONObject(i);

			abbriListModel = new AbbrlListModel();
			AllAbbrListVector allArabicList = new AllAbbrListVector();
			abbriListModel.setAbbr(banner_list_jsonObject.getString("abbr"));
			abbriListModel.setAbbreviate(banner_list_jsonObject.getString("Abbreviate"));
			
			allArabicList.setAllAbbrlist(abbriListModel);
			abbriListModel = null;
		}

		
		return true;
	}
}
