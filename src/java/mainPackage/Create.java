/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static mainPackage.Client.сlientList;

/**
 *
 * @author Александр
 */
@WebServlet(name = "Create", urlPatterns = {"/create"})
public class Create extends HttpServlet {
    Client client;
    Address adress;
//    List <Client> clients;    
    List<Address> addresses;
    HttpServletRequest request;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Create</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Create at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {/* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Create</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<form action=\"viewList\" method=\"POST\">");
            out.println("<form action=\"create\" method=\"POST\">");
//            out.println("<form action=\"viewList\">");
            out.println("<h2>Адресс</h2>");
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
//            out.println("<input name=\"num\" type=\"number\" id=\"num\" placeholder=\"№ дома\" required >*");
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
            out.println("<h2>Клиент</h2>");            
            out.println("<table width=\"100%\" align=\"left\" cellspacing=\"5\">");
            out.println("<tr>");
            out.println("<td width=\"150\">");            
            out.println("<b>Тип устройства:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"type\" type=\"text\" id=\"type\" placeholder=\"тип устройства\" maxlength=\"100\"pattern=\"^[a-zA-Z\\s]+$\" required>*");            
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");            
            out.println("<td width=\"150\">");
            out.println("<b>Модель устройства: </b>");
            out.println("</td>");            
            out.println("<td>");
            out.println("<input name=\"model\" type=\"text\" id=\"model\" placeholder=\"модель устройства\" maxlength=\"100\" pattern=\"^[a-zA-Z\\d\\s,\\.-]+$\" required>*");
            out.println("</td> ");
            out.println("</tr>");            
            out.println("<tr>");
            out.println("<td width=\"150\">");
            out.println("<b>Сетевой адресс:</b>");            
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"ip\" type=\"text\" id=\"ip\" placeholder=\"255.255.255.255\" maxlength=\"25\"");            
            out.println("pattern=\"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\" required > *");
            out.println("</td>");
            out.println("</tr>");              
            out.println("</table>");
            out.println("<p>* -  поля обязательные для заполнения</p>");
            out.println("<br>");              
            out.println("<input type=\"submit\" name=\"add\" value=\"Зарегестирировать\"/>");
            out.println("<input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/>");
            out.println("</body>");
            out.println("</html>");
            
        }
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
        request.setCharacterEncoding("UTF-8");
//        this.request = request;
//        try (PrintWriter out = response.getWriter()) {
            
            
//        String city = request.getParameter("city").trim();
//        String street = request.getParameter("street").trim();
//        int num = Integer.parseInt(request.getParameter("num"));
//        int subnum = Integer.parseInt(request.getParameter("subnum"));
//        int flat = Integer.parseInt(request.getParameter("flat"));
//        String extra = request.getParameter("extra").trim();
//        String type = request.getParameter("type").trim();
//        String model = request.getParameter("model").trim();
//        String ip = request.getParameter("ip").trim();
        
        String city = request.getParameter("city").trim();
        String street = request.getParameter("street").trim();
        String tmpNum = request.getParameter("num").trim();
        String tmpSubnum = request.getParameter("subnum").trim();
        String tmpFlat = request.getParameter("flat").trim();
        String extra = request.getParameter("extra").trim();
        String type = request.getParameter("type").trim();
        String model = request.getParameter("model").trim();
        String ip = request.getParameter("ip").trim();
        
//        int tmpNum1 = Integer.parseInt(request.getParameter("num").trim());
//        int tmpSubnum1 = Integer.parseInt(request.getParameter("subnum").trim());

            Checker checker = new Checker();

            
        if (checker.checkAdress(city, street, tmpNum, tmpSubnum, tmpFlat, extra) == false || checker.checkClient(type, model, ip) == false){
            String msg = checker.getMsg();
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }           
//        if (new Checker().checkAdress(city, street, tmpNum, tmpSubnum, tmpFlat, extra) == false){
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
//            dispatcher.forward(request, response);
//        }
        
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
            
            client = new Client(type, model, ip, city, street, num, subnum, flat, extra);
//            client.addClient();
            response.sendRedirect("http://localhost:8080/DEV-J200-P1/viewList");
            
            

        }
        
//        String city = request.getParameter("city").trim();
//        String street = request.getParameter("street").trim();
//        int num = Integer.parseInt(request.getParameter("num").trim());
//        int subnum = Integer.parseInt(request.getParameter("subnum").trim());
//        int flat = Integer.parseInt(request.getParameter("flat").trim());
//        String extra = request.getParameter("extra").trim();
//        String type = request.getParameter("type").trim();
//        String model = request.getParameter("model").trim();
//        String ip = request.getParameter("ip").trim();
        
//        String city = tmpCity.trim();
//        String street = tmpStreet.trim();
//        int num = Integer.parseInt(tmpNum);
//        int sumnum = Integer.parseInt(tmpSubnum);
//        int flat = Integer.parseInt(tmpFlat);
//        String extra = tmpExtra.trim();
//        int idClient = clients.size() + 1;
//        String type = tmpType.trim();
        
//        if (new Checker().checkAdress(city, street, num, subnum, flat, extra) == false){
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
//            dispatcher.forward(request, response);
////            response.sendRedirect("http://localhost:8080/DEV-J200-P1/error");
//        }
//        
//        else {
//            client = new Client(type, model, ip, city, street, num, subnum, flat, extra);
//            сlientList.add(client);            
////            сlientList.add(new Client(type, model, ip, city, street, num, subnum, flat, extra));
////            response.sendRedirect("http://localhost:8080/DEV-J200-P1/viewList");
//
//            
//        }
         
            
        
        

        
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
