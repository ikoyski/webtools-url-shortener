package com.ikoyski.webtoolsurlshortener.provider;

public class UrlShortenerProviderFactory {

	public static final String PROVIDER_TINYURL = "TinyUrl";

	public UrlShortenerProviderBaseInterface createUrlShortenerProvider(String type) {
		UrlShortenerProviderBaseInterface urlShortenerProvider;
		if (PROVIDER_TINYURL.equals(type)) {
			// using https://tinyurl.com/
			urlShortenerProvider = new UrlShortenerProviderTinyUrl();
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
		return urlShortenerProvider;
	}

}
