package com.ikoyski.webtoolsurlshortener.urlshortener;

import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtoolsurlshortener.service.UrlShortenerService;

@SpringBootTest
@ActiveProfiles("test")
class UrlShortenerServiceTest {

	@Autowired
	private UrlShortenerService urlShortenerService;

	@MockBean
	UrlShortenerProviderBaseInterface urlShortenerProvider;

	@Test
	@DisplayName("UrlShortenerServiceTest.createShortenedUrlSuccess()")
	void createShortenedUrlSuccess() {
		// given
		final String ORIGINAL_URL = "http://google.com";
		final String SHORTENED_URL = "http://tinyurl.com/ajtvk4m2";
		UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl(ORIGINAL_URL);
		UrlShortenerResponse urlShortenerResponse = new UrlShortenerResponse();
		urlShortenerResponse.setOriginalUrl(ORIGINAL_URL);
		urlShortenerResponse.setShortenedUrl(SHORTENED_URL);
		doReturn(urlShortenerResponse).when(urlShortenerProvider).createShortenedUrl(urlShortenerRequest);

		// when
		UrlShortenerResponse urlShortenerResponse2 = urlShortenerService.createShortenedUrl(urlShortenerRequest);

		// then
		Assertions.assertEquals(SHORTENED_URL, urlShortenerResponse2.getShortenedUrl().replace("https", "http"));
	}

}
