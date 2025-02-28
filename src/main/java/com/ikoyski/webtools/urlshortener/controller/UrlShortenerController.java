package com.ikoyski.webtools.urlshortener.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtools.urlshortener.service.UrlShortenerService;

@RestController
@RequestMapping("/url-shortener")
public class UrlShortenerController {

	private UrlShortenerService urlShortenerService;

	public UrlShortenerController(UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}

	@PostMapping(path = "/v1")
	@Cacheable(value = "url-shortener", key = "#urlShortenerRequest.url")
	public UrlShortenerResponse createShortenedUrl(@RequestBody UrlShortenerRequest urlShortenerRequest) {
		return urlShortenerService.createShortenedUrl(urlShortenerRequest);
	}

}
