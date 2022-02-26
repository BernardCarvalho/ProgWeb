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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author HoxPJ
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            
            
            ArrayList<Usuario> usuarios = new ArrayList();
            
                usuarios.add(new Usuario("estudante","123"));
                usuarios.add(new Usuario("professor","456"));
                usuarios.add(new Usuario("coordenador","789"));
                        
            String nome=request.getParameter("nome");
            String senha=request.getParameter("senha");
            
            boolean login = false;
            Usuario usuarioLogado=null;
            
            for(Usuario usuario : usuarios){
                if( usuario.getNome().equals(nome) &&
                    usuario.getSenha().equals(senha))
                {
                    login=true;
                    usuarioLogado = usuario;
                }
            }
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">");
            out.println("<title>Servlet Login</title>");
            out.println("<meta http-equiv=\"refresh\" content=\"8; URL='Home'\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("<div class='light x1'></div>");
            out.println("<div class='light x2'></div>");
            out.println("<div class='light x3'></div>");
            out.println("<div class='light x4'></div>");
            out.println("<div class='light x5'></div>");
            out.println("<div class='light x6'></div>");
            out.println("<div class='light x7'></div>");
            out.println("<div class='light x8'></div>");
            out.println("<div class='light x9'></div>");            
            if(login)
            {
                HttpSession sessao=request.getSession();
                sessao.setAttribute("usuario", usuarioLogado);
                sessao.setMaxInactiveInterval(300);
                               
                out.println("<p id='head1' class='header'>USUARIO '"+usuarioLogado.getNome()+"' LOGADO COM SUCESSO</p>");
                out.println("<p id='head2' class='header'>Redirecionando para a homepage, por favor, aguarde</p>");
                
            }else
            {
                out.println("<p id='head1' class='header'>USUARIO 'USUARIO NÃO ENCONTRADO NO SISTEMA' LOGADO COM SUCESSO</p>");
                out.println("<p id='head2' class='header'>Redirecionando para a homepage, por favor, aguarde</p>");
                
            }
            
            
            
            
            
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
