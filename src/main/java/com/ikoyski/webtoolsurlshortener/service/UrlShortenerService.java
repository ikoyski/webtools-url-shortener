package com.ikoyski.webtoolsurlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderFactory;

@Service
public class UrlShortenerService {

	@Autowired
	private UrlShortenerProviderFactory urlShortenerProviderFactory;

	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest) {
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider();
		return urlShortenerProvider.createShortenedUrl(urlShortenerRequest);
	}

}
