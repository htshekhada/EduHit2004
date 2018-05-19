import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Democom1 extends HttpServlet
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
      out.println("<body bgcolor=\"rgb(254,255,225)\">");



       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(0,0,255)\">V[HI]S[XGlC8 ;MO8J[Z</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=3 color=\"rgb(0,0,0)\">AGFJGFZ o </font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=4 color=\"rgb(0,0,0)\"> lCT[XS]DFZ 8LP X[B0F   </font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=4 color=\"rgb(0,0,0)\">!(4S{,FX GUZ ;M;FI8L4  8L\\AFJF0L4  HF]GFU-4 OMGs3Zfv_Z(5vZ&*&&$$P</font></b></center>");


       out.println("<br><center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(255,0,0)\">GLR[ NXF\"J[, OMG G\\AZ 5Z OMG SZL tIFYL 5F;J0\"  ,> GLR[ NXF\"J[, AM1F DF\\ 8F>5 SZM</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(255,0,0)\">_Z(5vZ&*&&$$</font></b></center>");

      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 
                 //       con.setAutoCommit(true); 
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();



      int m1=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getHours();

      stmt.executeUpdate("delete * from temp");
      stmt.executeUpdate("insert into temp values("+m1+") ");
      rs = stmt.executeQuery("select * from temp");
      rs.next();
      String mhit = rs.getString("temp");

      HttpSession session = request.getSession(true);      
      if ( session != null ) {  session.putValue("hit", mhit); }

}
catch(Exception e)
 {
  out.println("Please Contact hitesh.");
 }


      int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0,i8=0,i9=0,i10=0,i11=0,i12=0,i13=0,i14=0,i15=0;
      

      Random r1=new Random();
      Random r2=new Random();   

      i1 = r1.nextInt(9);i1++;
      i2 = r1.nextInt(9);i2++;
      i3 = r1.nextInt(9);i3++;
      i4 = r1.nextInt(9);i4++;
      i5 = r1.nextInt(9);i5++;
      i6 = r1.nextInt(9);i6++;
      i7 = r1.nextInt(9);i7++;
      i8 = r1.nextInt(9);i8++;
      i9 = r1.nextInt(9);i9++;
      i10 = r1.nextInt(9);i10++;
      i11 = r1.nextInt(9);i11++;
      i12 = r1.nextInt(9);i12++;
      i13 = r1.nextInt(9);i13++;
      i14 = r1.nextInt(9);i14++;
      i15 = r1.nextInt(9);i15++;

//      out.println(""+i1+""+i2+""+i3+""+i4+""+i5+""+i6+""+i7+""+i8+""+i9+""+i10+" ");

      int i=0;


      
      i=i+i1*1000000000;
      i=i+i2*100000000;
      i=i+i3*10000000;
      i=i+i4*1000000;
      i=i+i5*100000;
      i=i+i6*10000;
      i=i+i7*1000;
      i=i+i8*100;
      i=i+i9*10;
      i=i+i10;


      

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Democom2\">");


      out.println("<br>");
      out.println("<center><table border=0>");
      out.println("<tr><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">VF>v0L  G\\AZ</font></strong></th>");
      out.println("<td><strong><font face=\"arial\" size=\"4\" color=\"\">:=</font></strong></td>");
      out.println("<td><strong><input type=\"text\" name=\"uid\" size=\"30\" value=\""+i1+""+i2+""+i3+""+i4+""+i5+""+i6+""+i7+""+i8+""+i9+""+i10+""+i11+""+i12+""+i13+""+i14+""+i15+"\" disabled style=\"font-size:15pt\"></strong></td></tr>");
      out.println("<tr><td></td><td></td></tr>");

      out.println("<tr><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">5F;J0\"</font></strong></th>");
      out.println("<td><strong><font face=\"arial\" size=\"4\" color=\"\">:=</font></strong></td>");
      out.println("<td><input type=\"text\" name=\"pwd\" size=\"30\" style=\"font-size:15pt\"></strong></td></tr>");
      out.println("</table></center>");

      out.println("<input type=\"hidden\" name=\"uid\"  value=\""+i1+""+i2+""+i3+""+i4+""+i5+""+i6+""+i7+""+i8+""+i9+""+i10+""+i11+""+i12+""+i13+""+i14+""+i15+"\" >");
      out.println("<br>");
      out.println("<center><input  type=\"submit\" value=\"5F;J0 VF5L VF NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center> ");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");



}
}



