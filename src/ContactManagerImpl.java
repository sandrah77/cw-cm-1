/**
 * Created by Alexander on 24/12/2015.
 */
import javax.naming.CompositeName;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;


/**
 * A class that implements ContactManager
 *
 * @author sfarme01
 */

public class ContactManagerImpl implements ContactManager {
    private List<Meeting> meetings;
    private Set<Contact> contacts;
    static int nextMeetingId = 0;
    static int nextContactId = 0;
    static String FILENAME = "contacts.txt";

    /**
     * A class used to implement Comparator
     * Used for comparing meeting dates
     */
    class MeetingDateComparator implements Comparator<Meeting> {
        /**
         * Using the compare method implemented for sorting meetings Chronologically
         *
         * @param meeting1 compare meeting1
         * @param meeting2 compare meeting2
         * @return if meeting1 is  before meeting2 return 1 else return -1
         */
        public int compare(Meeting meeting1, Meeting meeting2) {
            if (meeting1.getDate().before(meeting2.getDate())) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public ContactManagerImpl() {
        try {
            FileInputStream fin = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fin);
            meetings = (List<Meeting>) ois.readObject();
            contacts = (Set<Contact>) ois.readObject();
            for (Contact contact : contacts) {
                nextContactId = (contact.getId() > nextContactId) ? contact.getId() : nextContactId;
            }
            for (Meeting meeting : meetings) {
                nextMeetingId = (meeting.getId() > nextMeetingId) ? meeting.getId() : nextMeetingId;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile \"" + FILENAME + "\" not found. \n" + e);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Add a new meeting to be held in the future.
     * <p/>
     * An ID is returned when the meeting is put into the system. This
     * ID must be positive and non-zero.
     *
     * @param contacts a list of contacts that will participate in the meeting
     * @param date     the date on which the meeting will take place
     * @return Id the ID for the meeting
     * @throws IllegalArgumentException if the meeting is set for a time
     *                                  in the past, of if any contact is unknown / non-existent.
     * @throws NullPointerException     if the meeting or the date are null
     */

    public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
        Calendar today = Calendar.getInstance();
        if (date.before(today)) {
            throw new IllegalArgumentException("Argument \"date\" is not a future date.");
        }
        if (contacts.isEmpty()) {
            throw new IllegalArgumentException("Argument \"contacts\" list is empty.");
        }
        if (contacts.contains(null)) {
            throw new IllegalArgumentException("List argument \"contacts\" contains one or more unknown/null contacts.");
        }
        int id = ++nextMeetingId;
        MeetingImpl m = new FutureMeetingImpl(id, date, contacts);
        meetings.add(m);
        return id;
    }

    /**
     * Returns the PAST meeting with the requested ID, or null if it there is none.
     * <p/>
     * The meeting must have happened at a past date.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     * @throws IllegalStateException if there is a meeting with that ID happening
     *                               in the future
     */
    public PastMeeting getPastMeeting(int id) {
        return null;
    }

    /**
     * Returns the FUTURE meeting with the requested ID, or null if there is none.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     * @throws IllegalArgumentException if there is a meeting with that ID happening
     *                                  in the past
     */

    public FutureMeeting getFutureMeeting(int id) {
        return null;
    }


    /**
     * Returns the meeting with the requested ID, or null if it there is none.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     */

    public Meeting getMeeting(int id){
        return null;
    }

    /**
     * Returns the list of future meetings scheduled with this contact.
     *
     * If there are none, the returned list will be empty. Otherwise,
     * the list will be chronologically sorted and will not contain any duplicates.
     *
     * @param contact one of the users contacts
     * @return the list of future meeting(s) scheduled with this contact (maybe empty).
     * @throws IllegalArgumentException if the contact does not exist
     * @throws NullPointerException     if the contact is null
     */
    public List<Meeting> getFutureMeetingList(Contact contact) {
        return null;
    }

    /**
     * Returns the list of meetings that are scheduled for, or that took
     * place on, the specified date
     *
     * If there are none, the returned list will be empty. Otherwise,
     * the list will be chronologically sorted and will not contain any
     * duplicates.
     *
     * @param date the date
     * @return the list of meetings
     * @throws NullPointerException if the date are null
     */
    public List<Meeting> getMeetingListOn(Calendar date) {
        return null;
    }

    /**
     * Returns the list of past meetings in which this contact has participated.
     * If there are none, the returned list will be empty. Otherwise,
     * the list will be chronologically sorted and will not contain any duplicates.
     *
     * @param contact one of the users contacts
     * @return the list of future meeting(s) scheduled with this contact (maybe empty).
     * @throws IllegalArgumentException if the contact does not exist
     * @throws NullPointerException     if the contact is null
     */
    public List<PastMeeting> getPastMeetingListFor(Contact contact) {
        return null;
    }

    /**
     * Create a new record for a meeting that took place in the past.
     *
     * @param contacts a list of participants
     * @param date the date on which the meeting took place
     * @param text messages to be added about the meeting.
     * @throws IllegalArgumentException if the list of contacts is empty, or any of the contacts does not exist
     * @throws NullPointerException if any of the Strings are invalid.
     */
    public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
        Calendar today = Calendar.getInstance();
        if(contacts == null) {
            throw new NullPointerException("Argument: contact is null.");
        }
        if(date == null) {
            throw new NullPointerException("Argument: date is null");
        }
        if(text == null){
            throw new NullPointerException("Argument: text is null");
        }
        if(date.after(today)){
            throw new IllegalArgumentException("Argument: date is a future date");
        }
        if(contacts.isEmpty()){
            throw new IllegalArgumentException("Argument: contact is empty.");
        }
        int id = ++nextMeetingId;
        PastMeetingImpl m = new PastMeetingImpl(id, date, contacts, text);
        meetings.add(m);
    }

    /**
     * Add notes to a meeting.
     * <p/>
     * This method is used when a future meeting takes place, and is
     * then converted to a past meeting (with notes) and returned.
     * <p/>
     * It can be also used to add notes to a past meeting at a later date.
     *
     * @param id   the ID of the meeting
     * @param text messages to be added about the meeting.
     * @throws IllegalArgumentException if the meeting does not exist
     * @throws IllegalStateException    if the meeting is set for a date in the future
     * @throws NullPointerException     if the notes are null
     */
    public PastMeeting addMeetingNotes(int id, String text) {
        if (text == null) {
            throw new NullPointerException("Argument text cannot be null");
        }
        Meeting m = null;
        boolean found = false;
        for (Meeting meeting : meetings) {
            if (meeting.getId() == id) {
                m = meeting;
                found = true;
                break;
            }
        }
        PastMeetingImpl pastMeeting;
        if (found) {
            if (m.getDate().after(Calendar.getInstance())) {
                throw new IllegalStateException("This meeting is set for a future date");
            }
            String t = "";
            if (m instanceof PastMeetingImpl) {
                t = ((PastMeetingImpl) m).getNotes();
            }
            meetings.remove(m);
            pastMeeting = new PastMeetingImpl(m.getId(), m.getDate(), m.getContacts(), t + " " + text);
            meetings.add(pastMeeting);
        } else {
            throw new IllegalArgumentException("Invalid meeting ID: " + id);
        }
        return pastMeeting;
    }


    /**
     * Create a new contact with the specified name and notes.
     *
     * @param name  the name of the contact.
     * @param notes notes to be added about the contact.
     * @return the ID for the new contact
     * @throws IllegalArgumentException if the name or the notes are empty strings
     * @throws NullPointerException     if the name or the notes are null
     */
    public int addNewContact(String name, String notes) {
        if (name == null || notes == null) {
            throw new NullPointerException("Name and notes cannot be null.");
        }
        if (name.equals("") || notes.equals("")) {
            throw new NullPointerException("Please type a valid string");
        }
        int id = ++nextContactId;
        ContactImpl contact = new ContactImpl(id, name);
        contact.addNotes(notes);
        contacts.add(contact);
        return id;
    }

    /**
     * Returns a list with the contacts whose name contains that string.
     *
     * If the string is the empty string, this methods returns the set
     * that contains all current contacts.
     *
     * @param name the string to search for
     * @return a list with the contacts whose name contains that string.
     * @throws NullPointerException if the parameter is null
     */
    public Set<Contact> getContacts(String name) {
        if(name == null) {
            throw new NullPointerException("Argument \"name\" cannot be null.");
        }
        Set<Contact> contactsSubList = new HashSet<Contact>();
        for(Contact contact : contacts) {
            if(contact.getName().equals(name)) {
                contactsSubList.add(contact);
            }
        }
        return contactsSubList;
    }

    /**
     * Returns a list containing the contacts that correspond to the IDs.
     * Note that this method can be used to retrieve just one contact by passing only one ID.
     *
     * @param ids an arbitrary number of contact IDs
     * @return a list containing the contacts that correspond to the IDs.
     * @throws IllegalArgumentException if no IDs are provided or if
     *                                  any of the provided IDs does not correspond to a real contact
     */
    public Set<Contact> getContacts(int... ids) {
        Set<Contact> contactsSubList = new HashSet<Contact>();
        boolean found = false;
        for(int id: ids){
            found = false;
            for(Contact contact : contacts){
                if(contact.getId() == id){
                    contactsSubList.add(contact);
                    found = true;
                    break;
                }
            }
            if(!found) throw new IllegalArgumentException("Invalid contact ID: " + id);
        }
        return contactsSubList;
    }

    /**
     * Save all data to disk.
     *
     * This method must be executed when the program is
     * closed and when/if the user requests it.
     */
    public void flush() {
        try {
            FileOutputStream fout = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(meetings);
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Datafile: \"" + FILENAME + "\" not found.\n" + e);
        }
    }
}


