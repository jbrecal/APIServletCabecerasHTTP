package org.juanbrenes.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();  // /cabeceras
        String requestUrl = req.getRequestURL().toString(); // http://localhost:8080/cabeceras
        String contexPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();  // 226.87.1.177 por ejemplo esta es la ip del cliente
        String ip = req.getLocalAddr(); // 127.0.0.1 del servidor que recibe la petición (tomcat)
        int port = req.getLocalPort();  // 8081
        String scheme = req.getScheme();  // http
        String host = req.getHeader("Host");
        String url = scheme + "://" + host + ":" + contexPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;



        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <title>Cabeceras HTTP Request</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Cabeceras HTTP Request</h1>");
            out.println("       <ul>");
            out.println("<li> Método HTTP: " + metodoHttp + "</li>");
            out.println("<li> Request URI: " + requestUri + "</li>");
            out.println("<li> Request URL: " + requestUrl + "</li>");
            out.println("<li> Nombre proyecto o ContexPath: " + contexPath + "</li>");
            out.println("<li> ServletPath: " + servletPath + "</li>");
            out.println("<li> IP cliente: " + ipCliente + "</li>");
            out.println("<li> IP local: " + ip + "</li>");
            out.println("<li> Puerto local: " + port + "</li>");
            out.println("<li> Esquema: " + scheme + "</li>");
            out.println("<li> Host: " + host + "</li>");
            out.println("<li> URL: " + url + "</li>");
            out.println("<li> URL2: " + url2 + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("       </ul>");
            out.println("   </body>");
            out.println("</html>");
        }

    }
}
