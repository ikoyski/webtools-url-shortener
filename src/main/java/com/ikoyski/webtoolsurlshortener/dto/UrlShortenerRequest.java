package com.ikoyski.webtoolsurlshortener.dto;

public class UrlShortenerRequest {

	private String url;

	public UrlShortenerRequest() {
		super();
	}

	public UrlShortenerRequest(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UrlShortenerRequest [url=" + url + "]";
	}

}
