package com.ikoyski.webtoolsurlshortener.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenerProviderFactory {

	public static final String PROVIDER_TINYURL = "TinyUrl";

	@Value("${tinyurl.api.token}")
	private String tinyUrlApiToken;

	public void setTinyUrlApiToken(String tinyUrlApiToken) {
		this.tinyUrlApiToken = tinyUrlApiToken;
	}

	public UrlShortenerProviderBaseInterface createUrlShortenerProvider(String type) {
		if (PROVIDER_TINYURL.equals(type)) {
			// using https://tinyurl.com/
			return new UrlShortenerProviderTinyUrl(tinyUrlApiToken);
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}
