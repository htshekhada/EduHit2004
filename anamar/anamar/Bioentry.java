import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.math.*;


public class Bioentry extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");

      String memid=null;
      memid = request.getParameter("memberid");



      int m1=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getMonth();




out.println("</head>");



    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
    //  out.println("<body bgcolor=\"rgb(254,255,225)\">");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");



      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"4\" color=\"RED\">ANAMICA MARKETING</font></marquee></strong>");

      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();

             rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+memid+"';");
    if(rs.next() ) {
                                            
                          String h1 = rs.getString("receiptno");
                          String h2 = rs.getString("memberid");
                          String h3 = rs.getString("appdtd");
                          String h4 = rs.getString("appdtm");
                          String h5 = rs.getString("appdty");
                          String h6 = rs.getString("appname");
                          String h7 = rs.getString("address");
                          String h8 = rs.getString("place");
                          String h9 = rs.getString("state");
                          String h10 = rs.getString("pinno");
                          String h11 = rs.getString("email");
                          String h12 = rs.getString("pho");
                          String h13 = rs.getString("phr");
                          String h14 = rs.getString("mobile");
                          String h15 = rs.getString("contper");
                          String h16 = rs.getString("designation");
                          String h17 = rs.getString("appage");
                          String h18 = rs.getString("sex");
                          String h19 = rs.getString("appbod");
                          String h20 = rs.getString("nominame");
                          String h21 = rs.getString("relation");
                          String h22 = rs.getString("nomiage");
                          String h23 = rs.getString("nomibod");
                          String h24 = rs.getString("introname");
                          String h25 = rs.getString("introid");
                          String h26 = rs.getString("agentname");
                          String h27 = rs.getString("agentid");
                          



      out.println("<center>");
                                  

//      out.println("</table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");
      

      out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Bioentry1\">");

      
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Receipt No.</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"nn1\" size=\"30\" value=\""+h1+"\" disabled  style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Member ID.No</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"nn2\" size=\"30\"  value=\""+h2+"\"   style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Date</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn3\" size=\"1\"  value=\""+h3+"\" style=\"font-family:Times New Roman;font-size:\" >");
      for(int i=1;i<=31;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Month</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn4\" size=\"1\"  value=\""+h4+"\" style=\"font-family:Times New Roman;font-size:\" >");
      m1++;
      if(m1==13)
               m1=1;

      out.println("<option value="+m1+">"+m1+"</option>");
      for(int i=1;i<=12;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Year</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn5\" size=\"1\"  value=\""+h5+"\" style=\"font-family:Times New Roman;font-size:\" >");
      for(int i=2002;i<=2099;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select></tr>");






      out.println("</table>");

      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Name Of Applicant</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n1\"  value=\""+h6+"\" size=\"30\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Address</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n2\" value=\""+h7+"\"  size=\"30\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

      out.println("</tr></table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");


      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Place</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"n3\" size=\"1\"  value=\""+h8+"\" style=\"font-family:Times New Roman;font-size:\" >");
                
      rs = stmt.executeQuery("SELECT cityname AS c1 FROM city ;");
      while(rs.next() ) {
                                            
                          String st1 = rs.getString("c1");
                          out.println("<option value="+st1+">"+st1+"</option>");
                        }


     out.println(" </select> </strong></p></th>");
      

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">State</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n4\"  value=\""+h9+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Pin No</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n5\"  value=\""+h10+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">E-mail</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n6\"  value=\""+h11+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

      out.println("</tr></table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");



      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Cont.No(O)</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n7\"  value=\""+h12+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Cont.No(R)</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n8\"  value=\""+h13+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Mobile</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n9\"  value=\""+h14+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></TR>");


      out.println("</table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");


      out.println("<TR><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Contact Person</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n10\"  value=\""+h15+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Designation</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n11\"  value=\""+h16+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

      out.println("</table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");



      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Age</font></strong></th>");
      out.println("<th><p align=\"left\"><input  name=\"n12\" size=\"1\"  value=\""+h17+"\" style=\"font-family:Times New Roman;font-size:\" >");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Sex</font></strong></th>");
      out.println("<th><p align=\"left\"><SELECT name=\"n13\" size=\"1\"  value=\""+h18+"\" style=\"font-family:Times New Roman;font-size:\">");
      out.println("<option value=MALE>MALE</option>");
      out.println("<option value=FEMALE>FEMALE</option></select>");


      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">BirthDate</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n14\"  value=\""+h19+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");


      out.println("</table>");
      out.println("<br>");
      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");



      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Nominee Name</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n15\"  value=\""+h20+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Relation</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n16\"  value=\""+h21+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

      out.println("</table>");
      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");



      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Age</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n17\"  value=\""+h22+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">BirthDate</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n18\"  value=\""+h23+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");


      out.println("</table>");
      out.println("<br>");
      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");
      

  



      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Introducer Name</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n19\"  value=\""+h24+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Int. ID</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"n20\" size=\"1\"  value=\""+h25+"\"  disabled  style=\"font-family:Times New Roman;font-size:\" >");

      out.println("<option value=am11>am11</option>"); //**by default
      rs = stmt.executeQuery("SELECT memberid AS c1 FROM appform ;");
      while(rs.next() ) {
                                            
                          String st1 = rs.getString("c1");
                          out.println("<option value="+st1+">"+st1+"</option>");
                        }


     out.println(" </select> </strong></p></th>");



      out.println("</table>");
      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");


      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Agent Name</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n21\"  value=\""+h26+"\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");



//********************** <option value=\"computer\">computer</option>
      


     

                 out.println("<tr><th><p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Agent ID</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"n22\"  value=\""+h27+"\" size=\"1\"  disabled  style=\"font-family:Times New Roman;font-size:\" >");
                 
                 rs = stmt.executeQuery("SELECT agentid AS c1 FROM agent ;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String st1 = rs.getString("c1");
                                    out.println("<option value="+st1+">"+st1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");

     



      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");
      out.println("<p><input type=\"submit\" value=\"Submit\" name=\"submit\" >");
      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form><br>");

}
       out.println("<center><a href=\"file://c:/anamica/anamica.htm\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Home</font>");  
       out.println("</a></center>");







       out.println("<br><br><br><br><br><center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");


      out.println("</body>");
      out.println("</html>");




             }
      catch (Exception e) {
                                      out.println("Please Enter valid Value");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }
        finally {
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


this.destroy();
}





public String introidserch(String intid,int lvl)
  {
      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;

      int flag=0,flag1=0;
      String memid=intid;
      String levelids[] = new String[2000];

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();

                 rs = stmt.executeQuery("SELECT count(*) as cn  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                 rs.next(); 
                 int dm = rs.getInt("cn");
                 if(dm < 3)
                   {
                     System.out.println(""+intid+"---"+lvl+"");
                     rs1=stmt1.executeQuery("select count(*) as cc from leveltemp;");
                     rs1.next();
                     int no1= rs1.getInt("cc");
                  //   no1++;
                     stmt1.executeUpdate("insert into leveltemp values("+no1+",'"+intid+"',"+lvl+")");
                     memid=intid;
                     flag=1;
                   }
             
                  rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                  while(rs.next())
                     {
                                            

                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                         /*
                          memid=search3id(mid);
                          if(!memid.equals("aa"))
                               {
                          //       continue hit;
                          //     }
                        //  else {
                          //      System.out.println("memid="+memid+"**level="+lvl+"<br>");
                                // flag1=1;
                                // break hit;
                               }
                          */

                          memid=introidserch(mid,lvl+1);


                     }

                        //        if((Math.pow(3,level)) < contlim)
                        //            memid=introidserch(memid,0,contlim,level);   
             
        }
      catch (Exception e) {
                                      System.out.println("Please enter all Required Value");
                                      System.out.println("<pre>");
                                      System.out.println(e.getMessage());
                                      System.out.println("</pre>");
                                       }
        finally {
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


    return memid;
  }





//************for counting 3 direct mem**********
/*

public String search3id(String intid)
  {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;

      String memid="aa";


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();

                     
                 rs = stmt.executeQuery("SELECT count(*) as cn  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                 rs.next(); 
                 int dm = rs.getInt("cn");

                 if(dm < 3)
                 {
             //      System.out.println(intid);
                   memid=intid;
                   
                 } 

                 
        }
      catch (Exception e) {
                                      System.out.println("Please enter all Required Value");
                                      System.out.println("<pre>");
                                      System.out.println(e.getMessage());
                                      System.out.println("</pre>");
                                       }
        finally {
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


    return memid;
  }

*/



}



