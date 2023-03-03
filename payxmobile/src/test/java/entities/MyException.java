package entities;

public class MyException extends RuntimeException{

    MyException(){
        super();
    }

    MyException(String msg){
        super(msg);
    }
}
