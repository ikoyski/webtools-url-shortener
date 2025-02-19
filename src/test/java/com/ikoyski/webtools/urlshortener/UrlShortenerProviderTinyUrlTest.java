package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.urlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtools.urlshortener.dto.UrlShortenerResponse;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderFactory;

@SpringBootTest
class UrlShortenerProviderTinyUrlTest {
	
	@Value("${provider.tinyurl.api.token}")
	private String tinyUrlApiToken;

	@Test
	@DisplayName("UrlShortenerProviderTinyUrlTest.urlShortenerProviderTinyUrlSuccess()")
	void urlShortenerProviderTinyUrlSuccess() {
		// given
		final UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
		urlShortenerRequest.setUrl("http://google.com");
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();
		urlShortenerProviderFactory.setTinyUrlApiToken(tinyUrlApiToken);
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
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();
		urlShortenerProviderFactory.setTinyUrlApiToken(tinyUrlApiToken);
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);

		// when and then
		Assertions.assertThrows(Exception.class, () -> urlShortenerProvider.createShortenedUrl(urlShortenerRequest));
	}

}
