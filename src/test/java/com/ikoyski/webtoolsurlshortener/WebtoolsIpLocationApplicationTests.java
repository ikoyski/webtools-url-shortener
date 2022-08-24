package com.ikoyski.webtoolsurlshortener;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebtoolsUrlShortenerApplicationTests {

	@Test
	@DisplayName("WebtoolsUrlShortenerApplicationTests.contextLoads()")
	void contextLoads() {
	}

	//@Test
	@DisplayName("WebtoolsUrlShortenerApplicationTests.mainSuccess()")
	void mainSuccess() {
		// when
		WebtoolsUrlShortenerApplication.main(new String[] {});
	}
}
