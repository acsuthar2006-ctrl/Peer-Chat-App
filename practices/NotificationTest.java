interface Notification {
   void send(String message);
}
class BasicNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}
class EmailNotification implements Notification {
   public void send(String message) {
       System.out.println("Sending email notification: " + message);
   }
}
class SMSNotification implements Notification {
   public void send(String message) {
       System.out.println("Sending SMS notification: " + message);
   }
}
abstract class NotificationDecorator implements Notification {
   protected Notification decoratedNotification;

   public NotificationDecorator(Notification notification) {
       this.decoratedNotification = notification;
   }

   @Override
   public void send(String message) {
       decoratedNotification.send(message);
   }
}
class EmailDecorator extends NotificationDecorator {
   public EmailDecorator(Notification notification) {
       super(notification);
   }

   @Override
   public void send(String message) {
       super.send(message);
       System.out.println("Also sending email notification: " + message);
   }
}
class SMSDecorator extends NotificationDecorator {
   public SMSDecorator(Notification notification) {
       super(notification);
   }

   @Override
   public void send(String message) {
       super.send(message);
       System.out.println("Also sending SMS notification: " + message);
   }
}

public class NotificationTest {
   public static void main(String[] args) {
       Notification notification = new EmailDecorator(new SMSDecorator(new BasicNotification()));
       notification.send("Hello World!");

   }
}
