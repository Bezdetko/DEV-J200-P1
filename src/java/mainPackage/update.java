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
@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {
    
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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<title>Create</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<form action=\"viewList\" method=\"POST\">");
            out.println("<form action=\"update\" method=\"POST\">");
//            out.println("<form action=\"viewList\">");
            out.println("<h2>Адресса</h2>");
            for(Address a: client.getAddressList()){
            out.println("<table width=\"100%\" align=\"left\" cellspacing=\"5\">");
            out.println("<tr>");
            out.println("<td width=\"150\"> ");
            out.println("<b>Город:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"city"+ a.getIdAddress() +"\" type=\"text\" id=\"city\" placeholder=\"город\" value=\""+ a.getCity() +" \" ");
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
            out.println("<input name=\"street"+ a.getIdAddress() +"\" type=\"text\" id=\"street\" placeholder=\"улица\" value=\""+ a.getStreet()+" \"");
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
            out.println("<input name=\"num"+ a.getIdAddress() +"\" type=\"number\" id=\"num\" placeholder=\"№ дома\" value=\""+ a.getNum()+" \"");
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
            out.println("<input name=\"subnum"+ a.getIdAddress() +"\" type=\"number\" id=\"subnum\" placeholder=\"Корпус\" value=\""+ a.getSubnum() +" \" >");
            out.println("</td>");            
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width=\"150\">");            
            out.println("<b>№ квартиры:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"flat"+ a.getIdAddress() +"\" type=\"number\" id=\"flat\" placeholder=\"№ квартиры\" value=\"" + a.getFlat()+" \">");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");            
            out.println("<p> <b>Дополнительно:</b> </p>");
            out.println("<p> <textarea name=\"extra"+ a.getIdAddress() +"\" maxlength=\"100\" cols=\"40\" rows=\"5\" placeholder=\"Дополнительньная информация. Используйте кириллицу\" value=\""+ a.getExtra() +" \"></textarea> </p>");
            }
            out.println("<h2>Клиент</h2>");            
            out.println("<table width=\"100%\" align=\"left\" cellspacing=\"5\">");
            out.println("<tr>");
            out.println("<td width=\"150\">");            
            out.println("<b>Тип устройства:</b>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"type\" type=\"text\" id=\"type\" placeholder=\"тип устройства\" value=\"" + client.getType()+ "\" maxlength=\"100\"pattern=\"^[a-zA-Z\\s]+$\" required>*");            
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");            
            out.println("<td width=\"150\">");
            out.println("<b>Модель устройства: </b>");
            out.println("</td>");            
            out.println("<td>");
            out.println("<input name=\"model\" type=\"text\" id=\"model\" placeholder=\"модель устройства\" value=\"" + client.getModel()+ "\" maxlength=\"100\" pattern=\"^[a-zA-Z\\d\\s,\\.-]+$\" required>*");
            out.println("</td> ");
            out.println("</tr>");            
            out.println("<tr>");
            out.println("<td width=\"150\">");
            out.println("<b>Сетевой адресс:</b>");            
            out.println("</td>");
            out.println("<td>");
            out.println("<input name=\"ip\" type=\"text\" id=\"ip\" placeholder=\"255.255.255.255\" value=\"" + client.getIp()+ "\" maxlength=\"25\"");            
            out.println("pattern=\"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\" required > *");
            out.println("</td>");
            out.println("</tr>");              
            out.println("</table>");
            out.println("<p>* -  поля обязательные для заполнения</p>");
            out.println("<br>");              
            out.println("<input type=\"submit\" name=\"add\" value=\"Изменить\"/>");
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
        client = Client.сlientList.get(idClient-1);
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
        
      
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Checker checker = new Checker();

//        boolean[] check = new boolean[client.getAddressList().size()+1];
        
//        for (int i = 1; i < client.getAddressList().size(); i++){
//            Address a = client.getAddressList().get(i-1);
//            String n = Integer.toString(i);
////        String stringId = Integer.toString(intId);         
//        String city = request.getParameter("city"+n).trim();
//        String street = request.getParameter("street"+n).trim();
//        String tmpNum = request.getParameter("num"+n).trim();
//        String tmpSubnum = request.getParameter("subnum"+n).trim();
//        String tmpFlat = request.getParameter("flat"+n).trim();
//        String extra = request.getParameter("extra"+n).trim();
//        check[i-1] = checker.checkAdress(city, street, n, tmpSubnum, tmpFlat, extra)
//            
//        }
        
        
        for(Address a: client.getAddressList()){
                client.setAddressList(client.getAddressList());
               int intId = a.getIdAddress();
               String stringId = Integer.toString(intId);         
        String city = request.getParameter("city"+stringId).trim();
        String street = request.getParameter("street"+stringId).trim();
        String tmpNum = request.getParameter("num"+stringId).trim();
        String tmpSubnum = request.getParameter("subnum"+stringId).trim();
        String tmpFlat = request.getParameter("flat"+stringId).trim();
        String extra = request.getParameter("extra"+stringId).trim();
        if (checker.checkAdress(city, street, tmpNum, tmpSubnum, tmpFlat, extra) == false){
            String msg = checker.getMsg();
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
            dispatcher.forward(request, response);
                }
                
        }
        
        String type = request.getParameter("type").trim();
        String model = request.getParameter("model").trim();
        String ip = request.getParameter("ip").trim();
        
//        int tmpNum1 = Integer.parseInt(request.getParameter("num").trim());
//        int tmpSubnum1 = Integer.parseInt(request.getParameter("subnum").trim());


            
        if (checker.checkClient(type, model, ip) == false){
            String msg = checker.getMsg();
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }           
        
        else {
        for(Address a: client.getAddressList()){
                client.setAddressList(client.getAddressList());
                int intId = a.getIdAddress();
                String stringId = Integer.toString(intId);         
                String city = request.getParameter("city"+stringId).trim();
                String street = request.getParameter("street"+stringId).trim();
                String tmpNum = request.getParameter("num"+stringId).trim();
                String tmpSubnum = request.getParameter("subnum"+stringId).trim();
                String tmpFlat = request.getParameter("flat"+stringId).trim();
                String extra = request.getParameter("extra"+stringId).trim();
            int num = Integer.parseInt(tmpNum);
            int subnum = 0;
            int flat = 0; 
            if (!tmpSubnum.isEmpty()){
                subnum = Integer.parseInt(tmpSubnum);
            }
            if (!tmpFlat.isEmpty()){
                flat = Integer.parseInt(tmpFlat);
            }
            a.setCity(city);
            a.setStreet(street);
            a.setNum(num);
            a.setSubnum(subnum);
            a.setFlat(flat);
            a.setExtra(extra);
        }
        
        client.setType(type);
        client.setModel(model);
        client.setIp(ip);

            }
            response.sendRedirect("http://localhost:8080/DEV-J200-P1/viewList");

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
