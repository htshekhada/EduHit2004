import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Menuframe4 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
 
      out.println("</head>");
       java.util.Date d1;
       d1=new java.util.Date();


//      System.out.println(""+request.getRemoteHost()+"-SUPER USER ACCESS-"+d1+"");

      
      out.println("<frameset cols=\"25%,*\">");
      out.println("<frame name=\"bottom\" src=\"http://"+request.getServerName()+":8080/servlet/Setting\">");
      out.println("<frameset rows=\"11%,*\">");
      out.println("<frame name=\"top\" src=\"http://"+request.getServerName()+":8080/servlet/Mainback\" frameborder=\"no\" scrolling=\"no\">");


      out.println("<frame name=\"bottom1\"  src=\"http://"+request.getServerName()+":8080/servlet/Suhelp4\">");
      out.println("</frameset>");

      out.println("</frameset>");
      out.println("</html>");

  }
}
