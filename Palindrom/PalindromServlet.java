import com.webservices.PalindromWebServices_Service;
import com.webservices.PalindromWebServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

public class PalindromServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Palindrom/PalindromWebServices.wsdl")
    private PalindromWebServices_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Get input from form
            String input = request.getParameter("palinInput");

            // Call web service operation
            String result = checkPalindrome(input);

            // Display result
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Palindrome Check</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Palindrome Servlet</h1>");
            out.println("<h2>Input: " + input + "</h2>");
            out.println("<h2>Result: " + result + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Palindrome Servlet using Web Service";
    }

    // Web service call method
    private String checkPalindrome(String input) {
        PalindromWebServices port = service.getPalindromWebServicesPort();
        return port.checkPalindrome(input);
    }
}
