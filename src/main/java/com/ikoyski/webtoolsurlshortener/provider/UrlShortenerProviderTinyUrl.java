package com.ikoyski.webtoolsurlshortener.provider;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerRequest;
import com.ikoyski.webtoolsurlshortener.dto.UrlShortenerResponse;

public class UrlShortenerProviderTinyUrl implements UrlShortenerProviderBaseInterface {

	private static final String URI_CREATE = "https://api.tinyurl.com/create";

	private String apiToken;

	public UrlShortenerProviderTinyUrl(String apiToken) {
		super();
		this.apiToken = apiToken;
	}

	@Override
	public UrlShortenerResponse createShortenedUrl(UrlShortenerRequest urlShortenerRequest) {
		UrlShortenerResponse urlShortenerResponse = null;
		try {
			URI uri = new URI(URI_CREATE);
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + apiToken);

			urlShortenerResponse = responseAdapter(restTemplate.postForObject(uri,
					new HttpEntity<TinyUrlRequest>(requestAdapter(urlShortenerRequest), headers),
					TinyUrlResponse.class));
		} catch (URISyntaxException | RestClientException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					UrlShortenerProviderBaseInterface.ERROR_INVALID_REQUEST, null);
		}
		return urlShortenerResponse;
	}

	private TinyUrlRequest requestAdapter(UrlShortenerRequest request) {
		TinyUrlRequest tinyUrlRequest = new TinyUrlRequest();
		tinyUrlRequest.setUrl(request.getUrl());
		return tinyUrlRequest;
	}

	private UrlShortenerResponse responseAdapter(TinyUrlResponse response) {
		UrlShortenerResponse urlShortenerResponse = new UrlShortenerResponse();
		urlShortenerResponse.setOriginalUrl(response.getData().getUrl());
		urlShortenerResponse.setShortenedUrl(response.getData().getTiny_url());
		return urlShortenerResponse;
	}

	public static class TinyUrlRequest {

		String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}

	public static class TinyUrlResponse {

		private Data data;

		public Data getData() {
			return data;
		}

		public void setData(Data data) {
			this.data = data;
		}

		public static class Data {

			String tiny_url;
			String url;

			public String getTiny_url() {
				return tiny_url;
			}

			public void setTiny_url(String tiny_url) {
				this.tiny_url = tiny_url;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

		}

	}

}
