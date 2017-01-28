package assign6;

import lms.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test for Resource
 * @author Guiming Huang
 */
public class Test_Resource_3 {

    //Initialize Calendar.
    Calendar test_date_2 = Calendar.getInstance();

    //Set a new book.
    Book test_book_1 = new Book(2162, "Object-Oriented Design & Patterns", "1234567", "Cay Horstmann");

    //Set a new movie.
    Resource test_movie = new Movie(3142, "Star Wars", "12345678");

    //Instantiate a MemberList and Collection.
    MemberList memberListTest = new MemberList();
    Collection collectionTest = new Collection();

    //Instantiate a new member as student and one as staff.
    Member studentMemberTest = new Student(456);
    Member facultyMemberTest = new Faculty(123);

    //Books Test-cases
    //Student
    /**
     *  Tests to calculate new due date for a student and book.
     */
    @Test
    public void test_student_book() throws Exception{
        //Add a book to resource list. Add a new due date and keep track
        // of it.
        collectionTest.addResource(test_book_1);
        test_book_1.setDueDate(test_date_2);
        Calendar testDateOld = test_date_2;

        //Construct a new Controller using the MemberList and Collection.
        Controller testControl = new Controller(memberListTest,
                collectionTest);
        testControl.checkout(studentMemberTest.getMemberID(),
                test_book_1.getResourceID());

        //Try to change due date.
        Calendar test_date_3 = test_book_1.calculateNewDueDate(test_date_2, studentMemberTest);

        //Books for students are checked out for 28 days.
        testDateOld.add(Calendar.DATE, 28);

        //Test to make sure that the due date has been changed.
        assertEquals("The due date was not updated", testDateOld, test_date_3);
    }

    //Faculty
    /**
     *  Tests to calculate new due date for a Faculty and book.
     */
    @Test
    public void test_faculty_book() throws Exception {
        //Add a book to our resource list. Add a new due date and keep track
        // of it.
        collectionTest.addResource(test_book_1);
        test_book_1.setDueDate(test_date_2);
        Calendar testDateOld = test_date_2;

        //Construct a new Controller using the MemberList and Collection.
        Controller testControl = new Controller(memberListTest,
                collectionTest);

        testControl.checkout(facultyMemberTest.getMemberID(),
                test_book_1.getResourceID());

        //Try to change due date.
        Calendar test_date_3 = test_book_1.calculateNewDueDate(test_date_2, facultyMemberTest);

        //Books for faculty are checked out for 3 months.
        testDateOld.add(Calendar.MONTH, 3);

        //Test to make sure that the due date has been changed.
        assertEquals("The due date was not updated", testDateOld, test_date_3);
    }

    //Movies Test-cases
    /**
     *  Tests to calculate new due date for a student and movie.
     */
    @Test
    public void test_student_movie() throws Exception{
        //Add a movie to our resource list. Add a new due date and keep track
        //of it.
        collectionTest.addResource(test_movie);
        test_movie.setDueDate(test_date_2);
        Calendar testDateOld = test_date_2;

        //Construct a new Controller using the MemberList and Collection.
        Controller testControl = new Controller(memberListTest,
                collectionTest);
        testControl.checkout(studentMemberTest.getMemberID(),
                test_movie.getResourceID());

        //Try to change due date.
        Calendar test_date_3 = test_movie.calculateNewDueDate(test_date_2, studentMemberTest);

        //Movie for students are checked out for 7 days.
        testDateOld.add(Calendar.DATE, 7);

        //Test to make sure that the due date has been changed.
        assertEquals("The new date was not updated", testDateOld, test_date_3);
    }

    //Faculty
    /**
     *  Tests to calculate new dude date for a Faculty and movie.
     */
    @Test
    public void test_faculty_movie() throws Exception {
        //Add a movie to our resource list. Add a new due date and keep track
        // of it.
        collectionTest.addResource(test_movie);
        test_movie.setDueDate(test_date_2);
        Calendar testDateOld = test_date_2;

        //Construct a new Controller using the MemberList and Collection.
        Controller testControl = new Controller(memberListTest,
                collectionTest);
        testControl.checkout(facultyMemberTest.getMemberID(),
                test_movie.getResourceID());

        //Try to change due date.
        Calendar test_date_3 = test_movie.calculateNewDueDate(test_date_2, facultyMemberTest);

        //Movie for faculty are checked out for 7 days.
        testDateOld.add(Calendar.DATE, 7);

        //Test to make sure that the due date has been changed.
        assertEquals("The due date was not updated", testDateOld, test_date_3);
    }
}
