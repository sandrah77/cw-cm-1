import org.junit.BeforeClass;

import java.util.*;
import java.util.Set;
import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

/**
 * Created by Alexander on 08/01/2016.
 */
public class ContactManagerImplTest {
    private Contact cm;
    private Calendar futureDate;
    private Calendar pastDate;
    private Set<Contact> contacts;
    private static final String FILENAME = "contacts.txt";

    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running ContactManager tests...");
    }

    @Before
    public void init() {
        cm = new ContactImpl(1,"James, the elder", "Welcome");
        cm = new ContactImpl(2, "Simon", "Welcome" );
        cm = new ContactImpl(3, "John", "Welcome" );
        cm = new ContactImpl(4, "James", "Welcome" );
        cm = new ContactImpl(5, "Andrew", "Welcome" );
        cm = new ContactImpl(6, "Nathanael", "Welcome" );
        cm = new ContactImpl(7, "Thomas", "Welcome" );
        cm = new ContactImpl(8, "Matthew", "Welcome" );
        cm = new ContactImpl(9, "James, the younger", "Welcome" );
        cm = new ContactImpl(10, "Jude", "Welcome" );
        cm = new ContactImpl(11, "Simon", "Welcome" );
        cm = new ContactImpl(12, "Judas", "Welcome" );

    }

    @After
    public void tearDown() {
        File contactsFile = new File(FILENAME);
        try {
            if (contactsFile.exists()) {
                    contactsFile.delete();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestConstructorContactParameters() {
        cm = new ContactImpl(2,"James, the elder", "Welcome");
        assertEquals(2, cm.getId());
    }

    @Test
    public void testIdAccessor() {
        cm = new ContactImpl(2, "Bartholomew");
        assertEquals(2, cm.getId());
        //assertEquals("Bartholomew", cm.getName());
    }

    @Test
    public void testNameAccessor() {
        cm = new ContactImpl(42, "Jude");
        assertEquals("Jude", cm.getName());
    }

    @Test
    public void testNotesAccessor() {
        cm = new ContactImpl(42, "Jude", "I've brought lamb");
        assertEquals("I've brought lamb", cm.getNotes());
    }

    @Test
    public void testAddNotesMutator() {
        cm = new ContactImpl(13, "Judas","Let's drink wine and break bread");
        cm.addNotes("Let the final meal commence brethren..");
        assertEquals("Let's drink wine and break bread\nLet the final meal commence brethren..", cm.getNotes());
    }

    @Test
    public void testMultipleContactIds() {
        cm = new ContactImpl(1,"James, the elder", "Hi");
        assertEquals(1, cm.getId());
        cm = new ContactImpl(2,"Simon", "Hi");
        assertEquals(2, cm.getId());
        cm = new ContactImpl(3,"John", "Hi");
        assertEquals(3, cm.getId());
    }

    @Test
    public void testExceptionConstructorWithAllParameters() {
        cm = new ContactImpl(1, "John", "Do you have any cool tricks? Try turn that water into something else!");
        cm.addNotes("Sure..");
        // assertEquals(12, testContact.getId());
        // assertEquals("John",testContact.getName());
        assertEquals("Do you have any cool tricks? Try turn that water into something else!\nSure..", cm.getNotes());
    }

    @Test
    public void testExceptionConstructorWithNotesAndNullNotes() {
        cm = new ContactImpl(1, "Judas", "Come hither");
        cm.addNotes(null);
        cm.addNotes(null);
        cm.addNotes(null);
        assertEquals("Come hither\nWe shall have a feast", cm.getNotes());
    }

}
