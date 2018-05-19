import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Mainback extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
//      response.setContentType("bytes/raw-html");    // * (text/raw-html) for bkground
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
  
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\"> ");

      out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Supmain target=\"_parent\">");
      out.println("<input  type=\"submit\" value=\"D]bI lJS<5MGL IFNLDF\\ 5FK] HJF DF8[ VF A8GG[ NAFJM\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 14pt; color:blue \">");
      out.println("</form></center>");   



      out.println("</body>");
      out.println("</html>");
    }
}



