package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        printParamsAll(request);

        printParam(request);

        printSameParam(request);

        response.getWriter().write("ok");
    }

    private static void printSameParam(HttpServletRequest request) {
        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");
        System.out.println();
    }

    private static void printParam(HttpServletRequest request) {
        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();
    }

    private static void printParamsAll(HttpServletRequest request) {
        System.out.println("[전체 파라미터 조회] - start");

        Enumeration<String> parameterNames = request.getParameterNames();
        parameterNames
                .asIterator()
                .forEachRemaining(param ->
                        System.out.println(param + ": " + request.getParameter(param)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();
    }
}
