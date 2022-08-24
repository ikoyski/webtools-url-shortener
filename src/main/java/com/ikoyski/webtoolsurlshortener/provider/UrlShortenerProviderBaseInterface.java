package com.ikoyski.webtoolsurlshortener.provider;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;

public interface UrlShortenerProviderBaseInterface {

	public static final String ERROR_INVALID_REQUEST = "invalid request";

	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest);

}
