import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Suhelp extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      out.println("<center><b><strong>EducationHIT</strong></b></center>");
      out.println("<br>");

       out.println("<center><b><font face=\"Times New Roman\" size=4 color=\"RGB(255,0,0)\">Help is Not Included in Demo Version.</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=4 color=\"RGB(255,0,0)\">This is Demo Version. For Purchasing Full Version Contanct Me at:</font></b></center>");
       out.println("<br><br><center><b><font face=\"Times New Roman\" size=4 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><strong><font face=\"Times New Roman\" size=5 color=\"rgb(0,0,255)\">Hiteshkumar T. Shekhada</font></strong></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=4 color=\"RGB(0,0,255)\">(B.E. in Information Technology)</font></b></center>");
       out.println("<center><strong><font face=\"Times New Roman\" size=4 color=\"rgb(0,0,255)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></strong></center>");


//       out.println("<center><b><font face=\"Times New Roman\" size=4 color=\"RGB(0,0,255)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");



      int i=0,i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;

      Random r1=new Random();
      Random r2=new Random();   

      i1 = r1.nextInt(10);
      i2 = r1.nextInt(10);
      i3 = r1.nextInt(10);
      i4 = r1.nextInt(10);
      i5 = r1.nextInt(10);
      i6 = r1.nextInt(10);
      
      i=i1*100000;
      i=i+i2*10000;
      i=i+i3*1000;
      i=i+i4*100;
      i=i+i5*10;
      i=i+i6;


      

 //     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Democom1\">");


//      out.println("<br>");
//      out.println("<center><strong><font face=\"arial\" size=\"4\" color=\"\">User ID </font></strong></center>");
//      out.println("<center><input type=\"text\" name=\"uid\" size=\"30\" value=\""+i+"\" style=\"font-size:15pt\"></strong></center>");

//      out.println("<center><strong><font face=\"arial\" size=\"4\" color=\"\">PassWord </font></strong></center>");
//      out.println("<center><input type=\"text\" name=\"pwd\" size=\"30\" style=\"font-size:15pt\"></strong></center>");



      out.println("<br>");
 //     out.println("<center><input type=\"submit\" value=\"Submit\" name=\"submit\"></center>");
//      out.println("</form>");
      out.println("</body>");
      out.println("</html>");



}
}



