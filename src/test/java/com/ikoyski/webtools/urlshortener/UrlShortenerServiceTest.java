package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtools.urlshortener.service.UrlShortenerService;

@SpringBootTest
@ActiveProfiles("test")
class UrlShortenerServiceTest {

	@Autowired
	private UrlShortenerService urlShortenerService;

	@Test
	@DisplayName("UrlShortenerServiceTest.createShortenedUrlSuccess()")
	void createShortenedUrlSuccess() {
		// given
		final String ORIGINAL_URL = "http://google.com";
		final String SHORTENED_URL = "http://tinyurl.com/ajtvk4m2";
		UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl(ORIGINAL_URL);

		// when
		UrlShortenerResponse urlShortenerResponse = urlShortenerService.createShortenedUrl(urlShortenerRequest);

		// then
		Assertions.assertEquals(SHORTENED_URL, urlShortenerResponse.getShortenedUrl().replace("https", "http"));
	}

}
