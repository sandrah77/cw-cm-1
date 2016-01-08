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
        Contact contact = new ContactImpl(0, "Bartholomew", "Calling..");
        assertEquals(0, contact.getId());
      //assertEquals("Stephen", contact1.getName());
      //assertEquals("Calling..", contact1.getNotes());
    }

    @Test
    public void testStringAccessor() {
        Contact contact2 = new ContactImpl(42, "Jude", "Let's drink wine and break bread");
        assertEquals(42, contact2.getName());
    }

   /* @Test
    public void testEmptyNotesAccessor() {
        Contact contact2 = new ContactImpl(42, "Andrew");
        assertEquals(42, contact2.getId());
        assertEquals("Stephen", contact2.getName());
        assertEquals("", contact2.getNotes());
    }

    @Test
    public void testNullNotesMutator() {
        Contact contact3 = new ContactImpl(1, "Judas", "Come hither");
        contact3.addNotes(null);
        assertEquals("Come hither", contact3.getNotes());
    }
    */
    /*
    @Test
    public void testIDAccessor() {
        ContactImpl contact2 = new ContactImpl(42);
        assertEquals(42, contact2.getId());
    */
}
