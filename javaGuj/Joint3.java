import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Joint3 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();


      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

//      if((userid==null) || (password==null))
//         {
//          response.sendRedirect("/servlet/Login");
//          return;
//         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

////**********************Inserting into subject table**********
       String  l1,s1,s2,w1=null,w2=null,q1=null,qq2=null,q3=null,q4=null,q5=null,r1=null,r2=null,r3=null,r4=null,r5=null,fname=null;
       int q2=0;

       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;
       String subject=null,lno=null,std=null,qt=null,qto=null;
       String qfield=null,htm1=null;


       s2=request.getParameter("subject");
       s1=request.getParameter("std");
       l1=request.getParameter("lno");
       q1=request.getParameter("question1");
//       qq2=request.getParameter("question2");
//       q3=request.getParameter("question3");
//       q4=request.getParameter("question4");
//       q5=request.getParameter("question5");
       r1=request.getParameter("rightans1");
//       r2=request.getParameter("rightans2");
//       r3=request.getParameter("rightans3");
//       r4=request.getParameter("rightans4");
//       r5=request.getParameter("rightans5");
       qt=request.getParameter("qtype");
       qto=request.getParameter("qtype");
       htm1=request.getParameter("hts");

       qfield="joi";

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

                      if(q1!=null && r1!=null )
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
                            //t System.out.println(r1);


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



                            ind1=qt.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=qt.substring(ind1+1);
                                   str2=qt.substring(0,ind1);
                                   str2=str2.concat(les);
                                   qt=str2.concat(str1);
                                  }
                                 ind1=qt.indexOf("'",ind1+2);
                               }
                            //t System.out.println(qt);



                         if(r1.length() != 0 && q1.length() != 0 )
                         stmt.executeUpdate("INSERT INTO "+s2+s1+" values("+q2+",'"+qfield+"','"+qt+"','"+q1+"','"+r1+"','1','1',"+s1+","+l1+",'"+fon2+"')");
                         con.commit();
                         }




                        out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Joint3\" target=\"bottom\">");

                        out.println("<strong><center><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`G G\\AZ </font>"+q2+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\">5|`G VG[ T[GM HJFA VF5M</font> </center></strong>");

                 
                        out.println("<center><table border=\"6\" width=\"453\" height=\"44\"  >");
                      
                        out.println("<tr><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`G</font></strong></th></tr>");
                        out.println("<tr><th><input type=\"text\" name=\"question1\" size=\"60\" maxlength=\"255\"   style=\"font-family : "+fon2+";font-size:15pt\"></th></tr>");

                        out.println("<tr><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\"> HJFA </font></strong></th></tr>");
                        out.println("<tr><th><input  type=\"text\" name=\"rightans1\" size=\"60\" maxlength=\"255\"   style=\"font-family : "+fon2+";font-size:15pt\" ></th></tr>");
                                


                        out.println("</table>");
                        out.println("</center>");


                        out.println("<center>");
                        out.println("<input  type=\"submit\" value=\"5|`G NFB, SZJF VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 24pt\">");
                        
                        out.println("</center>");                       




                        out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+s1+"\">"); 
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+l1+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+s2+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"qtype\" VALUE=\""+qto+"\">");
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



