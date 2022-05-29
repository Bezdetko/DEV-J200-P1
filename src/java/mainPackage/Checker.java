/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Александр
 */
public class Checker {

    public Checker() {
    }
    
    public boolean checkAdress(String city, String street, int num, int subnum, int flat, String extra){
        String msg;
        String regexRus = "^[А-Яа-яЁё\\d\\s,\\.-]*";
//        String regexNum = "^[\\d\\.]*";
        Pattern patternRus = Pattern.compile(regexRus);
//        Pattern patternNum = Pattern.compile(regexNum);
//        Matcher cityMatcher = patternRus.matcher(city);
//        Matcher streetMatcher = patternRus.matcher(street);
//        Matcher extraMatcher = patternRus.matcher(extra);
        
                
        if (city.isEmpty() || street.isEmpty() || num == 0){
            msg = "Поля  \"город\", \"улица\", \"№ дома\" должны быть обязательно заполнены";
            return false;
        }
        
        else if (city.length()>100 || street.length()>100 || extra.length() >200){
            msg = "Поля  \"город\", \"улица\", \"№ дома\" должны быть не более 100 сиволов, поле \"дополнительно\" не более 200 символов";
            return false;
        }
        
        else if (city.matches(regexRus) == false || street.matches(regexRus) == false || extra.matches(regexRus) == false){
            msg = "Поля  \"город\", \"улица\", \"дополнительно\" должны использовать буквы русского";
            return false; 
        }
        
//        else if (cityMatcher.matches() == false || streetMatcher.matches() == false || extraMatcher.matches() == false){
//            msg = "Поля  \"город\", \"улица\", \"дополнительно\" должны использовать буквы русского";
//            return false; 
//        }
              
        
        else if (num<1 || subnum <1 || flat <1){
            msg = "Поля  \"№ дома\", \"корпус\", \"№ квартиры\" должны быть >0";
            return false;
        }
           
        return true;
    };
    
    
//            String [] ipString = ip.split(".");
//        
//        int [] numIp = new int[ipString.length];
//           for (int i=0; i<ipString.length; i++){
//               numIp[i] = Integer.parseInt(ipString[i]);
//           }
        
    
}
