package com.fersko.parser;

import com.fersko.parser.impl.ParserDouble;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserDoubleTest {

	private Parser<Double> doubleParser;

	@BeforeEach
	void init() {
		doubleParser = new ParserDouble();
	}


	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "4.736834894", "0.14937531039485583", "78.323", "-67.47923934108256545", "56.786422748401114" })
	void isParseRealNumberTest(String number) {
		Assertions.assertTrue(doubleParser.isParse(number));
	}

	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "67756656", "56rf5dse45wser", "huybuyg6767.667", "0uj89htg7rt67lmklutfd.iu98", "fttyfty" })
	void notParseRealNumberTest(String number) {
		Assertions.assertFalse(doubleParser.isParse(number));
	}

	@ParameterizedTest(name = "parseRealNumber")
	@ValueSource(strings = { "4.736834894", "0.14937531039485583", "78.323", "-67.47923934108256545", "56.786422748401114" })
	void parseRealNumberTest(String number) {
		Assertions.assertEquals(doubleParser.parse(number), Double.parseDouble(number));
	}
}
