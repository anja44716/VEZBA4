import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormaPretrazivanja extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String naslov="Internet pretrazivanje";
        String URLadresa="OdgovorPretrazivaca";
        String docType="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 TRANSITIONAL//EN\">\n";
        out.println(docType+"<HTML>\n <head><title>"+naslov+"</title></head>\n"+"<body BGCOLOR=\"#FDF5E6\">\n <CENTER>\n <H1>"+naslov+"</H1>\n"+"<FORM ACTION=\""+URLadresa+"\">\n"+
                "Pojam za pretragu: \n"+"<INPUT TYPE=\"TEXT\" NAME=\"pojamzapretragu\"><P>\n");
        Pretrazivac[] vrste = VrstePretrazivaca.getPretrazivaci();
        for(int i=0; i<vrste.length; i++ ){
            String naziv = vrste[i].getIme();
            out.println("<INPUT TYPE=\"RADIO\" NAME=\"tipPretrazivaca\" VALUE=\""+naziv+"\">\n");
            out.println(naziv+"<BR>\n");
        }
        out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"PRONADJI\">\n </FORM>\n </CENTER> </body> </html>");
    }
}
