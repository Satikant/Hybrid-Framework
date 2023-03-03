package entities;

public class Subscriber extends User{

    private String mPin, tPin;

    @Override
    public void writeDataToExcel(User user) {
        System.out.println(user);


    }
}
