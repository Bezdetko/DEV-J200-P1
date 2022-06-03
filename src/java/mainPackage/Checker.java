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
    
    String msg;

    public Checker() {
    }
    
        public boolean checkAdress(String city, String street, String num, String subnum, String flat, String extra){
//        String msg;
        String regexRus = "^[А-Яа-яЁё\\d\\s,\\.-]*";
        String regexNum = "^[1-9]\\d*]*";
        Pattern patternRus = Pattern.compile(regexRus);
//        Pattern patternNum = Pattern.compile(regexNum);
//        Matcher cityMatcher = patternRus.matcher(city);
//        Matcher streetMatcher = patternRus.matcher(street);
//        Matcher extraMatcher = patternRus.matcher(extra);
        
                
        if (city.isEmpty() || street.isEmpty() || num.isEmpty() ){
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
              
        
//        else if (!num.matches(regexNum)  || !subnum.matches(regexNum) || !flat.matches(regexNum)){
//            msg = "Поля  \"№ дома\", \"корпус\", \"№ квартиры\" должны быть >0";
//            return false;
//        }

        else if (!num.matches(regexNum)){
            msg = "Поле  \"№ дома\" должно быть >0";
            return false;
        }
        
        else if ( (subnum.matches(regexNum)==false && subnum.isEmpty()==false ) || (flat.matches(regexNum)==false && flat.isEmpty()==false  )){
            msg = "Поля  \"корпус\", \"№ квартиры\" должны быть >0 или не заплнены";
            return false;
        }
        
        
           
        return true;
    }
    
    
//    public boolean checkAdress(String city, String street, int num, int subnum, int flat, String extra){
//        String msg;
//        String regexRus = "^[А-Яа-яЁё\\d\\s,\\.-]*";
////        String regexNum = "^[\\d\\.]*";
//        Pattern patternRus = Pattern.compile(regexRus);
////        Pattern patternNum = Pattern.compile(regexNum);
////        Matcher cityMatcher = patternRus.matcher(city);
////        Matcher streetMatcher = patternRus.matcher(street);
////        Matcher extraMatcher = patternRus.matcher(extra);
//        
//                
//        if (city.isEmpty() || street.isEmpty() || num == 0){
//            msg = "Поля  \"город\", \"улица\", \"№ дома\" должны быть обязательно заполнены";
//            return false;
//        }
//        
//        else if (city.length()>100 || street.length()>100 || extra.length() >200){
//            msg = "Поля  \"город\", \"улица\", \"№ дома\" должны быть не более 100 сиволов, поле \"дополнительно\" не более 200 символов";
//            return false;
//        }
//        
//        else if (city.matches(regexRus) == false || street.matches(regexRus) == false || extra.matches(regexRus) == false){
//            msg = "Поля  \"город\", \"улица\", \"дополнительно\" должны использовать буквы русского";
//            return false; 
//        }
//        
////        else if (cityMatcher.matches() == false || streetMatcher.matches() == false || extraMatcher.matches() == false){
////            msg = "Поля  \"город\", \"улица\", \"дополнительно\" должны использовать буквы русского";
////            return false; 
////        }
//              
//        
//        else if (num<1 || subnum <1 || flat <1){
//            msg = "Поля  \"№ дома\", \"корпус\", \"№ квартиры\" должны быть >0";
//            return false;
//        }
//           
//        return true;
//    };
    
    
        
         public boolean checkClient (String type, String model, String ip){
             String regexEng = "^[a-zA-Z\\d\\s,\\.-]*";
//             String regexNum = "^[\\d*]";
//            String regexIp = "((0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))\\.){3}(0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))";
            String regexIp = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
//             boolean rez = true;             
            
             if (type.isEmpty() || model.isEmpty() || ip.isEmpty() ){
                 msg = "Поля  \"тип устройства\", \"модель устройства\", \"сетевой адресс\" должны быть обязательно заполнены";
//                 rez = false;
//                 return rez;
                return false;
             }
                          
             else if (type.length() > 100 || model.length() >100){
                 msg = "Поля  \"тип устройства\", \"модель устройства\", должны быть не более 100 сиволов, поле \"сетевой адресс\" не более 25 символов";
//                 rez = false;
//                 return rez;
                return false;
             }
             
             else if (!type.matches(regexEng) || !model.matches(regexEng)){
                 msg = "Поля  \"тип устройства\", \"модель устройства\" должны использовать буквы латинского алфавита";
//                 rez = false;
//                 return rez;
                return false;
             }
             
             else if (!ip.matches(regexIp)){
                 msg = "не валидный ip";
                 return false;
             }
             
//             else if (ip.matches(regexNum)==true){
//                String [] ipString = ip.split(".");        
//                int [] numIp = new int[ipString.length];
//                for (int i=0; i<ipString.length; i++){
//                    numIp[i] = Integer.parseInt(ipString[i]);
//                  }
//                for (int octet: numIp) {
//                    if (octet > 255){
//                        rez=false;
//                        msg = "шз не валиден";
//                        break;                        
//                    }
//                    else rez = true;
//                }
//             return rez;  
//             }
             
                return true;
//             return rez;
         }

         
        
        
        
    public String getMsg() {
        return msg;
    }
        
    
}
