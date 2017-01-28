package assign6;

import lms.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Resource
 * @author Guiming Huang
 */
public class Test_Resource_1{

    //Initialize Calendar.
    Calendar test_date_1 = Calendar.getInstance();

    //Set a new book.
    Book test_book = new Book(2162, "Object-Oriented Design & Patterns", "1234567", "Cay Horstmann");

    /**
     * Simulates a book which is overdue for 16 days. Correct fine is $4.0.
     * @throws Exception
     */
    @Test
    public void test_past_due() throws Exception {
        test_book.setDueDate(test_date_1);
        test_date_1.add(Calendar.DATE, 16);
        assertEquals("Late fine not assessed correctly", 4.0, test_book
                .calculateFine(test_date_1), .00);
    }

    /**
     * Simulates a book due today. Correct fine is $0.0.
     * @throws Exception
     */
    @Test
    public void test_due_today() throws Exception {
        Calendar cloneDate = (Calendar)test_date_1.clone();
        test_book.setDueDate(test_date_1);
        assertEquals("Resource turned in on due date. It should have no fine",
                0, test_book.calculateFine(cloneDate), .00);
    }

    /**
     * Simulates a book not due in 16 days. Correct fine is $0.0.
     * @throws Exception
     */
    @Test
    public void test_not_due_yet() throws Exception {
        test_book.setDueDate(test_date_1);
        test_date_1.add(Calendar.DATE, -16);
        assertEquals("Resource has not yet due. It should have no fine", 0,
                test_book.calculateFine(test_date_1), .00);
    }

    /**
     * Simulates a book without due date. Correct fine is $0.0.
     * @throws Exception
     */
    @Test
    public void test_missing_due_date() throws Exception {
        assertEquals("Resource without due date should have no late fine", 0,
                test_book.calculateFine(test_date_1), .00);
    }

}
