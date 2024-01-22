package messenger_app;

public class contacts {
    private String name;
    private long phone_number;

    contacts(){}
    
    contacts(String name,long phone_number){
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName(){
        return this.name;
    }
    public long getPhoneNumber(){
        return this.phone_number;
    }
}
