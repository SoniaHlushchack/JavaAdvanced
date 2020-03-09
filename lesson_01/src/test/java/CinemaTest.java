

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {

	private Cinema cinemaTest;

	private Movie movie;
	private Movie movie1;

	private Seance seance;
	private Seance seance2;
	

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED-->" + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED-->" + description.getMethodName());
		};

	};

	@Before
	public void beforeTest() {
		cinemaTest = new Cinema();
		movie = new Movie("Focus", new Time(1, 20));
		movie1 = new Movie("Story of Princes Sofia", new Time(1, 10));

		seance = new Seance(movie, new Time(18, 00));
		seance2 = new Seance(movie1, new Time(19, 05));

	}

	@After
	public void afterTest() {
		cinemaTest = null;
		movie = null;
		movie1 = null;

		seance = null;
		seance2 = null;

	}

	@Test
	public void addMovieTest() {

		cinemaTest.addMovie(movie);
		cinemaTest.addMovie(movie1);

		ArrayList<Movie> real = cinemaTest.getMoviesLibrary();

		ArrayList<Movie> expected = new ArrayList<>();
		expected.add(movie);
		expected.add(movie1);

		Assert.assertEquals(expected, real);

	}

	@Test
	public void removeMovieTest() {
		cinemaTest.addMovie(movie);
		cinemaTest.addMovie(movie1);

		cinemaTest.removeMovie(movie);

		ArrayList<Movie> real = cinemaTest.getMoviesLibrary();

		ArrayList<Movie> expected = new ArrayList<>();

		expected.add(movie1);

		Assert.assertEquals(expected, real);

	}

}
