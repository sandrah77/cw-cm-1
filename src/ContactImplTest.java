import org.junit.*;

import java.util.IllegalFormatCodePointException;

import static org.junit.Assert.*;


/**
 *
 */
public class ContactImplTest {

    // private Contact testContact;

    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running tests...");
    }

   /* @Before
   public void init() {
    // testContact = new ContactImpl();
   }
   */

   /* @After
    public void tearDown() {
        testContact = null;
    }
    */

    @Test
    public void testIdAccessor() {
        Contact testContact = new ContactImpl(2, "Bartholomew");
        assertEquals(2, testContact.getId());
        //assertEquals("Bartholomew", contact.getName());
        //assertEquals("Calling..", contact.getNotes());
    }

    @Test
    public void testNameAccessor() {
        Contact testContact = new ContactImpl(42, "Jude");
        assertEquals("Jude", testContact.getName());
    }

    @Test
    public void testNotesAccessor() {
        Contact testContact = new ContactImpl(42, "Jude", "I've brought lamb");
        assertEquals("I've brought lamb", testContact.getNotes());
    }

    @Test
    public void testAddNotesMutator() {
        Contact testContact = new ContactImpl(13, "Judas","Let's drink wine and break bread");
        testContact.addNotes("Let the final meal commence brethren..");
        assertEquals("Let's drink wine and break bread\nLet the final meal commence brethren..", testContact.getNotes());
    }

    @Test
    public void testExceptionConstructorWithAllParameters() {
        Contact testContact = new ContactImpl(12, "John", "Do you have any cool tricks? Try turn that water into something else!");
        testContact.addNotes("Sure..");
        // assertEquals(12, testContact.getId());
        // assertEquals("John",testContact.getName());
        assertEquals("Do you have any cool tricks? Try turn that water into something else!\nSure..", testContact.getNotes());
    }

    @Test
    public void testExceptionConstructorWithNotesAndNullNotes() {
        Contact contact = new ContactImpl(1, "Judas", "Come hither");
        contact.addNotes(null);
        contact.addNotes("We shall have a feast");
        contact.addNotes(null);
        assertEquals("Come hither\nWe shall have a feast", contact.getNotes());
    }

    @Ignore
    public void testExceptionConstructorNegativeIdAndEmptyNotes() {
        Contact contact = new ContactImpl(1, "Judas", "");
        contact.addNotes(null);
        // contact.addNotes("We shall have a feast");
        // assertNull(null, contact.getNotes());
        assertEquals(1, contact.getId());
    }

    @Test
    public void testSimilarObjectsCreated() {
        Contact contact = new ContactImpl(1, "Andrew", "");
        Contact contact2 = new ContactImpl(2, "Jude", "Hi everyone!");
        assertSame("The objects are the same", contact, contact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeIdValuesWithConstructor() {
        Contact contact = new ContactImpl(-5, "Andrew", "Shalom");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeIdValuesWithRestrictedConstructorToGeneral() {
        Contact contact = new ContactImpl(-5, "Andrew");
    }

    @Test(expected = NullPointerException.class)
    public void testNullNotesWithConstructor() {
        Contact contact = new ContactImpl(4, "Jesus" , null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameWithConstructor() {
        Contact contact = new ContactImpl(4, null, "Welcome to The Last Supper Apostles");
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameAndNullNotesWithConstructor() {
        Contact contact = new ContactImpl(3, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNegativeIdValuesWithNullNameAndNullNotesInConstructor() {
        Contact contact = new ContactImpl(-4, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAExceptionWithNegativeIdValuesWithNullNameAndNullNotesInConstructor() {
        Contact contact = new ContactImpl(-3,null, null);
    }
}
