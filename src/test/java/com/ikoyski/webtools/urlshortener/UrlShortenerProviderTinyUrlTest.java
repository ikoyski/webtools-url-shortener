package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderFactory;

@SpringBootTest
@ActiveProfiles("test")
class UrlShortenerProviderTinyUrlTest {

	@Autowired
	UrlShortenerProviderFactory urlShortenerProviderFactory;

	@Test
	@DisplayName("UrlShortenerProviderTinyUrlTest.urlShortenerProviderTinyUrlSuccess()")
	void urlShortenerProviderTinyUrlSuccess() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("http://google.com");
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);

		// when
		UrlShortenerResponse urlShortenerResponse = urlShortenerProvider.createShortenedUrl(urlShortenerRequest);

		// then
		Assertions.assertNotNull(urlShortenerResponse);
	}

	@Test
	@DisplayName("UrlShortenerProviderTinyUrlTest.urlShortenerProviderTinyUrlException()")
	void urlShortenerProviderTinyUrlException() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("");
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider();

		// when and then
		Assertions.assertThrows(Exception.class, () -> urlShortenerProvider.createShortenedUrl(urlShortenerRequest));
	}

}
