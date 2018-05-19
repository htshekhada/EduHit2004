import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Hit extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     

      out.println("<html>");
      out.println("<head>");


out.println("<SCRIPT LANGUAGE=\"JavaScript\">");

out.println("var pos = 10;");
out.println("function initArray() {");
out.println(" this.length = initArray.arguments.length;");
out.println(" for (var i = 0; i < this.length; i++) {");
out.println("  this[i] = initArray.arguments[i];");
out.println("  }");
out.println("}");
out.println("var col=new initArray(\"4b\",\"5b\",\"8b\",\"8b\");");
out.println("col[0] = \"blue\";");
out.println("col[1] = \"black\";");
out.println("col[2] = \"green\";");
out.println("col[3] = \"blue\";");
out.println("col[4] = \"black\";");
out.println("col[5] = \"green\";");
out.println("col[6] = \"blue\";");
out.println("col[7] = \"white\";");
out.println("col[8] = \"green\";");
out.println("col[9] = \"blue\";");
out.println("");
out.println("function chgCol() {");
out.println("  pos++;");
out.println("  if (pos<0||pos>9) {");
out.println("    pos = 0;");
out.println("    }");
out.println("  document.bgColor = col[pos];");
out.println("  setTimeout(\"chgCol()\",3000);");

  /* Change above set to every 10 seconds (1000 = 1 sec)  If
       you wish to speed it up, lower the number. To slow it
       down, raise the number. */


out.println(" }");

out.println("</SCRIPT>");
out.println("</HEAD>");
out.println("<BODY onLoad=\"chgCol()\";>");

out.println("</BODY>");
out.println("</HTML>");

  }
}
