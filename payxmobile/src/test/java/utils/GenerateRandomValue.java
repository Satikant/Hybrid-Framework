package utils;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.Random;

import static utils.DataDriven.getListOfMsisdn;
import static utils.DataDriven.getUserPin3ByStatus;


/**
 * Created by ayush.singh on 11-12-2019.
 */
public class GenerateRandomValue {

    static int reference,i,numb,j,len;
    static String refer;
    static String new_confirm_pin;
    static ArrayList<String> name = new ArrayList<String>();
    static ArrayList<String> msisdn = new ArrayList<String>();

    public static ArrayList<String> getGroupOfMemberMsisdn(int noOfPeople, int lenOfMsisdn){
        msisdn.clear();
        for(int i=1;i<=noOfPeople;i++){
            msisdn.add(String.valueOf(getRandomIntValue(lenOfMsisdn)));
            //System.out.println("ADD : " +msisdn);
        }

        for(int k=0 ; k< getListOfMsisdn("Y").size(); k++){
            name.remove(k);
        }

        name.addAll(getListOfMsisdn("SP"));
        return name;
    }

    public static ArrayList<String> getGroupOfMemberName(int noOfPeople, int lenOfName){
        name.clear();
        for(i=1;i<=noOfPeople;i++){
            name.add(getRandomAlphabeticValue(lenOfName));
        }
        return name;
    }



    public static String getRandomIntValue(int len) {
         refer = "";
        Random randomno = new Random();
        try{
            for ( i = 1; i <= len; i++) {
                reference = randomno.nextInt(9);
                refer += reference;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return refer;
    }


    public static String getNewPin(String new_confirm_pin,int length){
        try {
            if(new_confirm_pin.equals(DataDriven.getUserPinByStatus("Y"))|| new_confirm_pin.equals(DataDriven.getUserPin2ByStatus("Y")) || new_confirm_pin.equals(getUserPin3ByStatus("Y"))){
                new_confirm_pin=getNewPin(getDistinctNumber(getRandomIntValue(length),length),length);
                System.out.println("return new_confirm_pin  "+new_confirm_pin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new_confirm_pin;
    }

       public static String getDistinctNumber(String number ,int length){
         numb=number.length();
        try{
            for( i=0;i<numb;i++){
                for( j=i;j<numb-1;j++){
                    if(number.charAt(i)==number.charAt(j+1)){
                        number=getDistinctNumber(getRandomIntValue(length),length);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            return number;
    }

    public static void main(String[] args){
         System.out.println(getGroupOfMemberMsisdn(2,9));
    }

    public static String getRandomIntValueWithPrefix(int j,String  prefix) {
         refer =prefix;
        Random randomno = new Random();
        try{
            for ( i = 1; i <= j; i++) {
                reference = randomno.nextInt(9);
                refer += reference;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
    }
        return refer;
    }

    public static String getRandomAlphabeticValue(int len) {
        return RandomStringUtils.randomAlphabetic(len);
    }

    public static String getRandomAlphaNumericValue(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }
}
