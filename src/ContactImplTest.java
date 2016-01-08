import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 */
public class ContactImplTest {


    @BeforeClass
    public static void runningNotification() {
        System.out.println ("Running tests...");
    }

    @Test
    public void testIdAccessor() {
        Contact testContact = new ContactImpl(0, "Bartholomew");
        assertEquals(0, testContact.getId());
      //assertEquals("Stephen", contact.getName());
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
        assertEquals(12, testContact.getId());
        assertEquals("John",testContact.getName());
        assertEquals("Do you have any cool tricks? Try turn that water into something else!\nSure..", testContact.getNotes());
    }

    @Ignore
    public void testEmptyNotesAccessor() {
        Contact contact2 = new ContactImpl(42, "Andrew");
        assertEquals(42, contact2.getId());
        assertEquals("", contact2.getName());
        assertEquals("", contact2.getNotes());
    }

    @Test
    public void testExceptionConstructorWithNullValues() {
        Contact contact = new ContactImpl(1, "Judas", null);
        assertEquals("Come hither", contact.getNotes());
    }

    /*
    @Test
    public void testIDAccessor() {
        ContactImpl contact2 = new ContactImpl(42);
        assertEquals(42, contact2.getId());
    */
}
