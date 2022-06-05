/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Александр
 */
@WebServlet(name = "addAddressToClient", urlPatterns = {"/addAddressToClient"})
public class addAddressToClient extends HttpServlet {
    Client client;

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>addAddressToClient</title>");            
            out.println("</head>");
            out.println("<body>");

            out.println("<form action=\"addAddressToClient\" method=\"POST\">");
            out.println("<h2>Новый адрес</h2>");
            out.println("<table width=\"100%\" align=\"left\" cellspacing=\"5\">");
            out.println("<tr>");
            out.println("<td width=\"150\"> ");
            out.println("<b>Город:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"city\" type=\"text\" id=\"city\" placeholder=\"город\"");
            out.println("maxlength=\"100\"");
            out.println("title=\"Используйте буквы русского алфавита\"");
            out.println("pattern=\"^[А-Яа-яЁё\\s,.-]+$\"");
            out.println("required>*");
            out.println("</td> ");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width=\"150\">");
            out.println("<b>Улица:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"street\" type=\"text\" id=\"street\" placeholder=\"улица\"");
            out.println("maxlength=\"100\"");
            out.println("title=\"Используйте буквы русского алфавита\"");
            out.println("pattern=\"^[А-Яа-яЁё\\s0-9,.-]+$\"");
            out.println("required >*");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width=\"150\">");
            out.println("<b>№ дома:</b>");
            out.println("</td>");
            out.println("<td>");            
            out.println("<input name=\"num\" type=\"number\" id=\"num\" placeholder=\"№ дома\" ");
            out.println("title=\"номер дома должен быть >0\"");
            out.println("pattern=\"^[1-9]\\d*\"");
            out.println("required >*");
            out.println("</td>");
            out.println("</tr>");            
            out.println("<tr>");
            out.println("<td width=\"150\">");
            out.println("<b>корпус:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"subnum\" type=\"number\" id=\"subnum\" placeholder=\"Корпус\" >");
            out.println("</td>");            
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width=\"150\">");            
            out.println("<b>№ квартиры:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"flat\" type=\"number\" id=\"flat\" placeholder=\"№ квартиры\">");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");            
            out.println("<p> <b>Дополнительно:</b> </p>");
            out.println("<p> <textarea name=\"extra\" maxlength=\"100\" cols=\"40\" rows=\"5\" placeholder=\"Дополнительньная информация. Используйте кириллицу\"></textarea> </p>");
            
            out.println("<input type=\"submit\" name=\"add\" value=\"Добавить\"/>");
            out.println("<input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/>");
            
            out.println("</body>");
            out.println("</html>");
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
        String idLine = request.getParameter("idClient");
        Integer idClient = Integer.parseInt(idLine);
        client = Client.getClientById(idClient);
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
//        processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Checker checker = new Checker();
        
        String city = request.getParameter("city").trim();
        String street = request.getParameter("street").trim();
        String tmpNum = request.getParameter("num").trim();
        String tmpSubnum = request.getParameter("subnum").trim();
        String tmpFlat = request.getParameter("flat").trim();
        String extra = request.getParameter("extra").trim();

        
        if (checker.checkAdress(city, street, tmpNum, tmpSubnum, tmpFlat, extra) == false){
            String msg = checker.getMsg();
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }
        
                else {
            int num = Integer.parseInt(tmpNum);
            int subnum = 0;
            int flat = 0; 
            if (!tmpSubnum.isEmpty()){
                subnum = Integer.parseInt(tmpSubnum);
            }
            if (!tmpFlat.isEmpty()){
                flat = Integer.parseInt(tmpFlat);
            }
            
            client.addAddress(city, street, num, subnum, flat, extra);
//            client.addClient();
            response.sendRedirect("http://localhost:8080/DEV-J200-P1/viewList");
        }
                
        
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
