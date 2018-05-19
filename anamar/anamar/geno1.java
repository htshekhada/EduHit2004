import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class geno1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

      String memid=null;
      memid = request.getParameter("memberid");


      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"4\" color=\"RED\">ANAMICA MARKETING</font></marquee></strong>");

    out.println("<br><br><br>");

     out.println("<BR><BR><table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

    out.println("<tr>");
    out.println("<th>No</th>");


    out.println("<th>ID</th>");


    out.println("<th>Name</th>");


    out.println("<th>Intro. ID</th>");


    out.println("<th>Agent ID</th></tr>");

    out.println("<tr><th>LEVEL--0::</th><th></th><th></th><th></th><th></th></tr>");

      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();


                                  


   //   out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/geno1\">");

      
      

                
      rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+memid+"';");
      if(rs.next() ) {
                                            
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>1</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");


                        
                        }


    

    out.println("<tr><th>LEVEL--1::</th><th></th><th></th><th></th><th></th></tr>");

    int level1i=0,level2i=0;
    String level11="aa";
    String level12="aa";
    String level13="aa";
    String level21="aa";
    String level22="aa";
    String level23="aa";
    String level24="aa";
    String level25="aa";
    String level26="aa";
    String level27="aa";
    String level28="aa";
    String level29="aa";

    String level1[]={"","",""};
    int number[] = new int[12];






      rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+memid+"' and memberid <> '"+memid+"';");
      while(rs.next() ) {
                                            

                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                    level1i=level1i+1;

                    if(level1i <= 3)
                      {
                        if(level1i==1)
                                  level11=mid;
                        if(level1i==2)
                                  level12=mid;
                        if(level1i==3)
                                  level13=mid;

                      }


                   }














     int level11i=0;

     if(!level11.equals("aa"))
     {
     rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+level11+"';");
     while(rs.next() ) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          

                          if(level11i <=4)
                           {
                              level11i=level11i+1;

                              if(level11i ==1)
                                       level21=mid;
                              if(level11i ==2)
                                       level22=mid;
                              if(level11i ==3)
                                       level23=mid;

                           }

                   }

     }

if(level11i <= 3)
   {
      
         
         rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+memid+"' and memberid <> '"+memid+"' and memberid <> '"+level11+"' and memberid <> '"+level12+"' and memberid <> '"+level13+"';");
         while(rs.next() ) {
                                            
                       
                                  String mid = rs.getString("memberid");
                                  String appname = rs.getString("appname");
                                  String introid = rs.getString("introid");
                                  String agentid = rs.getString("agentid");

                                  
                                  level11i=level11i+1;
                                  if(level11i <=3)
                                   {
                                      if(level11i ==1)
                                               level21=mid;
                                      if(level11i ==2)
                                               level22=mid;
                                      if(level11i ==3)
                                               level23=mid;

                                   }

                        }

   }




     int level12i=0;

     if(!level12.equals("aa"))
     {
     rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+level12+"';");
     while(rs.next() ) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          

                          if(level12i <=4)
                           {
                              level12i=level12i+1;
                              if(level12i == 1)
                                       level24=mid;
                              if(level12i == 2)
                                       level25=mid;
                              if(level12i == 3)
                                       level26=mid;

                           }

                   }

     }



if(level12i <= 3)
   {
      
         
         rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+memid+"' and memberid <> '"+memid+"' and memberid <> '"+level11+"' and memberid <> '"+level12+"' and memberid <> '"+level13+"' and memberid <> '"+level21+"' and memberid <> '"+level22+"' and memberid <> '"+level23+"';");
         while(rs.next() ) {
                                            
                       
                                  String mid = rs.getString("memberid");
                                  String appname = rs.getString("appname");
                                  String introid = rs.getString("introid");
                                  String agentid = rs.getString("agentid");

                                  
                                  level12i=level12i+1;
                                  if(level12i <=3)
                                   {
                                      if(level12i ==1)
                                               level24=mid;
                                      if(level12i ==2)
                                               level25=mid;
                                      if(level12i ==3)
                                               level26=mid;

                                   }

                        }

   }





     int level13i=0;

     if(!level13.equals("aa"))
     {
     rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+level13+"';");
     while(rs.next() ) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          

                          if(level13i <=4)
                           {
                              level13i=level13i+1;
                              if(level13i ==1)
                                       level27=mid;
                              if(level13i ==2)
                                       level28=mid;
                              if(level13i ==3)
                                       level29=mid;

                           }

                   }

     }



if(level13i <= 3)
   {
      
         
         rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+memid+"' and memberid <> '"+memid+"' and memberid <> '"+level11+"' and memberid <> '"+level12+"' and memberid <> '"+level13+"' and memberid <> '"+level21+"' and memberid <> '"+level22+"' and memberid <> '"+level23+"' and memberid <> '"+level24+"' and memberid <> '"+level25+"' and memberid <> '"+level26+"';");
         while(rs.next() ) {
                                            
                       
                                  String mid = rs.getString("memberid");
                                  String appname = rs.getString("appname");
                                  String introid = rs.getString("introid");
                                  String agentid = rs.getString("agentid");

                                  
                                  level13i=level13i+1;
                                  if(level13i <=3)
                                   {
                                   
                                      if(level13i == 1)
                                               level27=mid;
                                      if(level13i == 2)
                                               level28=mid;
                                      if(level13i == 3)
                                               level29=mid;

                                   }

                        }

   }









//**************************print**************

     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level11+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>A</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>A</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");


                   }





     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level12+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>B</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>B</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");


                   }




     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level13+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>C</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>C</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");


                   }


//*****level2********


    out.println("<tr><th>LEVEL--2::</th><th></th><th></th><th></th><th></th></tr>");

    int level21f=0,level22f=0,level23f=0,level24f=0,level25f=0,level26f=0,level27f=0,level28f=0,level29f=0;


     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level21+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>A1</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>A1</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");
                          level21f=1;

                   }


     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level22+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>A2</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                          out.println("<tr><th>A2</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");
                                            
                          level22f=1;
                   }







     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level23+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>A3</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>A3</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level23f=1;
                   }










     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level24+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>B1</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>B1</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level24f=1;

                   }




     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level25+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>B2</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>B2</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level25f=1;
                   }




     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level26+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>B3</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>B3</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level26f=1;
                   }



     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level27+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>C1</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>C1</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level27f=1;
                   }


     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level28+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>C2</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>C2</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level28f=1;
                   }




     rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+level29+"';");
     if(rs.next()) {
                                            
                       
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                          out.println("<tr><th>C3</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");



                   }
     else          {
                                            
                          out.println("<tr><th>C3</th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th>");
                          out.println("<th></th></tr>");

                          level29f=1;
                   }





          
                 
     out.println("</table>");

      out.println("<br>");
//      out.println("<p><center><input type=\"submit\" value=\"Submit\" name=\"submit\" >");
//      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form></center><br><br><br><br><br>");


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
                                      out.println("Please enter all Required Value");
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


//this.destroy();
}
}



