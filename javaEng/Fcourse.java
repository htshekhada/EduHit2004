import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Fcourse extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
 
      

      out.println("<frameset rows=\"17%,13%,*\">");
      out.println("<frame name=\"top\" scrolling=\"no\" src=\"http://"+request.getServerName()+":8080/servlet/Coursesc\">");
      out.println("<frame name=\"middle\" scrolling=\"no\">");
      out.println("<frame name=\"bottom\">");
      out.println("</frameset>");

      
      out.println("</html>");

  }
}
