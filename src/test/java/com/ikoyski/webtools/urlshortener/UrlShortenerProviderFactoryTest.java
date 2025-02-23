package com.ikoyski.webtools.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderBaseInterface;
import com.ikoyski.webtools.urlshortener.provider.UrlShortenerProviderFactory;

@SpringBootTest
class UrlShortenerProviderFactoryTest {

	@Autowired
	UrlShortenerProviderFactory urlShortenerProviderFactory;

	@Test
	@DisplayName("UrlShortenerProviderFactoryTest.urlShortenerProviderFactorySuccess()")
	void urlShortenerProviderFactorySuccess() {
		// when
		UrlShortenerProviderBaseInterface urlShortenerProvider = urlShortenerProviderFactory
				.createUrlShortenerProvider();

		// then
		Assertions.assertNotNull(urlShortenerProvider);
	}

	@Test
	@DisplayName("UrlShortenerProviderFactoryTest.urlShortenerProviderFactoryException()")
	void urlShortenerProviderFactoryException() {
		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> urlShortenerProviderFactory.createUrlShortenerProvider("Dummy"));
	}
}
