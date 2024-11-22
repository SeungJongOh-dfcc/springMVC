package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);

        printHeaders(request);

        printContent(request);
    }

    private static void printContent(HttpServletRequest request) {
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("[Content 편의 조회 END!!]");
    }

    private static void printHeaders(HttpServletRequest request) {
        System.out.println("---- HEADERS START LINE ----------");
        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName = " + headerName);
//        }
        headerNames.asIterator().forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
        System.out.println("---- HEADERS END LINE ----------");
        System.out.println();
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("---- REQUEST START LINE ----------");
        System.out.println("request.getMethod() = " + request.getMethod()); // GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); // http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); // /request-header
        System.out.println("request.getQueryString() = " + request.getQueryString()); // username=hi
        System.out.println("request.isSecure() = " + request.isSecure());   // https 사용 유무
        System.out.println("---- REQUEST END LINE ----------");
        System.out.println();
    }
}
