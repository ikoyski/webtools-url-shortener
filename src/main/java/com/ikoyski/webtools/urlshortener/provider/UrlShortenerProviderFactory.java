package com.ikoyski.webtools.urlshortener.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenerProviderFactory {

	public static final String PROVIDER_TINYURL = "TINYURL";

	@Autowired
	UrlShortenerProviderTinyUrl urlShortenerProviderTinyUrl;
	
	@Value("${provider.default}")
	private String PROVIDER_DEFAULT;

	public UrlShortenerProviderBaseInterface createUrlShortenerProvider() {
		return createUrlShortenerProvider(PROVIDER_DEFAULT);
	}

	public UrlShortenerProviderBaseInterface createUrlShortenerProvider(String type) {
		if (PROVIDER_TINYURL.equals(type)) {
			return urlShortenerProviderTinyUrl;
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}
