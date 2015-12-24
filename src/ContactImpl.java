/**
 * Created by Alexander on 24/12/2015.
 * This class implements the Contact interface
 */
public class ContactImpl {
    private int id;
    private String name;
    private String notes;

    /**
     * Default constructor with the id provided by the contact manager,
     * which includes the corresponding name and notes.
     */
    ContactImpl(){
        this.id = 0;
        this.name = "";
        notes = "";
    }

    /**
     * Another more restricted constructor which take only two parameters (ID and name)
     *
     * If the ID provided is zero or negative, an IllegalArgumentException will be thrown.
     *
     * If any of the references/pointers passed as parameters to the constructor are null,
     * a NullPointerException will be thrown.
     * @param id the contact id
     * @param name the contact name
     */
    ContactImpl(int id, String name){
        this.id = id;
        this.name = name;
        notes = "";

    }


}
