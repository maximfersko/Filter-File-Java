package com.fersko.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserLongTest {
	private Parser<Long> integerParser;

	@BeforeEach
	public void init() {
		integerParser = new ParserLong();
	}


	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "4736834894", "-7531039485583", "78323", "-6747923934108256545", "56786422748401114" })
	void isParseRealNumberTest(String number) {
		Assertions.assertTrue(integerParser.isParse(number));
	}

	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "677.56656", "56rf5dse45wser", "huybuyg6767667", "0uj89htg7rt67lmklutfd.iu98", "fttyfty4644564564" })
	void notParseRealNumberTest(String number) {
		Assertions.assertFalse(integerParser.isParse(number));
	}

	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "4736834894", "7531039485583", "7323", "-67256545", "566422748401114" })
	void parseRealNumberTest(String number) {
		Assertions.assertEquals(integerParser.parse(number), Long.parseLong(number));
	}
}
