package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	// RocketBLL rate_test
	// Check to see if a RateException is thrown if there are no rates for a
	// given
	// credit score
	
	@Test
	public void test() {
		assert (1 == 1);
	}

	
	@Test
	public void testExampleFCP() throws Exception {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		int creditScore = 700;
		double rate = 0;
		double paymentDue = 0;
		final double CONVERSION = (100 * 12); 
		try {
			rate = RateBLL.getRate(creditScore) / CONVERSION;
		} catch (RateException e) {
			throw e;
		}

		paymentDue = rocketBase.RateBLL.getPayment(rate, 360, 300000, 0, false);

		assertEquals(Math.round(paymentDue * 100.00) / 100.00, 1432.25, .01);
	}

	@Test(expected = RateException.class)
	public void testRateException() throws Exception {
		ArrayList<RateDomainModel> rate = RateDAL.getAllRates();
		int creditScore = 200;
		try {
			double rated = RateBLL.getRate(creditScore);
		} catch (RateException exception) {
			throw exception;
		}
	}
}
