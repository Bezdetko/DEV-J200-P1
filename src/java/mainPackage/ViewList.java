/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Александр
 */
@WebServlet(name = "ViewList", urlPatterns = {"/viewList"})
public class ViewList extends HttpServlet {
    HttpServletRequest request;
    List <Client> clients;
    
    
    
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.request = request;
        clients=Client.сlientList;
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Адресс</h2>");
            out.println("<table width=\"100%\" align=\"left\" border=\"1\">");
            out.println("<th> <b> ID клиента </b></th>");
            out.println("<th> <b>Тип устройства</b></th>");
            out.println("<th> <b>Модель устройства</b></th>");
            out.println("<th> <b>Сетевой адресс</b></th>");
            out.println("<th> <b> ID адреса </b> </th>");
            out.println("<th> <b> Город </b> </th>");
            out.println("<th> <b> Улица </b> </th>");
            out.println("<th> <b>№ дома</b> </th>");
            out.println("<th> <b>Корпус:</b> </th>");
            out.println("<th> <b>№ квартиры</b> </th>");
            out.println("<th> <b>Дополнительно</b> </th>");
            out.println("<th> <b>Редактирование</b> </th>");
            if(clients!=null && !clients.isEmpty()){
                         for(Client c: clients){
                             c.getAddressList();
                             List<Address> clientAddressList = c.getAddressList();
                             out.println("<tr>");
                             out.println("<td rowspan=\""+ clientAddressList.size()+ "\">" + c.getIdClient()+ "</td>" );
                             out.println("<td rowspan=\""+ clientAddressList.size()+ "\">" + c.getType()+ "</td>");
                             out.println("<td rowspan=\""+ clientAddressList.size()+ "\">" + c.getModel()+ "</td>");
                             out.println("<td rowspan=\""+ clientAddressList.size()+ "\">" + c.getIp()+ "</td>");
                             for(Address a: clientAddressList){
                                 out.println("<td>" + a.getIdAddress()+ "</td>");
                                 out.println("<td>" + a.getCity()+ "</td>");
                                 out.println("<td>" + a.getStreet()+ "</td>");
                                 out.println("<td>" + a.getNum()+ "</td>");
                                 out.println("<td>" + a.getSubnum()+ "</td>");
                                 out.println("<td>" + a.getFlat()+ "</td>");
                                 out.println("<td>" + a.getExtra()+ "</td>");      
                                 if (clientAddressList.indexOf(a) == 0 ){
//                                     out.println("<td rowspan=\""+ clientAddressList.size()+ "\">" + "delete"+ "</td>" );
                                     out.println("<td rowspan=\""+ clientAddressList.size()+ "\">");
//                                     out.println("<a href=\"http://localhost:8080/DEV-J200-P1/update?idClient=\"" + c.getIdClient() + ">Обновить</a>");
                                    out.println("<button onclick=\"window.location.href = 'http://localhost:8080/DEV-J200-P1/update?idClient="+c.getIdClient() +"';\">Изменить</button>");        
                                                
                                       
//                                     out.println("</form>");
                                     out.println("</td>");
                                 }
                                 out.println("</tr>");
                                 out.println("<tr>");
                            }
                             out.println("</tr>");
//                             out.println("<td>" + "sdsd"+ "</td>" );
                             
                             
                    }
//            out.println("</tr>");
            out.println("</body>");
            out.println("</html>");
            
            
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
