package messenger_app;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<contacts> contactList = new ArrayList<>(); 
    private static ArrayList<messages> messageList = new ArrayList<>(); 
    private static String username;

    public static void menu(){
        while(true){   
            System.out.println("\n\n-- Welcome to Messenger --\nChoose action below:");
            System.out.println("1. Manage Contacts    2. Messages    3. Quit");
            System.out.print("Enter choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
        
            try{    
                switch(choice){
                    case 1:
                        contactManager cm = new contactManager(contactList);
                        int cm_check = 0;
                        while(cm_check==0){
                            cm_check=cm.menu(0);
                        }
                        break;
                    case 2:
                        messageManager mm = new messageManager(username,messageList,contactList);
                        int mm_check = 0;
                        while(mm_check==0){
                            mm_check=mm.menu(0);
                        }
                        break;
                    case 3:
                        System.out.println("...Quitting Application...");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Wrong Choice...");
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        if(username == null){
            System.out.print("Enter username: ");
            Scanner sc = new Scanner(System.in);
            String u_f_name = sc.next();
            String u_l_name = sc.next();
            username = u_f_name+" "+u_l_name;
        }
        try{
            menu();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
}
