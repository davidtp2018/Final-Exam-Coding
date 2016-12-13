package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();

	public static double getRate(int GivenCreditScore) throws RateException {
		// RocketBLL RateBLL.getRate - make sure you throw any exception

		// Call RateDAL.getAllRates... this returns an array of rates
		// write the code that will search the rates to determine the
		// interest rate for the given credit score
		// hints: you have to sort the rates... you can do this by using
		// a comparator... or by using an OrderBy statement in the HQL
		ArrayList<RateDomainModel> rdm = _RateDAL.getAllRates();
		RateDomainModel rmds = null;
		double finRate = -1.0;

		for (RateDomainModel rates : rdm) {

			if (rates.getiMinCreditScore() == GivenCreditScore) {
				finRate = rates.getdInterestRate();
				rmds = rates;
			}
		}

		// RocketBLL RateBLL.getRate
		// obviously this should be changed to return the determined rate
		if (rmds == null) {
			throw new RateException(rmds);
		}

		// RocketBLL RateBLL.getRate
		// obviously this should be changed to return the determined rate

		else
			return finRate;

	}

	// RocketBLL RateBLL.getPayment
	// how to use:
	// https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html

	public static double getPayment(double r, double n, double p, double f, boolean t) {
		return -FinanceLib.pmt(r, n, p, f, t);
	}
}
