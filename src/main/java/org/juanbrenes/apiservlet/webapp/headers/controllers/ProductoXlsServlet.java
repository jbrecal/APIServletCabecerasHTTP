package org.juanbrenes.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juanbrenes.apiservlet.webapp.headers.models.Producto;
import org.juanbrenes.apiservlet.webapp.headers.services.ProductoService;
import org.juanbrenes.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();  // /productos.html
        boolean esXls = servletPath.endsWith(".xls");  // true exportamos
        if(esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=\"productos.xls\"");
        }
        try (PrintWriter out = resp.getWriter()) {

            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <title>Listado de productos</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Listado de productos</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Exportar a XLS</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Mostrar Json</a></p>");
            }
            out.println("<table>");
            out.println("   <tr>");
            out.println("       <th>Id</th>");
            out.println("       <th>Nombre</th>");
            out.println("       <th>Tipo</th>");
            out.println("       <th>Precio</th>");
            out.println("   </tr>");
            for (Producto producto : productos) {
                out.println("   <tr>");
                out.println("       <td>" + producto.getId() + "</td>");
                out.println("       <td>" + producto.getNombre() + "</td>");
                out.println("       <td>" + producto.getTipo() + "</td>");
                out.println("       <td>" + producto.getPrecio() + "</td>");
                out.println("   </tr>");
            }
            out.println("</table>");
            if(!esXls) {
                out.println("   </body>");
                out.println("</html>");
            }
        }

    }
}
