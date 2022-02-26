/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Paginas;

import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HoxPJ
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
            if(request.getSession(false)==null){
                
                
                out.println("<form class=\"floatright\" action='Login'>");
                out.println("<input style=\"top: 0vh;text-align:center;\" type='text' name='nome' placeholder='usuario'/>");         
                out.println("<input style=\"top: 15vh;text-align:center;\" type='password' name='senha' placeholder='senha'/>");
                out.println("<input style=\"top: 30vh;text-align:center;\" type='submit' value='Logar'>");
                out.println("</form>");
                
                out.println("<p id='head1' class='header'>Você precisa se logar</p>");
                out.println("<p id='head2' class='header'>Usuarios:senhas pré-cadastrados:</p>");
                out.println("<p id='head3' class='header'>estudante:123</p>");
                out.println("<p id='head4' class='header'>professor:456</p>");
                out.println("<p id='head5' class='header'>coordenador:789</p>");
                
                
            }else{
                Usuario usuarioLogado = (Usuario)request.getSession(false).getAttribute("usuario");
                //out.println("<p id='head1' class='header'>"+"Seja bem vindo '"+usuarioLogado.getNome()+"'"+"</p>");
                //out.println("Seja bem vindo '"+usuarioLogado.getNome()+"'");
                out.println("<img style=\"top: 30vh;display:block;margin-left:auto;margin-right:auto;width:10%;\" src='Jpg'><br>");
                out.println("<p class='header' style=\"top: 40vh;display:block;margin-left:auto;margin-right:auto;\">"+usuarioLogado.getNome()+"</p><br>");
                out.println("<form class=\"floatright\" action='Logout'>");
                out.println("<input style=\"top: 60vh;text-align:center;\" type='submit' value='Logout'>");
                out.println("</form>");
            };
            out.println("<div class='light x1'></div>");
            out.println("<div class='light x2'></div>");
            out.println("<div class='light x3'></div>");
            out.println("<div class='light x4'></div>");
            out.println("<div class='light x5'></div>");
            out.println("<div class='light x6'></div>");
            out.println("<div class='light x7'></div>");
            out.println("<div class='light x8'></div>");
            out.println("<div class='light x9'></div>");
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
