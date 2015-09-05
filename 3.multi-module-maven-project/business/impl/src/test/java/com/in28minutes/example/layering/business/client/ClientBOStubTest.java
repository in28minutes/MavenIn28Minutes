package com.in28minutes.example.layering.business.client;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.layering.business.api.client.ClientBO;
import com.in28minutes.example.layering.model.api.client.Amount;
import com.in28minutes.example.layering.model.api.client.Currency;
import com.in28minutes.example.layering.model.impl.client.AmountImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/BusinessApplicationContext.xml" })
public class ClientBOStubTest {

	private static final int DUMMY_CLIENT_ID = 1;

	@Autowired
	private ClientBO clientBO;

	@Test
	public void testClientProductSum() {
		assertAmountEquals(
				new AmountImpl(new BigDecimal("11.0"), Currency.EURO),
				clientBO.getClientProductsSum(DUMMY_CLIENT_ID));
	}

	private void assertAmountEquals(Amount expectedAmount, Amount actualAmount) {
		assertEquals(expectedAmount.getCurrency(), actualAmount.getCurrency());
		assertEquals(expectedAmount.getValue(), actualAmount.getValue());
	}

}