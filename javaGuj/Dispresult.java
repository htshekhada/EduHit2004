import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispresult extends HttpServlet
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
          response.sendRedirect("/servlet/Login");
          return;
         }


              out.println("<html>");    
              out.println("<head>");
              out.println("<title>EducationHIT by H.T.Shekhada</title>");
              out.println("</head>");
        
              


      out.println("<body bgcolor=\"rgb(211,255,213)\">");
             
           
              out.println("<center><font face=\"Lmg-Arun Condensed\" size=5 >5ZL1FFGF 5ZL6FD HMJF DF8[GM lJEFU</font></center>");
              out.println("<br>");

              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispscs\" >");
              out.println("<input  type=\"submit\" value=\"         SM> 56 WMZ6GF V[S lJQFIG] 5ZL6FD         \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");
            
        //      out.println("<br>");

              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispres\" >");
              out.println("<input  type=\"submit\" value=\"         SM> 56 WMZ6GF AWF  lJQFIG] 5ZL6FD         \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");


              out.println("<center>");
     //         out.println("<br>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Fresult1\">");
              out.println("<input  type=\"submit\" value=\"    SM> 56 V[S lJnFYLG] VFBF ;F,G] 5ZL6FD    \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
              out.println("</form>");
  

//              out.println("<br><br><br>");
           
//              out.println("<center>");

//              out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Dispsc\" >");
//              out.println("Class vise Result");
//              out.println("</a>");

//                out.println("</center>");

        


              out.println("</center>");

    //          out.println("<br>");
           
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispgen\" >");
              out.println("<input  type=\"submit\" value=\"         SM> 56 WMZ6G] VFBF ;F,G] 5ZL6FD         \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");


    //          out.println("<br>");
           
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispcla1\" >");
              out.println("<input  type=\"submit\" value=\"SM. 56 WMZ6GF  lJQFIGM  lJnFYLGM 5|MU|[; ZL5M8\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
              out.println("</form>");

                out.println("</center>");



            
              out.println("</body>");
              out.println("</html>");
        } 

     }
