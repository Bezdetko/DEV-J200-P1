/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.util.ArrayList;
import java.util.List;
import static mainPackage.Client.сlientList;

/**
 *
 * @author Александр
 */
public class Address {
     private int idAddress;     //идентификатор
     private String city;       //город
     private String street;     //улица
     private int num;           //номер дома 
     private int subnum;        //корпус
     private int flat;          //номер квартиры 
     private String extra;      //дополнительно
     public Client client;
     public static List<Address> adressTable;
     
         static{
        
        adressTable = new ArrayList<>(); 
        
         }

       
//     public Address(String city, String street, int num, int subnum, int flat, String extra) {
//        idAddress = adressTable.size()+1;
//        this.city = city;
//        this.street = street;
//        this.num = num;
//        this.subnum = subnum;
//        this.flat = flat;
//        this.extra = extra;
////        this.client =client;
//    }
         
        public Address(String city, String street, int num, int subnum, int flat, String extra, Client client) {
//        idAddress = adressTable.size()+1;
        if(adressTable.isEmpty()){
           idAddress = 1;
        }
        else {
         idAddress = adressTable.get(adressTable.size()-1).getIdAddress()+1;
        }
        this.city = city;
        this.street = street;
        this.num = num;
        this.subnum = subnum;
        this.flat = flat;
        this.extra = extra;
        this.client =client;
        adressTable.add(this);
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSubnum() {
        return subnum;
    }

    public void setSubnum(int subnum) {
        this.subnum = subnum;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    
     
     
}


