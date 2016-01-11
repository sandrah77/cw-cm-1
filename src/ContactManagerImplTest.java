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
        Contact testContact = new ContactImpl(2, "Bartholomew");
        assertEquals(2, cm.getId());
        //assertEquals("Bartholomew", contact.getName());
    }

}
