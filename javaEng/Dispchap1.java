import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispchap1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();
      String sub=null,std=null,fon1=null,fon2=null,fon3=null,fon4=null,ch=null;
      


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title><center><b>School,College Or Instute Name</b></center>");
      out.println("</head>");
  //  out.println("<br>");
  //  out.println("<body background=\"c:/onlinexam/img/3.jpg\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
  

      Connection con=null;
      Statement stmt=null;
      Statement stmt1=null;
      ResultSet rs=null;
      ResultSet rs1=null;

      std=request.getParameter("standard");
      sub=request.getParameter("subject");
      ch=request.getParameter("Chapter");      


        try
           {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:usda");
           stmt = con.createStatement();
          out.println("<center>");

          out.println("<b>Standard:"+std+"</b>");

          out.println("&nbsp;&nbsp;&nbsp;");

          out.println("<b>Subject:"+sub+"&nbsp;&nbsp;&nbsp;&nbsp;Chapter:"+ch+"</b>");
          out.println("</center>");
//          out.println("<br><br>");
          

          
//******************************Logic for displaying optional questions
          rs=stmt.executeQuery("select count(*) as coun from "+sub+std+" where quefield='opt' and chap="+ch+" ");
          rs.next();
          int coun1=rs.getInt("coun");

          int nopages=coun1/17;
          int nopages1=coun1%17;
          if(nopages1=='0')
            {
            nopages++;                                                                         //No.of pages="+nopages+"   
            }
          out.println("<center><b>Number of Optional Type Questions="+coun1+"&nbsp;&nbsp;&nbsp; </b></center><br>");
          rs=stmt.executeQuery("select * from "+sub+std+" where quefield='opt' and chap="+ch+" ");
          int i=0;
          while(rs.next())
            {
             String que=rs.getString("que");
             String right1=rs.getString("right1");
             String wrong1=rs.getString("wrong1");
             String wrong2=rs.getString("wrong2");
           //  String chap=rs.getString("chap");
                      fon1=rs.getString("fname");
             i++;

             out.println("<center><table border=0  width=700>");
             out.println("<tr><td>");
             out.println("<b> "+i+"::&nbsp;&nbsp;<font face=\""+fon1+"\">"+que+"</font></td></tr></b>");
          //   out.println("<font face=\""+fon1+"\"> ");
             out.println("<tr><td>");
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>1.&nbsp;&nbsp;</b><font face=\""+fon1+"\">"+right1+"</font> <b>&nbsp;&nbsp;&nbsp;2.&nbsp;&nbsp;</b><font face=\""+fon1+"\">"+wrong1+"</font> <b>&nbsp;&nbsp;&nbsp;3.&nbsp;&nbsp;</b><font face=\""+fon1+"\">"+wrong2+"</font> ");
             out.println("</td></tr>");
             out.println("</table></center>");
//             out.println("<center>------------------------------------</center>");

            }

//******************************Logic for displaying Short questions
          rs=stmt.executeQuery("select count(*) as coun from "+sub+std+" where quefield='sho'and chap="+ch+"  ");
          rs.next();
          int coun2=rs.getInt("coun");

          int nopages2=coun2/17;
          int nopages3=coun2%17;
          if(nopages3=='0')
            {
            nopages2++;
            }

          out.println("<br><br>");
          out.println("<b><center>Number of Short Questions="+coun2+"</center></b>");
          out.println("<br><br>");

          rs=stmt.executeQuery("select * from "+sub+std+" where quefield='sho' and chap="+ch+" ");
          int j=0;
          while(rs.next())
            {
             String que1=rs.getString("que");
             String right11=rs.getString("right1");
      //       String chap1=rs.getString("chap");
               fon2=rs.getString("fname");

             j++;

             out.println("<center><table border=0  width=700>");
             out.println("<tr><td>");
             out.println("<b> "+j+"::&nbsp;&nbsp;<font face=\""+fon2+"\">"+que1+"</font></td></tr></b>");
             out.println("<tr><td>");
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Answer.&nbsp;&nbsp;<font face=\"arial\">"+right11+"</font> </b> ");
             out.println("</td></tr>");
             out.println("</table></center>");
//             out.println("<center>------------------------------------</center>");

            }



    
         


          
//******************************Logic for displaying long questions
          rs=stmt.executeQuery("select count(*) as coun from "+sub+std+"l where chap="+ch+"  ");
          rs.next();
          int coun3=rs.getInt("coun");

          int nopages4=coun3/5;
          int nopages5=coun3%5;
          if(nopages5=='0')
            {
            nopages4++;                                                                    //No. of pages="+nopages4+"  
            }
          out.println("<center><b>Number of Long Type Questions="+coun3+"&nbsp;&nbsp;&nbsp;  </b></center><br>");
          rs=stmt.executeQuery("select * from "+sub+std+"l where quefield='lon' and chap="+ch+" ");
          int k=0;
          while(rs.next())
            {
             String que=rs.getString("que");
             String righ1=rs.getString("right1");
             String wron1=rs.getString("wrong1");
             String wron2=rs.getString("wrong2");
//             String chap2=rs.getString("chap");
                      fon3=rs.getString("fname");
                  

             k++;

             out.println("<center><table border=0  width=700>");
             out.println("<tr><td>");
             out.println("<b> "+k+"::&nbsp;&nbsp;<pre><font face=\""+fon3+"\">"+que+"</font></pre></td></tr></b>");
          //   out.println("<font face=\""+fon1+"\"> ");
             out.println("<tr><td>");
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Ans:-&nbsp;&nbsp;<pre><font face=\""+fon3+"\">"+righ1+"</font></pre> &nbsp;&nbsp;&nbsp;<br>");
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wrong-1:-&nbsp;&nbsp;<pre><font face=\""+fon3+"\">"+wron1+"</font></pre><b>&nbsp;&nbsp;<br>");
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wrong-2:-&nbsp;&nbsp;<pre><font face=\""+fon3+"\">"+wron2+"</font></pre><b>&nbsp;&nbsp;<br>");
             out.println("</td></tr>");
             out.println("</table></center>");
 //            out.println("<center>------------------------------------</center>");

            }


//******************************Logic for displaying Matching Type questions
          rs=stmt.executeQuery("select count(*) as coun from "+sub+std+" where quefield='joi'and chap="+ch+"  ");
          rs.next();
          int coun4=rs.getInt("coun");

          int nopages6=coun4/5;
          int nopages7=coun4%5;
          if(nopages7=='0')
            {
            nopages6++;
            }
                                                                                         // No. of pages="+nopages6+"
          out.println("<br>");
          out.println("<b><center>Number of Matching Type Questions="+coun4+"&nbsp;&nbsp;&nbsp; </center></b>");
          out.println("<br>");

          rs=stmt.executeQuery("select * from "+sub+std+" where quefield='joi' and chap="+ch+" order by  queno ,wrong1");
          int l=0;


          out.println("<br>");
          while(rs.next())
            {

             int queno1=rs.getInt("queno");
             String que12=rs.getString("que");
             String right12=rs.getString("right1");
//             String chap12=rs.getString("chap");
             String wrong11=rs.getString("wrong1");
             String wrong22=rs.getString("wrong2");
                       fon4=rs.getString("fname");
             l++;




             out.println("<center><table border=0  width=700>");
             out.println("<tr><td width=\"41%\">");
             out.println("<b> "+queno1+"::&nbsp;&nbsp;<font face=\""+fon4+"\">"+que12+"</font></td><td width=\"4%\">--</td>");
             out.println("<td width=\"41%\">&nbsp;&nbsp;<font face=\""+fon4+"\">"+right12+"</font></td><td width=\"14%\"></b> ");
             out.println("</td></tr>");
             out.println("</table></center>");

            }




//******************************Logic for displaying variable long questions

          rs=stmt.executeQuery("select count(*) as coun from "+sub+std+"v  where chap="+ch+"    ");
          rs.next();
          int coun5=rs.getInt("coun");

          int nopages8=coun3/6;
          int nopages9=coun3%6;
          if(nopages9 < 6)
            {
            nopages8++;
            }


          out.println("<br><br>");
          out.println("<center><b>Variable Long Type Questions="+coun5+"  </b></center><br>");


          

         rs=stmt.executeQuery("select * from "+sub+std+"v  where chap="+ch+"   ");
                    while(rs.next())
            {
             String ques=rs.getString("que");
             int quesno=rs.getInt("queno");


                                    int rn = rs.getInt("rightno");
                                    int wn = rs.getInt("wrongno");




                                String ra1 = rs.getString("right1");
                                String ra2 = rs.getString("right2");
                                String ra3 = rs.getString("right3");
                                String ra4 = rs.getString("right4");
                                String ra5 = rs.getString("right5");
                                String ra6 = rs.getString("right6");
                                String ra7 = rs.getString("right7");
                                String ra8 = rs.getString("right8");
                                String ra9 = rs.getString("right9");
                                String ra10 = rs.getString("right10");
                                String ra11 = rs.getString("right11");
                                String ra12 = rs.getString("right12");
                                String ra13 = rs.getString("right13");
                                String ra14 = rs.getString("right14");
                                String ra15 = rs.getString("right15");
                                String ra16 = rs.getString("right16");
                                String ra17 = rs.getString("right17");
                                String ra18 = rs.getString("right18");
                                String ra19 = rs.getString("right19");
                                String ra20 = rs.getString("right20");



                                String wa1 = rs.getString("wrong1");
                                String wa2 = rs.getString("wrong2");
                                String wa3 = rs.getString("wrong3");
                                String wa4 = rs.getString("wrong4");
                                String wa5 = rs.getString("wrong5");
                                String wa6 = rs.getString("wrong6");
                                String wa7 = rs.getString("wrong7");
                                String wa8 = rs.getString("wrong8");
                                String wa9 = rs.getString("wrong9");
                                String wa10 = rs.getString("wrong10");
                                String wa11 = rs.getString("wrong11");
                                String wa12 = rs.getString("wrong12");
                                String wa13 = rs.getString("wrong13");
                                String wa14 = rs.getString("wrong14");
                                String wa15 = rs.getString("wrong15");
                                String wa16 = rs.getString("wrong16");
                                String wa17 = rs.getString("wrong17");
                                String wa18 = rs.getString("wrong18");
                                String wa19 = rs.getString("wrong19");
                                String wa20 = rs.getString("wrong20");




             String chapt=rs.getString("chap");
                    fon3=rs.getString("fname");

             

             out.println("<center><table border=0  width=700>");
             out.println("<tr><td>");
             out.println("<b> "+quesno+"::&nbsp;&nbsp;<font face=\""+fon3+"\">"+ques+"</font></b>");
 //            out.println("<td align=right><b>--"+chapt+"</b></td>");
             out.println("</tr></td>");
             out.println("<tr><td>");
             if(rn >= 1) out.println("<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:1.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra1+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 2) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:2.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra2+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 3) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:3.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra3+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 4) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:4.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra4+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 5) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:5.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra5+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 6) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:6.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra6+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 7) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:7.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra7+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 8) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:8.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra8+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 9) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:9.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra9+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 10) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:10.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra10+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 11) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:11.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra11+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 12) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:12.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra12+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 13) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:13.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra13+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 14) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:14.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra14+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 15) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:15.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra15+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 16) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:16.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra16+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 17) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:17.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra17+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 18) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:18.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra18+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 19) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:19.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra19+"</font> &nbsp;&nbsp;&nbsp;<br>");
             if(rn >= 20) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ans:20.&nbsp;&nbsp;<font face=\""+fon3+"\">"+ra20+"</font> &nbsp;&nbsp;&nbsp;<br>");





             if(wn >= 1) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa1+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 2) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa2+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 3) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa3+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 4) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa4+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 5) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa5+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 6) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa6+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 7) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa7+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 8) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa8+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 9) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa9+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 10) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa10+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 11) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa11+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 12) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa12+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 13) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;13.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa13+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 14) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;14.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa14+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 15) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa15+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 16) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa16+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 17) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;17.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa17+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 18) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;18.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa18+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 19) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;19.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa19+"</font><b>&nbsp;&nbsp;<br>");
             if(wn >= 20) out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20.&nbsp;&nbsp;<font face=\""+fon3+"\">"+wa20+"</font>&nbsp;&nbsp;<br>");



             out.println("</b></td></tr>");
             out.println("</table></center>");
      

            }











                   out.println("<center>------------------------------------</center>");
                   out.println("<center>--------------------</center>");
                
       out.println("<br>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">Developed By...</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">Hiteshkumar T. Shekhada</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></center>");


    }
           catch(Exception e)
              {
                 out.println("<center>Subject is not valid as for particuler Standard or There isn't any Questions </center>");
              }


        out.println("</body>");
        out.println("</html>");

        }
    }
   
