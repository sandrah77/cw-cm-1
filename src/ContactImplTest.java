import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 */
public class ContactImplTest {
    Contact contact1;
    Contact contact2;
    String name;
    String notes;
    int id;

    @Before
    public void initialiseConstructor() {
        name = "Stephen";
        notes = "Paging...";
        id = 42;

        contact1 = new ContactImpl(name, notes, id);
        contact2 = new ContactImpl(name, notes, id);
    }

    @Test
    public void testNameAccessor() {
        assertEquals(name, contact1.getName());
    }

    @Test
    public void testNotesAccessor() {
        assertEquals(notes, contact2.addNotes());
    }




}
