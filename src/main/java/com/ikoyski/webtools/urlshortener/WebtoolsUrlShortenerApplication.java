package com.ikoyski.webtools.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
public class WebtoolsUrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoolsUrlShortenerApplication.class, args);
	}

}
