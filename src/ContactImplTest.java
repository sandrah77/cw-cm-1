import org.junit.*;
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
        Contact testContact = new ContactImpl(0, "Bartholomew");
        assertEquals(0, testContact.getId());
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
        Contact testContact = new ContactImpl(42, "Jude");
        assertEquals("Let's drink wine and break bread", testContact.getNotes());
    }

    @Test
    public void testAddNotesMutator() {
        Contact testContact = new ContactImpl(13, "Judas");
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

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeIdValuesWithConstructor() {
        Contact contact = new ContactImpl(-5, "Andrew", "Shalom");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeIdValuesWithRestrictedConstructor() {
        Contact contact = new ContactImpl(-5, "Andrew");
    }
}
