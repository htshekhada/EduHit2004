import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Revframe1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
//      HttpSession session = request.getSession(true);      
//      String userid = (String) session.getValue("userid");
//      String password=(String) session.getValue("password");
       

//      if((userid==null) || (password==null))
//         {
//          response.sendRedirect("/servlet/Login");
//          return;
//         }

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
 
      out.println("</head>");

      out.println("<frameset rows=\"14%,*\" border=1 >");
      out.println("<frameset cols=\"25%,40%,*\" border=1 >");
      out.println("<frame name=\"topleft\" src=\"http://"+request.getServerName()+":8080/servlet/Revfield1\" SCROLLING=\"no\">");
      out.println("<frame name=\"topmiddle\" src=\"http://"+request.getServerName()+":8080/servlet/Revfield2\" SCROLLING=\"no\">");
      out.println("<frame name=\"topright\" src=\"http://"+request.getServerName()+":8080/servlet/Revfield3\" SCROLLING=\"no\">");
      out.println("</frameset>");
//      out.println("<frame name=\"middle\" >");
      out.println("<frame name=\"bottom\" src=\"http://"+request.getServerName()+":8080/servlet/Revintro\">");
      out.println("</frameset>");
      out.println("</html>");

  }
}
