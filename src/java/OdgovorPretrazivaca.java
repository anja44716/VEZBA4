import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OdgovorPretrazivaca extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String kljuc = request.getParameter("pojamzapretragu");
        if(kljuc == null || kljuc.isEmpty()){
            reportProblem(response, "Niste uneli pojam koji zelite da pronadjete.");
            return;
        }
        kljuc = URLEncoder.encode(kljuc, "UTF-8");
        String imepretrazivaca = request.getParameter("tipPretrazivaca");
        if(imepretrazivaca == null || imepretrazivaca.isEmpty()){
            reportProblem(response, "Niste uneli pretrazivac koji koristite.");
            return; 
        }
        String pretragaURL = VrstePretrazivaca.napraviURL(imepretrazivaca, kljuc);
        if(pretragaURL != null){
            response.sendRedirect(pretragaURL);
        } else {
            reportProblem(response, "Nije poznat pretrazivac.");
        }
       
        }
    private void reportProblem(HttpServletResponse response, String message)
        throws IOException
        {
            response.sendError(response.SC_NOT_FOUND, message);
        }
    }