import java.util.*;

 // @Author sfarme01

public class ContactManagerImplTester {
    public static void main(String[] args) {

        Set<Contact> contacts = new HashSet();
        //ContactImpl c1 = new ContactImpl(1, "James");
        //ContactImpl c2 = new ContactImpl(2, "Philip");
        //ContactImpl c3 = new ContactImpl(3, "Judas");;
        //contacts.add(c1);
        //contacts.add(c2);
        //contacts.add(c3);

        ContactManagerImpl contactManager = new ContactManagerImpl();

		/*
		contactManager.addNewContact("James", "James has agreed to attend the feast");
		contactManager.addNewContact("Philip", "Philip has agreed to meet us in next the week.");
		contactManager.addNewContact("Jude", "Jude is comming tomorrow.");
		contactManager.addNewContact("Andrew", "Andrew switched off his ancient blackberry. ");
		contactManager.addNewContact("Philip", "Philip is not interested in meeting");
		contactManager.addNewContact("Philip", "Philip is back with us.");
		contactManager.addNewContact("Matthew", "Matthew has left us.");
		*/
        //contactManager.addNewContact("Matthew", null); //throws NullPointerException

		/*
		String name = null;
		System.out.println("----------- CONTACTS ------------");
		for(Contact contact: contactManager.getContacts(name))
			System.out.println("ID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes());
		*/


        System.out.println("----------- CONTACTS ------------");
        for(Contact contact: contactManager.getContacts(1,2,3,4,5,6,7))
            System.out.println("ID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes());



		/*
		int id = contactManager.addFutureMeeting(contactManager.getContacts(1,2,3), new GregorianCalendar(2015, 0, 8));
		id = contactManager.addFutureMeeting(contactManager.getContacts(4,5,3,6), new GregorianCalendar(2015, 0, 23));
		id = contactManager.addFutureMeeting(contactManager.getContacts(2,5), new GregorianCalendar(2015, 0, 30));
		id = contactManager.addFutureMeeting(contactManager.getContacts(3,4,5), new GregorianCalendar(2015, 0, 12));
		*/
        //contactManager.addFutureMeeting(contacts, new GregorianCalendar(2019, 0, 9));


        // to test this, first set the system date of the machine to a future meetings date
        //contactManager.addMeetingNotes(1, null); //throws NullPointerException
        //contactManager.addMeetingNotes(4, "The meeting is over. "); //throws IllegalStateException since meeting date is a future date
        //contactManager.addMeetingNotes(0, "Something. "); //throws IllegalStateException
        //contactManager.addMeetingNotes(1, "The meeting is over. ");
        //contactManager.addMeetingNotes(1, "It was decided to start the meeting in Feb 2015. ");
        //contactManager.addMeetingNotes(5, "It was decided to outsource some followers. ");

        //contactManager.addFutureMeeting(contactManager.getContacts(3,1), new GregorianCalendar(2016, 1, 4));
        //contactManager.addFutureMeeting(contactManager.getContacts(4), new GregorianCalendar(2015, 3, 12));
        //contactManager.addFutureMeeting(contactManager.getContacts(1,4), new GregorianCalendar(2014, 7, 21));


        //contactManager.addNewPastMeeting(contactManager.getContacts(9), new GregorianCalendar(2013, 8, 15), "This meeting had some concrete outcome. ");
        //contactManager.addNewPastMeeting(contacts, new GregorianCalendar(2013, 8, 15), "This meeting had some concrete outcome. ");

		/*
		System.out.println("------------ ALL MEETINGS ----------------");
		for(Meeting meeting: contactManager.meetings){//this is working since meetings is now made public
			System.out.println("ID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
			System.out.println("\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: meeting.getContacts())
				System.out.println("\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}*/

		/*
		System.out.println("------------ MEETING FOR A GIVEN MEETING ID  ----------------");
		Meeting meeting = contactManager.getMeeting(9);
		if(meeting != null){
			System.out.println("ID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
			System.out.println("\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: meeting.getContacts())
				System.out.println("\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		else{
			System.out.println("\tNot found.");
		}
		*/

		/*
		System.out.println("------------ PAST MEETING FOR A GIVEN MEETING ID  ----------------");
		PastMeeting meeting = contactManager.getPastMeeting(5);
		if(meeting != null){
			System.out.println("ID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
			System.out.println("Note: " + ((PastMeetingImpl)meeting).getNotes());
			System.out.println("\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: meeting.getContacts())
				System.out.println("\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		else{
			System.out.println("\tNot found.");
		}
		*/

		/*
		System.out.println("------------ PAST MEETINGS ----------------");
		for(Contact c: contactManager.getContacts(1, 2)){
			System.out.println("Meetings for contactID = " + c.getId());
			List<PastMeeting> meetings = contactManager.getPastMeetingList(c);
			for(Meeting meeting: meetings){
				System.out.println("\tID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
				System.out.println("\tNote: " + ((PastMeetingImpl)meeting).getNotes());
				System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
				for(Contact contact: meeting.getContacts())
					System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
			}
		}
		*/
		/*
		System.out.println("------------ PAST MEETINGS ----------------");
		List<PastMeeting> ms = contactManager.getPastMeetingList(c1);
		for(Meeting m: ms){
			System.out.println("\tID: " + m.getId() + "\tDate: " + (m.getDate().get(Calendar.MONTH) + 1 ) + "-" + m.getDate().get(Calendar.DAY_OF_MONTH) + "-" + m.getDate().get(Calendar.YEAR));
		//	System.out.println("Note: " + ((PastMeetingImpl)meeting).getNotes());
			System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: m.getContacts())
				System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		*/


		/*
		System.out.println("------------ A PAST MEETING ----------------");
		PastMeeting pm = contactManager.getPastMeeting(1);
		if(! (pm==null) ){
			System.out.println("\tID: " + pm.getId() + "\tDate: " + (pm.getDate().get(Calendar.MONTH) + 1 ) + "-" + pm.getDate().get(Calendar.DAY_OF_MONTH) + "-" + pm.getDate().get(Calendar.YEAR));
			System.out.println("\tNote: " + pm.getNotes());
			System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: pm.getContacts())
				System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		*/
		/*
		System.out.println("------------ A FUTURE MEETING ----------------");
		FutureMeeting fm = contactManager.getFutureMeeting(4);
		if(! (fm==null) ){
			System.out.println("\tID: " + fm.getId() + "\tDate: " + (fm.getDate().get(Calendar.MONTH) + 1 ) + "-" + fm.getDate().get(Calendar.DAY_OF_MONTH) + "-" + fm.getDate().get(Calendar.YEAR));
			//System.out.println("\tNote: " + fm.getNotes());
			System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: fm.getContacts())
				System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		*/

		/*
		System.out.println("------------ ALL FUTURE MEETINGS FOR A CONTACT ----------------");
		int id = 8;
		Set<Contact> cs = contactManager.getContacts(id);
		if(!cs.isEmpty()){
			for(Contact c: cs){
				System.out.println("ContactID: " + c.getId());
				List<Meeting> ms = contactManager.getFutureMeetingList(c);
				for(Meeting m: ms){
					System.out.println("\tID: " + m.getId() + "\tDate: " + (m.getDate().get(Calendar.MONTH) + 1 ) + "-" + m.getDate().get(Calendar.DAY_OF_MONTH) + "-" + m.getDate().get(Calendar.YEAR));
					//System.out.println("\tNote: " + fm.getNotes());
					System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
					for(Contact contact: m.getContacts())
						System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
				}
			}
		}else{
			System.out.println("\tThe contact with ID: " + id + " is not assigned any future meetings." );
		}
		*/

		/*
		System.out.println("------------ ALL FUTURE MEETINGS FOR A DATE ----------------");
		Calendar cal = new GregorianCalendar(2015, 0, 29);
		List<Meeting> ms = contactManager.getFutureMeetingList(cal);
		if(!ms.isEmpty()){
			for(Meeting m: ms){
				System.out.println("\tID: " + m.getId() + "\tDate: " + (m.getDate().get(Calendar.MONTH) + 1 ) + "-" + m.getDate().get(Calendar.DAY_OF_MONTH) + "-" + m.getDate().get(Calendar.YEAR));
				//System.out.println("\tNote: " + fm.getNotes());
				System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
				for(Contact contact: m.getContacts())
					System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
			}
		}else{
			System.out.println("\tEmpty List");
		}
		*/



		/*
		System.out.println("------------ FUTURE MEETINGS ----------------");
		FutureMeeting meeting = contactManager.getFutureMeeting(1);
		if(meeting != null){
			System.out.println("ID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
		//	System.out.println("Note: " + ((PastMeetingImpl)meeting).getNotes());
			System.out.println("\t------------ CONTACTS FOR MEETINGS ----------------");
			for(Contact contact: meeting.getContacts())
				System.out.println("\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
		}
		else{
			System.out.println("\tEmpty");
		}
		*/


       /* System.out.println("------------ ALL PAST MEETINGS FOR A CONTACT ----------------");
        int id = 1;
        Set<Contact> cs = contactManager.getContacts(id);
        if(!cs.isEmpty()){
            for(Contact c: cs){
                System.out.println("ContactID: " + c.getId());
                List<PastMeeting> ms = (List<PastMeeting>) contactManager.getPastMeeting(c);
                if(!ms.isEmpty()){
                    for(PastMeeting m: ms){
                        System.out.println("\tID: " + m.getId() + "\tDate: " + (m.getDate().get(Calendar.MONTH) + 1 ) + "-" + m.getDate().get(Calendar.DAY_OF_MONTH) + "-" + m.getDate().get(Calendar.YEAR));
                        System.out.println("\tNote: " + m.getNotes());
                        System.out.println("\t\t------------ CONTACTS FOR MEETINGS ----------------");
                        for(Contact contact: m.getContacts())
                            System.out.println("\t\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
                    }
                }else{
                    System.out.println("\tThe contact with ID: " + id + " is not assigned any past meetings." );
                }
            }
        }else{
            throw new IllegalArgumentException("Contact with ID: " + id + " does not exist.");
        }
        */

		/*
		for(Contact c: contactManager.getContacts(1)){
			for(Meeting meeting: contactManager.getFutureMeetingList(c)){
				System.out.println("ID: " + meeting.getId() + "\tDate: " + (meeting.getDate().get(Calendar.MONTH) + 1 ) + "-" + meeting.getDate().get(Calendar.DAY_OF_MONTH) + "-" + meeting.getDate().get(Calendar.YEAR));
				System.out.println("Note: " + ((PastMeetingImpl)meeting).getNotes());
				System.out.println("\t------------ CONTACTS FOR MEETINGS ----------------");
				for(Contact contact: meeting.getContacts())
					System.out.println("\tID: " + contact.getId() + "\tName: " + contact.getName() + "\tNotes: " + contact.getNotes() );
			}
		}*/

        contactManager.flush();
    }
}