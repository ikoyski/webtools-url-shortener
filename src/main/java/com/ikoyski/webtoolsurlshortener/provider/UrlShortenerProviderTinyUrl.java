package com.ikoyski.webtoolsurlshortener.provider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;

public class UrlShortenerProviderTinyUrl implements UrlShortenerProviderBaseInterface {

	@Override
	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest) {
		UrlShortenerResponse urlShortenerResponse = null;
		try {
			/**
			 * TODO: need the implementation. Refer to https://tinyurl.com/app/dev
			 */
			URI uri = new URI("https://api.tinyurl.com/create");
			RestTemplate restTemplate = new RestTemplate();
			urlShortenerResponse = restTemplate.getForObject(uri.toURL().toString(), UrlShortenerResponse.class);
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					UrlShortenerProviderBaseInterface.ERROR_INVALID_REQUEST, null);
		}
		return urlShortenerResponse;
	}

}
