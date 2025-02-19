package com.ikoyski.webtools.urlshortener;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.urlshortener.controller.UrlShortenerController;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.service.UrlShortenerService;

@SpringBootTest
class UrlShortenerControllerTest {

	@Autowired
	private UrlShortenerController urlShortenerController;

	@MockitoBean
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
