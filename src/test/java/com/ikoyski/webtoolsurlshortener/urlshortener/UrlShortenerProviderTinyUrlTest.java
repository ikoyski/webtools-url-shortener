package com.ikoyski.webtoolsurlshortener.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtoolsurlshortener.provider.UrlShortenerProviderFactory;

@SpringBootTest
class UrlShortenerProviderTinyUrlTest {

	// @Test
	@DisplayName("UrlShortenerProviderTinyUrlTest.urlShortenerProviderTinyUrlSuccess()")
	void urlShortenerProviderTinyUrlSuccess() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("http://google.com");
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);

		// when
		UrlShortenerResponse urlShortenerResponse = urlShortenerProvider.createShortenedUrl(urlShortenerRequest);

		// then
		Assertions.assertNotNull(urlShortenerResponse);
	}

	// @Test
	@DisplayName("UrlShortenerProviderTinyUrlTest.urlShortenerProviderTinyUrlException()")
	void urlShortenerProviderTinyUrlException() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("");
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);

		// when and then
		Assertions.assertThrows(Exception.class, () -> urlShortenerProvider.createShortenedUrl(urlShortenerRequest));
	}

}
