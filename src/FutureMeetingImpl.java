 /*
  * Created by Alexander on 24/12/2015.
  */
 import java.util.Calendar;
 import java.util.Set;


 public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
    /**
     * A class that implements the FutureMeeting interface
     *
     * @author sfarme01
     *
     */


     /**
     *Constructor
     *
     * @param Id the contact id
     * @param date the date of the meeting
     * @param contacts the list of people that attended the meeting
     *
     */

     public FutureMeetingImpl(int Id, Calendar date, Set<Contact> contacts) {
         super(Id, date, contacts);
     }
 }
