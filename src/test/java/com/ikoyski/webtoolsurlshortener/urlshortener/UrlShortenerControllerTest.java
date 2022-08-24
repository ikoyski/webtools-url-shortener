package com.ikoyski.webtoolsurlshortener.urlshortener;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ikoyski.webtoolsurlshortener.controller.UrlShortenerController;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.service.UrlShortenerService;

@SpringBootTest
class UrlShortenerControllerTest {

	@Autowired
	private UrlShortenerController urlShortenerController;

	@MockBean
	private UrlShortenerService urlShortenerService;

	@Test
	@DisplayName("UrlShortenerControllerTest.createShortenedUrl()")
	void createShortenedUrlSucces() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("http://google.com");

		// when
		urlShortenerController.createShortenedUrl(urlShortenerRequest);

		// then
		verify(urlShortenerService).createShortenedUrl(urlShortenerRequest);
	}

}
