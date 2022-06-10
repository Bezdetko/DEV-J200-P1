/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import com.sun.jmx.remote.internal.ClientListenerInfo;
import java.util.ArrayList;
import java.util.List;
import static mainPackage.Address.adressTable;

/**
 *
 * @author Александр
 */
public class Client {
    private int idClient;               //идентификатор
    private String type;                //тип устройства  
    private String model;               //модель устройства 
    private String ip;                  //сетевой адрес устройства
    private List<Address> addressList;    //список адресов 
    public static List<Client> сlientList;
        
    
    static{
        
        сlientList = new ArrayList<>();
        
        
        Client client1 = new Client("laptop", "hp", "255.123.000.123", "СПБ", "Ленинский проспект", 121, 3, 432, "");
        Client client2 = new Client("cellphone", "xiaoimi", "123.010.023.151", "СПБ", "Большой проспект В.О", 10, 1, 12, "");
        client1.addAddress("СПБ", "Блохина", 3, 1, 15, "");
        Client client3 = new Client("laptop", "samsung", "123.010.023.152", "МСК", "Кутузовский проспект", 11, 3, 13, "");
        
        


         
        
        
    }
    
    public Client(){}
    
    public Client(String type, String model, String ip, String city, String street, int num, int subnum, int flat, String extra) {
//        this.idClient = сlientList.size() + 1;
        if (сlientList.isEmpty()){
            idClient = 1;
        }
        else {
            idClient = сlientList.get(сlientList.size()-1).getIdClient()+1;
        }
        this.type = type;
        this.model = model;
        this.ip = ip;
        addressList = new ArrayList<>();
        addressList.add(new Address(city, street, num, subnum, flat, extra, this));
        сlientList.add(this);
    }
    
    


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    
    public void addAddress(String city, String street, int num, int subnum, int flat, String extra) {
        Address adressTmp = new Address(city, street, num, subnum, flat, extra, this);
        getAddressList().add(adressTmp);
//        adressTable.add(adressTmp);
        
//        getAddressList().add(new Address(city, street, num, subnum, flat, extra, this));
//        adressTable.add(adressTmp);
        
    }
    
    public void addClient(){
        Client.сlientList.add(this);
    }    
    

    public static List<Client> getСlientList() {
        return сlientList;
    }

    public static void setСlientList(List<Client> сlientList) {
        Client.сlientList = сlientList;
    }
    
    
    public static Client getClientById(int idClient){
        for(Client c: Client.сlientList){
            if(c.getIdClient()==idClient){
                return c;
            }
        }
        return new Client();
    }

 
    
    
}

