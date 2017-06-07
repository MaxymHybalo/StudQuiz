package ua.chstu;

import org.junit.Assert;
import org.junit.Test;

import ua.chstu.utils.AuthenticationFieldsBuilder;

public class StudQuizApplicationTests {

	AuthenticationFieldsBuilder afb;

	@Test
	public void testRandomChar(){
		afb = new AuthenticationFieldsBuilder();
		Assert.assertTrue(afb.randomChar() != 0);
	}

	@Test
	public void testStringPart(){
		afb = new AuthenticationFieldsBuilder();
		Assert.assertTrue(afb.randomStringPart().length() == 4);
	}

	@Test
	public void testFullField(){
		afb = new AuthenticationFieldsBuilder();
		String field = afb.buildField();
		System.out.println(field);
		Assert.assertTrue(field.length() > 4);
	}

}
