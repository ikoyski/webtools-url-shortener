package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderFactory;

@SpringBootTest
class UrlShortenerProviderFactoryTest {

	@Test
	@DisplayName("UrlShortenerProviderFactoryTest.urlShortenerProviderFactorySuccess()")
	void urlShortenerProviderFactorySuccess() {
		// given
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();

		// when
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider(UrlShortenerProviderFactory.PROVIDER_TINYURL);

		// then
		Assertions.assertNotNull(urlShortenerProvider);
	}

	@Test
	@DisplayName("UrlShortenerProviderFactoryTest.urlShortenerProviderFactoryException()")
	void urlShortenerProviderFactoryException() {
		// given
		UrlShortenerProviderFactory urlShortenerProviderFactory = new UrlShortenerProviderFactory();

		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> urlShortenerProviderFactory.createUrlShortenerProvider("Dummy"));
	}
}
