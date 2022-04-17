package messenger;

public class ConsoleMessenger implements Messenger {
    @Override
    public boolean sendMessage(String message) {
        System.out.println(message);
        return true;
    }
}
