package assign6;

import lms.Book;
import lms.Collection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Unit Test for Resource
 * @author Guiming Huang
 */
public class Test_Resource_2 {

    //Set a new book.
    Book test_book_1 = new Book(2162, "Object-Oriented Design & Patterns", "1234567", "Cay Horstmann");

    Collection collection_test = new Collection();

    /**
     * Causes an error if a unique add resource attempt fails
     * @throws Exception
     */
    @Test
    public void test_add_unique_resource() throws Exception {

        collection_test.addResource(test_book_1);

        assertEquals("Attempt to add unique resource failed", test_book_1,
                collection_test.findResource(test_book_1.getResourceID()));
    }

    /**
     * Causes an error if a duplicate resource can be added to a Collection
     * @throws Exception
     */
    @Test
    public void test_add_duplicate_resource() throws Exception {

        Book test_book_2 = test_book_1;

        collection_test.addResource(test_book_1);

        assertEquals("Cannot add a duplicate resource", false, collection_test
                .addResource(test_book_2));
    }
}
