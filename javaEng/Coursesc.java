import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Coursesc extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");

      
      out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Coursesub\" target=\"middle\">");

      out.println("<center><table width=750 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/Menuframe4\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Back</font></strong>");
      out.println("</a></td>");

      out.println("<th><b><font face=\"Times New Roman\" size=4 color=\"rgb(0,0,255)\">Syllabus(Course) Setting Module</font></b></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/Menuframe4\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Back</font></strong>");
      out.println("</a></td></tr></table></center>");


      out.println("<center>");

       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;


      out.println("<strong><font face=\"Times New Roman\" size=4 >Standard</font></strong>&nbsp;");


      out.println("<select  name=\"std\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM subject;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }

   out.println(" </select> </strong>");
      


      out.println("&nbsp;&nbsp;<strong><font face=\"Times New Roman\" size=\"4\" color=\"\">Class</font></strong> &nbsp;");
   //   out.println("<input type=\"text\"size=5 name=\"class\">");
       out.println("<select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");
       out.println("<option value=A>A</option>");
       out.println("<option value=B>B</option>");
       out.println("<option value=C>C</option>");
       out.println("<option value=D>D</option>");
       out.println("<option value=E>E</option>");
       out.println("<option value=F>F</option>");
       out.println("<option value=G>G</option>");
       out.println("<option value=H>H</option>");
       out.println("<option value=I>I</option>");
       out.println("<option value=J>J</option>");
       out.println("<option value=K>K</option>");
       out.println("<option value=L>L</option>");
       out.println("<option value=M>M</option>");
       out.println("<option value=N>N</option>");
       out.println("<option value=O>O</option>");
       out.println("<option value=P>P</option>");
       out.println("<option value=Q>Q</option>");
       out.println("<option value=R>R</option>");
       out.println("<option value=S>S</option>");
       out.println("<option value=T>T</option>");
       out.println("<option value=U>U</option>");
       out.println("<option value=V>V</option>");
       out.println("<option value=W>W</option>");
       out.println("<option value=X>X</option>");
       out.println("<option value=Y>Y</option>");
       out.println("<option value=Z>Z</option>");
       

       out.println(" </select> </strong>");
     
  
     
      out.println("<input  type=\"submit\" value=\"Ok\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 1em\">&nbsp;&nbsp; ");

      out.println("&nbsp;&nbsp;&nbsp;");
//      out.println("<input type=\"reset\" name=\"reset\" value=\"Reset\">");
      out.println("</center>");
      out.println("</form>");

      
      out.println("</body>");
      out.println("</html>");

  }
}
