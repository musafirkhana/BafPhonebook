package com.baf.musafir.bafphonebook.util;

public class HTTPPostWithSimpleMultipart {

	private String URL = "";
	private SimpleMultipartEntity entity = new SimpleMultipartEntity();

	public HTTPPostWithSimpleMultipart(String uRL, SimpleMultipartEntity nvps) {
		super();
		URL = uRL;
		entity = nvps;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public SimpleMultipartEntity getEntity() {
		return entity;
	}

	public void setEntity(SimpleMultipartEntity nvps) {
		entity = nvps;
	}

}
