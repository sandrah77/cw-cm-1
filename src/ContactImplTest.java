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
    public void testNotesAccessor() {
        ContactImpl contact2 = new ContactImpl(42, "Stephen");
        assertEquals(42, contact2.getId());
        assertEquals("Stephen", contact2.getName());
        assertEquals("", contact2.getNotes());
    }
   /*
    @Test
    public void testIDAccessor() {
        ContactImpl contact2 = new ContactImpl(42);
        assertEquals(42, contact2.getId());
    */
}
