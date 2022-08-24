package com.ikoyski.webtoolsurlshortener.service;

import org.springframework.stereotype.Service;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderFactory;

@Service
public class UrlShortenerService {

	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest) {
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);
		return urlShortenerProvider.createShortenedUrl(urlShortenerRequest);
	}

}
