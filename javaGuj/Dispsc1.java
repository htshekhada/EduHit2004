import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Dispsc1 extends HttpServlet
{
 
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {  
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      HttpSession session = request.getSession(true);
/*      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
*/      

      int et=0,cc=0,ccm=0,roll2=0,std2=0;
      String s1=null,s2=null,cl2=null,name2=null,e1=null;
      String stdsub=null,q1=null,std=null,cl=null,d1=null,m1=null;
      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"pink\">");


      std=request.getParameter("standard");
      cl=request.getParameter("class");
      d1=request.getParameter("date");
      m1=request.getParameter("month");


      q1 = request.getParameter("quen");
      e1=request.getParameter("em");
      String em=e1.replace('!',' ');



      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;

      



//     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Updatelongq1\">");



     

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                 stmt2= con.createStatement();
                 stmt3= con.createStatement();

                 rs = stmt.executeQuery("SELECT min(roll_no) as c1 FROM result where roll_no >= "+q1+" and std="+std+" and class='"+cl+"' and date1="+d1+" and month1="+m1+" ");
                 rs.next();
                 ccm = rs.getInt("c1");
                 
                     

                 out.println("<strong>");
                 out.println("<center>");
                 int mmx=ccm+6;
                 //out.println(q1);
               //  out.println("results from "+ccm+" to "+mmx+"");
                 out.println("</center>");
                 out.println("</strong>");
             
          
                 rs = stmt.executeQuery("SELECT distinct std as ss,class as cc,roll_no as rr FROM result where  std="+std+" and class='"+cl+"' and date1="+d1+" and month1="+m1+"  order by roll_no ");
                 int nRows = 0;
              
               

                 while(rs.next()) {
                                            


                                    int roll1=rs.getInt("rr");
                                    int std1=rs.getInt("ss");
                                    String cl1=rs.getString("cc");

                                    rs3 = stmt3.executeQuery("SELECT name as nn FROM result where roll_no = "+roll1+" and std="+std+" and class='"+cl+"' ");
                                    rs3.next();
                                    String name1=rs3.getString("nn");
                                 
                           /*         if(rs.next())
                                      {
                                        
                                        roll2=rs.getInt("rr");
                                        std2=rs.getInt("ss");
                                        cl2=rs.getString("cc");

                                        rs3 = stmt3.executeQuery("SELECT name as nn FROM result where roll_no = "+roll2+" and std="+std+" and class='"+cl+"' ");
                                        rs3.next();

                                        name2=rs3.getString("nn");
                                      } 
                           */

                                    out.println("<table  border=\"0\" width=\"700\">");

                                    out.println("<tr>");
                                    out.println("<th width=\"300\">");
                                    out.println("<font face=\"Arial\" size=4>EducationHit : Subject Result Of Whole Standard</font>");
                                    out.println("</th>");

                                    out.println("<td width=\"20\"></td>");

                          /*          if(roll2!=0)
                                    {
                                    out.println("<th width=\"300\">");
                                    out.println("<font face=\"Arial\" size=4>Akshar Computer Center</font>");
                                    out.println("</th>");
                                    }
                          */

                                    out.println("</tr>");


                                    out.println("<tr>");
                                    out.println("<th width=\"300\">");
                                    out.println("<font face=\"Arial\" size=2>"+em+"</font>");
                                    out.println("</th>");

                                    out.println("<td width=\"20\"></td>");

                       /*             if(roll2!=0)
                                    {

                                    out.println("<th width=\"300\">");
                                    out.println("<font face=\"Arial\" size=2>"+em+"</font>");
                                    out.println("</th>");

                                    }
                      */

                                    out.println("</tr>");

                                    out.println("</table>");

                                    out.println("<table border=\"0\"  width=\"700\">");

                                    out.println("<tr>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Standard:</b>"+std1+"");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Class:</b>"+cl1+"");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Roll Number:</b>"+roll1+"");
                                    out.println("</td>");

                                    out.println("<td width=\"20\"></td>");


                    /*                if(roll2!=0)
                                    {

                                    out.println("<td width=\"100\">");
                                    out.println("<b>Standard:</b>"+std2+"");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Class:</b>"+cl2+"");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Roll Number:</b>"+roll2+"");
                                    out.println("</td>");

                                    }
                     */

                                    out.println("</tr>");

                                    out.println("</table>");


                                //    rs = stmt.executeQuery("SELECT * FROM biodata where rollno = "+roll1+" and std="+std1+" and class='"+cl1+"' ");
                                //    rs.next();
                                //    String name1=rs.getString("name");

                                    out.println("<table border=\"0\"  width=\"700\">");
                                    out.println("<tr>");
                                    out.println("<td width=\"300\">");
                                    out.println("<b>Name:</b>"+name1+"");
                                    out.println("</td>");

                                    out.println("<td width=\"20\"></td>");

                   /*                 if(roll2!=0)
                                    {

                                    out.println("<td width=\"300\">");
                                    out.println("<b>Name:</b>"+name2+"");
                                    out.println("</td>");

                                    }

                   */
                                    out.println("</tr>");
                                    out.println("</table>");

                                    out.println("<table border=\"0\"  width=\"700\">");
                                    out.println("<tr>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Subject</b>");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Total Marks</b>");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Obtained Marks</b>");
                                    out.println("</td>");

                                    out.println("<td width=\"20\"></td>");

                  /*                  if(roll2!=0)
                                    {

                                    out.println("<td width=\"100\">");
                                    out.println("<b>Subject</b>");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Total Marks</b>");
                                    out.println("</td>");
                                    out.println("<td width=\"100\">");
                                    out.println("<b>Obtained Marks</b>");
                                    out.println("</td>");

                                    }
                  */

                                    out.println("</tr>");
                                    out.println("</table>");


                                    int totalobtained=0;
                                    int totalmarks=0;
                                    int totalobtained2=0;
                                    int totalmarks2=0;

                                    rs1 = stmt1.executeQuery("SELECT * FROM result where roll_no="+roll1+" and std="+std1+" and class='"+cl1+"' and date1="+d1+" and month1="+m1+"  order by sub  ");
                                    rs2 = stmt2.executeQuery("SELECT * FROM result where roll_no="+roll2+" and std="+std2+" and class='"+cl2+"' and date1="+d1+" and month1="+m1+"  order by sub  ");

                                    while(rs1.next())
                                      {
                                        String sub1=rs1.getString("sub");
                                        int topt=rs1.getInt("tot_opt");
                                        int tsho=rs1.getInt("tot_sho");
                                        int tlon=rs1.getInt("tot_lon");
                                        int tjoi=rs1.getInt("tot_joi");

                                        int jopt=rs1.getInt("j_opt");
                                        int jsho=rs1.getInt("j_sho");
                                        int jlon=rs1.getInt("j_lon");
                                        int jjoi=rs1.getInt("j_joi");
                                        
                                        int totalt=topt+tsho+tlon+tjoi;
                                        int totalj=jopt+jsho+jlon+jjoi;

                                        totalmarks=totalmarks+totalt;
                                        totalobtained=totalobtained+totalj;




                                        out.println("<table border=\"0\"   width=\"700\">");
                                        out.println("<tr>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+sub1+"");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalt+"");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalj+"");
                                        out.println("</td>");

                                        out.println("<td width=\"20\"></td>");

                        /*                if(rs2.next())
                                         {
                                        String sub2=rs2.getString("sub");
                                        int topt2=rs2.getInt("tot_opt");
                                        int tsho2=rs2.getInt("tot_sho");
                                        int tlon2=rs2.getInt("tot_lon");
                                        int tjoi2=rs2.getInt("tot_joi");

                                        int jopt2=rs2.getInt("j_opt");
                                        int jsho2=rs2.getInt("j_sho");
                                        int jlon2=rs2.getInt("j_lon");
                                        int jjoi2=rs2.getInt("j_joi");
                                        
                                        int totalt2=topt2+tsho2+tlon2+tjoi2;
                                        int totalj2=jopt2+jsho2+jlon2+jjoi2;

                                        totalmarks2=totalmarks2+totalt2;
                                        totalobtained2=totalobtained2+totalj2;




                                        out.println("<td width=\"100\">");
                                        out.println(""+sub2+"");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalt2+"");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalj2+"");
                                        out.println("</td>");




                                         }
                                        else{
                                            out.println("<td width=\"100\"></td>");
                                            out.println("<td width=\"100\"></td>");
                                            out.println("<td width=\"100\"></td>");
                                            }
                      */



                                        out.println("</tr>");
                                        out.println("</table>");
                                       }  


                                        out.println("<table  border=\"0\"   width=\"700\">");
                                        out.println("<tr>");
                                        out.println("<td width=\"100\">");
                                        out.println("<b>Signature</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println("<b>Total Marks</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalobtained+"");
                                        out.println("</td>");

                                        out.println("<td width=\"20\"></td>");

                        /*            if(roll2!=0)
                                    {

                                        out.println("<td width=\"100\">");
                                        out.println("<b>Signature</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println("<b>Total Marks</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+totalobtained2+"");
                                        out.println("</td>");

                                    }

                   */

                                        out.println("</tr>");
                                        out.println("</table>");

                                        float per=totalobtained*100/totalmarks;
                                        float per2=0;
                     /*               if(roll2!=0)
                                    {

                                         per2=totalobtained2*100/totalmarks2;
                                    }
                     */

                                        out.println("<table  border=\"0\"   width=\"700\">");
                                        out.println("<tr>");
                                        out.println("<td width=\"100\">");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println("<b>Percentage</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+per+"");
                                        out.println("</td>");


                                        out.println("<td width=\"20\"></td>");

                      /*              if(roll2!=0)
                                    {

                                        out.println("<td width=\"100\">");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println("<b>Percentage</b>");
                                        out.println("</td>");
                                        out.println("<td width=\"100\">");
                                        out.println(""+per2+"");
                                        out.println("</td>");

                                    }
                     */

                                        out.println("<tr>");
                                        out.println("</table>");
                                        out.println("<br>");



                                    
                                   }
                 out.println("</table>");
                 out.println("</center>");

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }


  

     out.println("<center>");
     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispsc1\">");
     ccm=ccm+6;

     String ss2=em.replace(' ','!');

     out.println("<input type=\"hidden\" value=\""+ccm+"\" name=\"quen\">");
     out.println("<input type=\"hidden\" value=\""+std+"\" name=\"standard\">");
     out.println("<input type=\"hidden\" value=\""+cl+"\" name=\"class\">");
     out.println("<input type=\"hidden\" value=\""+ss2+"\" name=\"em\">");
     out.println("<input type=\"hidden\" value=\""+d1+"\" name=\"date\">");
     out.println("<input type=\"hidden\" value=\""+m1+"\" name=\"month\">");
     out.println("<input  type=\"submit\" value=\"Next\" name=\"Next\">");
     out.println("<center>");
     out.println("</form>");

   
   
     out.println("</body>");
     out.println("</html>");
    }

}


