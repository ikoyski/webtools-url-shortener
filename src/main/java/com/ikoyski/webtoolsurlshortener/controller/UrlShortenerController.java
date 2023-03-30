package com.ikoyski.webtoolsurlshortener.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtoolsurlshortener.service.UrlShortenerService;

@RestController
public class UrlShortenerController {

	private UrlShortenerService urlShortenerService;

	public UrlShortenerController(UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}

	@PostMapping(path = "api/v1/create")
	@Cacheable(value = "shortenedUrl", key = "#urlShortenerRequest.url")
	public UrlShortenerResponse createShortenedUrl(@RequestBody UrlShortenerRequest urlShortenerRequest) {
		return urlShortenerService.createShortenedUrl(urlShortenerRequest);
	}

}
