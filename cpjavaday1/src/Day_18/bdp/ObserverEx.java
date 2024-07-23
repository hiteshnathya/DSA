package Day_18.bdp;

import java.util.ArrayList;
import java.util.List;

// Define the Subject interface
interface Subject{
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Message m);
}

// Define the Observer interface
interface Observer
{
    public void Update(Message m);
}

// Define the Message class
class Message
{
    String messagecontent;
    public Message(String messagecontent)
    {
        this.messagecontent=messagecontent;
    }
    public String getMessagecontent()
    {
        return messagecontent;
    }
}

// Implement the MessagePublisher class
class  MessagePublisher implements Subject
{
    private List<Observer> l1=new ArrayList<>();
    public void attach(Observer o){
        l1.add(o);
    }
    public void detach(Observer o){
        l1.remove(o);
    }

    public void notifyUpdate(Message m){
        for (Observer ob:l1)
            ob.Update(m);
    }
}

// Implement the MessageSubscriber1 class
class MessageSubscriber1 implements Observer{
    public  void Update(Message o){
        System.out.println(" Message Subscriber 1 :" + o.getMessagecontent());
    }
}

// Implement the MessageSubscriber2 class
class MessageSubscriber2 implements Observer{
    public  void Update(Message o){
        System.out.println(" Message Subscriber 2 :" + o.getMessagecontent());
    }
}

// Implement the MessageSubscriber3 class
class MessageSubscriber3 implements Observer{
    public  void Update(Message o){
        System.out.println(" Message Subscriber 3 :" + o.getMessagecontent());
    }
}

public class ObserverEx {
    public static void main(String[] args) {

        // Create instances of MessageSubscriber classes
        MessageSubscriber1  s1=new MessageSubscriber1();
        MessageSubscriber2  s2=new MessageSubscriber2();
        MessageSubscriber3  s3=new MessageSubscriber3();

        // Create an instance of MessagePublisher
        MessagePublisher p=new MessagePublisher();

        // Attach subscribers to the publisher
        p.attach(s1);
        p.attach(s2);

        // Notify subscribers with the first message
        p.notifyUpdate(new Message("This is First message "));

        // Attach another subscriber and detach one subscriber
        p.attach(s3);
        p.detach(s1);

        // Notify subscribers with the second message
        p.notifyUpdate(new Message("This is Second message "));

    }
}