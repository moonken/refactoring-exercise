package version0;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the example in chapter 1 of "Refactoring" by Fowler.
 *
 */
public class CustomerTest {

	private static final String TEST_CUSTOMER = "Zhang Sanfeng";
	private static final int ONE_DAY = 1;
	private static final int TWO_DAYS = 2;
	private static final int THREE_DAYS = 3;
	private static final int FOUR_DAYS = 4;

	@Test
	public void should_charge_2_and_earn_1_points_when_rent_a_regular_movie_for_2_days() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Die Hard", Movie.REGULAR, TWO_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tDie Hard\t2.0\n");
		expectedStatement.append("Amount owed is 2.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	private Rental createRental(Customer customer, String movieTitle, int moviePriceType, int rentalDays) {
		Movie aMovie = new Movie(movieTitle, moviePriceType);
		Rental aRental = new Rental(aMovie,rentalDays);
		return aRental;
	}

}
