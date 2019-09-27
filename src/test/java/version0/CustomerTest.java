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

	@Test
	public void should_charge_3_5_and_earn_1_points_when_rent_a_regular_movie_for_3_days() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental;
		aRental = createRental(customer, "Die Hard", Movie.REGULAR, THREE_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tDie Hard\t3.5\n");
		expectedStatement.append("Amount owed is 3.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void should_charge_1_5_and_earn_1_points_when_rent_a_children_movie_for_3_days() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDREN, THREE_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tKung Fu Panda\t1.5\n");
		expectedStatement.append("Amount owed is 1.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void should_charge_3_and_earn_1_points_when_rent_a_children_movie_for_4_days() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDREN, FOUR_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tKung Fu Panda\t3.0\n");
		expectedStatement.append("Amount owed is 3.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

  @Test
  public void should_charge_3_and_earn_1_points_when_rent_a_new_release_movie_for_1_days() {
    Customer customer = new Customer(TEST_CUSTOMER);
    Rental aRental = createRental(customer, "The Incident", Movie.NEW_RELEASE, ONE_DAY);
    customer.addRental(aRental);
    String statementResult = customer.statement();
    StringBuffer expectedStatement = new StringBuffer();
    expectedStatement.append("Rental Record for Zhang Sanfeng\n");
    expectedStatement.append("\tThe Incident\t3.0\n");
    expectedStatement.append("Amount owed is 3.0\n");
    expectedStatement.append("You earned 1 frequent renter points");
    assertEquals(expectedStatement.toString(),statementResult);
  }

	@Test
	public void should_charge_6_and_earn_2_points_when_rent_a_new_release_movie_for_2_days() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "The Incident", Movie.NEW_RELEASE, TWO_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tThe Incident\t6.0\n");
		expectedStatement.append("Amount owed is 6.0\n");
		expectedStatement.append("You earned 2 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void should_charge_0_and_earn_0_points_when_no_rental() {
		Customer customer = new Customer(TEST_CUSTOMER);
		String statementResult = customer.statement();
		assertEquals("Rental Record for Zhang Sanfeng\nAmount owed is 0.0\nYou earned 0 frequent renter points",statementResult);
	}

	@Test
	public void should_summary_charge_and_points_when_rent_multiple_movies() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental;
		aRental = createRental(customer, "Die Hard", Movie.REGULAR, TWO_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "The Incident", Movie.NEW_RELEASE, TWO_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDREN, THREE_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "Star Wars", Movie.REGULAR, ONE_DAY);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for Zhang Sanfeng\n");
		expectedStatement.append("\tDie Hard\t2.0\n");
		expectedStatement.append("\tThe Incident\t6.0\n");
		expectedStatement.append("\tKung Fu Panda\t1.5\n");
		expectedStatement.append("\tStar Wars\t2.0\n");
		expectedStatement.append("Amount owed is 11.5\n");
		expectedStatement.append("You earned 5 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	private Rental createRental(Customer customer, String movieTitle, int moviePriceType, int rentalDays) {
		Movie aMovie = new Movie(movieTitle, moviePriceType);
		Rental aRental = new Rental(aMovie,rentalDays);
		return aRental;
	}

}
