package messenger_app;

import java.util.ArrayList;
import java.util.Scanner;

public class messageManager extends messages{
    private ArrayList<messages> messageList;
    private ArrayList<contacts> contactList; 
    private String username;

    messageManager(String u_name,ArrayList<messages> m,ArrayList<contacts> c){
        messageList = m;
        contactList = c;
        username = u_name;
    }

    public void printMessages(){
        if(messageList.isEmpty()){
            System.out.println("No Messeges in Message List");
        }
        else{
            System.out.println("From                To                      Body");
            messageList.forEach((n)->System.out.println(n.getFrom()+"          "+n.getTo()+"            "+n.getBody()));
        }
    }

    public void sendMessage(String from,String to,String body){
        int flg=0;
        for(contacts c:contactList){
            if(c.getName().equals(to)){
                flg = 1;
            }
        }
        if(flg==1){
            messageList.add(new messages(from, to, body));
            System.out.println("--- Message Sent ---");
        }
        else{
            System.out.println("--- Contact Not Found ---");
        }
    }

    public int menu(int check){
        System.out.println("\nOptions:");
        System.out.println("1. See the list of all messages\n2. Send a new message\n3. Go back to previous menu");
        Scanner mm_in = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = mm_in.nextInt();

        try{
            switch (choice) {
                case 1:
                    System.out.println("--- Messages ---");
                    printMessages();
                    break;
                case 2:   
                    System.out.print("Enter Reciever Name: ");
                    String r_f_name = mm_in.next();
                    String r_l_name = mm_in.next();
                    String reciever_name = r_f_name+" "+r_l_name;
                    System.out.print("Enter message body: ");
                    String start = mm_in.next();
                    String rest = mm_in.nextLine();
                    String mess_body = start+rest;
                    sendMessage(username, reciever_name, mess_body);
                    break;
                case 3:
                    return 1;
                default:
                    break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
}
