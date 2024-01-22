package messenger_app;

import java.util.ArrayList;
import java.util.Scanner;

public class contactManager extends contacts{
    private ArrayList<contacts> contactList; 

    contactManager(ArrayList<contacts> c){
        contactList = c;
    }

    public void printContacts(){
        if(contactList.isEmpty()){
            System.out.println("No Contacts in Contact List");
        }
        else{
            System.out.println("Name                                Phone Number");
            contactList.forEach((n)->System.out.println(n.getName()+"                           "+n.getPhoneNumber()));
        }
    }

    public void saveContact(String name,long ph_number){
        contactList.add(new contacts(name, ph_number));
        System.out.println("--- Contact Saved ---");
    }

    public void searchContact(String name){
        for(contacts c:contactList){
            if (c.getName().equals(name)){
                System.out.println("--- Contact Found ---");
                System.out.println(c.getName()+"                           "+c.getPhoneNumber());
            }
        }
    }

    public void deleteContact(String name){
        for(contacts c:contactList){
            if (c.getName().equals(name)){
                contactList.remove(c);
                System.out.println("--- Contact Deleted ---");
            }
        }
    }

    public int menu(int check){
        System.out.println("\nOptions:");
        System.out.println("1. Show all contacts\n2. Add new contact\n3. Search for a contact\n4. Delete a contact\n5. Go back to previous menu");
        Scanner cm_in = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = cm_in.nextInt();

        try{
            switch(choice) {
                case 1:
                    System.out.println("\nContact List:");
                    printContacts();
                    break;
                case 2:
                    System.out.println("Add new contact");
                    System.out.print("Enter Contact Name: ");
                    String f_name = cm_in.next();
                    String l_name = cm_in.next();
                    String contact_name = f_name+" "+l_name;
                    System.out.print("Enter contact number: ");
                    Long ph_number = Long.parseLong(cm_in.next());
                    saveContact(contact_name, ph_number);
                    break;
                case 3:
                    System.out.print("Enter Contact Name: ");
                    String search_f_name = cm_in.next();
                    String search_l_name = cm_in.next();
                    String search_contact_name = search_f_name+" "+search_l_name;
                    searchContact(search_contact_name);
                    break;
                case 4:
                    if(contactList.isEmpty()){
                        System.out.println("No Contacts in Contact List");
                    }
                    else{
                        System.out.print("Enter Contact Name: ");
                        String del_f_name = cm_in.next();
                        String del_l_name = cm_in.next();
                        String del_contact_name = del_f_name+" "+del_l_name;
                        deleteContact(del_contact_name);
                    }
                    break;
                case 5:
                    return 1;
                default:
                    break;
            }
        }
        catch(java.util.ConcurrentModificationException e1){
            System.out.println("");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
}
