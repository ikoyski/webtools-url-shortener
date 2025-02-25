package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;

@SpringBootTest
@ActiveProfiles("test")
class UrlShortenerResponseTest {

	@Test
	@DisplayName("UrlShortenerResponseTest.urlShortenerResponseSuccess()")
	void urlShortenerResponseSuccess() {
		// given
		final String ORIGINAL_URL = "http://google.com";
		final String SHORTENED_URL = "https://tinyurl.com/ajtvk4m2";
		UrlShortenerResponse urlShortenerResponse = new UrlShortenerResponse();

		// when
		urlShortenerResponse.setOriginalUrl(ORIGINAL_URL);
		urlShortenerResponse.setShortenedUrl(SHORTENED_URL);

		// then
		Assertions.assertEquals(urlShortenerResponse.getOriginalUrl(), ORIGINAL_URL);
		Assertions.assertEquals(urlShortenerResponse.getShortenedUrl(), SHORTENED_URL);
	}
}
