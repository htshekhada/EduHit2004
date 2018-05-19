import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Shortque1 extends HttpServlet
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
//          response.sendRedirect("/servlet/Login");
//          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

////**********************Inserting into subject table**********
       String  l1,s1,s2,r1=null,w1=null,w2=null,q1=null;
       String qfield=null,Quetype=null,fname=null,Quetypeo=null;
       int q2=0;

       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;
       String subject=null,lno=null,std=null,qt=null,htm1=null;

       s2=request.getParameter("subject");
       s1=request.getParameter("std");
       l1=request.getParameter("lno");
       q1=request.getParameter("question");
       r1=request.getParameter("rightans");
       htm1=request.getParameter("hts");


       Quetype=request.getParameter("qtype");
       Quetypeo=request.getParameter("qtype");

       qfield="sho";

       fname=request.getParameter("F_name");
       String fon2=fname.replace('!',' ');

       
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 con.setAutoCommit(true); 
                 stmt = con.createStatement();

                
                        rs=stmt.executeQuery("select fontname as f2 from subject where std="+s1+" and sub_name='"+s2+"'");        
                        rs.next();
                        String fo2=rs.getString("f2");
                     //   out.println(""+fo2+"");


                         rs=stmt.executeQuery("select max(queno) as qn from "+s2+s1+"" );
                         rs.next();
                         q2=rs.getInt("qn");
                         q2++;

                      if(r1!=null &&  q1!=null )
                          {

                            String str1=null,str2=null,str3=null,str4=null,les="&lt;";
                            int ind1=0,ind2=0;

                            if(htm1.equals("hit"))
                             {
                           
                            for(int str=0;str<q1.length();str++)
                               {
                                 ind1=q1.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=q1.substring(ind1+1);
                                   str2=q1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   q1=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(q1);


                            for(int str=0;str<r1.length();str++)
                               {
                                 ind1=r1.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r1.substring(ind1+1);
                                   str2=r1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r1=str2.concat(str1);
                                  }
                               }
                           //t  System.out.println(r1);

                             }

                             les="''";

                            ind1=q1.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=q1.substring(ind1+1);
                                   str2=q1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   q1=str2.concat(str1);
                                  }
                                 ind1=q1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(q1);


                            ind1=r1.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r1.substring(ind1+1);
                                   str2=r1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r1=str2.concat(str1);
                                  }
                                 ind1=r1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=Quetype.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=Quetype.substring(ind1+1);
                                   str2=Quetype.substring(0,ind1);
                                   str2=str2.concat(les);
                                   Quetype=str2.concat(str1);
                                  }
                                 ind1=Quetype.indexOf("'",ind1+2);
                               }
                            //t System.out.println(Quetype);


                         if(r1.length() != 0 && q1.length() != 0 )
                         stmt.executeUpdate("INSERT INTO "+s2+s1+" values("+q2+",'"+qfield+"','"+Quetype+"','"+q1+"','"+r1+"','"+w1+"','"+w2+"',"+s1+","+l1+",'"+fon2+"')");
                         }




                        out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Shortque1\" target=\"bottom\">");

                        
                        out.println("<strong><center><font face=\"Times New Roman\" size=\"4\">Que No.- </font>"+q2+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\">Give Question & It's Answer</font> </center></strong>");
                 

                        out.println("<center>");
                        out.println("<p><strong>&nbsp;<font face=\"Times New Roman\" size=\"4\">Question</font>: </strong>");
                        out.println(" <strong>");
                     
                        out.println("<input type=\"text\" name=\"question\" size=\"70\" maxlength=\"200\"  style=\"font-family : "+fon2+";font-size:15pt\"></strong></p>");
                        out.println("</center>");

                        out.println("<center>");
                        out.println("<p><strong><font face=\"Times New Roman\" size=\"4\">Answer</font>:</strong>");
                        
                        out.println("<input  type=\"text\" name=\"rightans\" size=\"70\" maxlength=\"200\"  style=\"font-family:Times New Roman;font-size:15pt\" ></strong></p>");
                        out.println("</center>");



                        out.println("<center>");
                        out.println("<input  type=\"submit\" value=\"Click This Button To Enter Question\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\">");
                     
                        out.println("</center>");                       




                        out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+s1+"\">"); 
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+l1+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+s2+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"qtype\" VALUE=\""+Quetypeo+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"hts\" VALUE=\""+htm1+"\">"); 

                        out.println("<INPUT TYPE=\"hidden\" NAME= \"F_name\" VALUE=\""+fname+"\">");
                        out.println("</form>");
                        

                      


/*              if(r1!=null && w1!=null && w2!=null && q1!=null )
                  {
                 rs=stmt.executeQuery("select max(queno) as qn from "+s2+s1+"" );
                 rs.next();
                 int q2=rs.getInt("qn");
                 q2++;
                 stmt.executeUpdate("INSERT INTO "+s2+s1+" values("+q2+",'"+q1+"','"+r1+"','"+w1+"','"+w2+"',"+s1+","+l1+")");
                 }
                 */

       }

      catch (Exception e) {
                                      out.println("could not connect : The values you have entered is already exist ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                     }
                   finally       {
                        if(rs != null) {
                                            try { rs.close(); }
                                             catch (SQLException ignore)  { }
                                            }
                        if(stmt != null) {
                                            try { stmt.close(); }
                                            catch (SQLException ignore) { }
                                            }
                        if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                            }

                          }
                   

     out.println("</body>");
     out.println("</html>");
    }
}



