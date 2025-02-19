package com.ikoyski.webtools.urlshortener.provider;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;

public interface UrlShortenerProviderBaseInterface {

	public static final String ERROR_INVALID_REQUEST = "invalid request";

	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest);

}
