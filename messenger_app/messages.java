package messenger_app;

public class messages {
    private String from,to,body;

    messages(){}

    messages(String sender_name,String reciever_name,String mess_body){
        this.from = sender_name;
        this.to = reciever_name;
        this.body = mess_body;
    }

    public String getFrom(){
        return this.from;
    }
    public String getTo(){
        return this.to;
    }
    public String getBody(){
        return this.body;
    }
    
}
