import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 */
public class ContactImplTest {


    /* @Before
    public void initialiseConstructor() {
        name = "Stephen";
        notes = "Paging...";
        id = 42;

        contact1 = new ContactImpl(name, notes, id);
        contact2 = new ContactImpl(name, notes, id);
    */

    @Test
    public void testNameAccessor() {
        ContactImpl contact1 = new ContactImpl(42, "Stephen", "Calling..");
        assertEquals(3, contact1.getId());
        assertEquals("Stephen", contact1.getName());
        assertEquals("Calling..", contact1.getNotes());
    }

    @Test
    public void testNotesAccessor(String notes) {
        ContactImpl contact2 = new ContactImpl("Calling..");
        assertEquals(notes, contact2.getNotes());
    }

    @Test
    public void testIDAccessor() {
        assertEquals(notes, contact2.getId());
    }
}
