import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class EduHit extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
 
      out.println("  <FRAMESET ROWS=\"1%,*,1%\">");
      out.println("    <FRAME SRC=\"http://"+request.getServerName()+":8080/servlet/Hit\" SCROLLING=\"no\" NAME=\"top\">");
      out.println("  <FRAMESET COLS=\"1%,96%,1%\"> ");
      out.println("    <FRAME SRC=\"http://"+request.getServerName()+":8080/servlet/Hit\" SCROLLING=\"no\" NAME=\"left\">");
      out.println("    <FRAME SRC=\"http://"+request.getServerName()+":8080/servlet/OnlineExam\" SCROLLING=\"yes\" NAME=\"marquee\">");
      out.println("    <FRAME SRC=\"http://"+request.getServerName()+":8080/servlet/Hit\" SCROLLING=\"no\" NAME=\"right\">");
      out.println("  </FRAMESET>");
      out.println("  <FRAME SRC=\"http://"+request.getServerName()+":8080/servlet/Hit\" SCROLLING=\"no\" NAME=\"bottom\">");
      out.println("  </FRAMESET>");
      





      out.println("</html>");

  }
}
