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
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");

        Optional<Producto> encontrado = service.listar().stream().filter(p -> p.getNombre().contains(nombre)).findFirst();
        if(encontrado.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <title>Producto encontrado</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Producto encontrado</h1>");
                out.println("       <h3>Producto encontrado " + encontrado.get().getNombre() +
                        " el precio es " + encontrado.get().getPrecio() + "</h3>");

                out.println("   </body>");
                out.println("</html>");
            }

        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Lo sentimos no encontramos el producto" + nombre);
        }
    }
}
