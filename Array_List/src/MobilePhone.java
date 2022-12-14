import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts ;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }
    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName())>=0){
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public void printContacts(){
        for (int i = 0;i<myContacts.size();i++){
            System.out.println((i+1)+"."+
                    this.myContacts.get(i).getName()+"->"+
                    this.myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact)>= 0) {
            this.myContacts.remove(findContact(contact));
            return true;
        }
        else {
            System.out.println("Contact does not exist");
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int fondPosition = findContact(oldContact);
        if(fondPosition <0){
            System.out.println(oldContact.getName()+" ,was not exist");
            return false;
        }
        this.myContacts.set(fondPosition,newContact);
        System.out.println(oldContact.getName()+" ,was replaced with "+newContact.getName()+" has been updated");
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if (findContact(contact)>= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }
}
