package org.juanbrenes.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
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

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream jsonStream = req.getInputStream();  // lee el json
        ObjectMapper mapper = new ObjectMapper();  // crea un mapeador
        Producto producto = mapper.readValue(jsonStream, Producto.class);  // convierte a producto, se crea el objeto

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <title>Detalle producto desde json</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Detalle producto desde json</h1>");
            out.println("       <ul>");
            out.println("           <li>Id: " + producto.getId() + "</li>");
            out.println("           <li>Nombre: " + producto.getNombre() + "</li>");
            out.println("           <li>tipo: " + producto.getTipo() + "</li>");
            out.println("           <li>Precio: " + producto.getPrecio() + "</li>");
            out.println("       </ul>");
            out.println("   </body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        ObjectMapper mapper = new ObjectMapper();  // crea un mapeador
        String json = mapper.writeValueAsString(productos); // convierte a json

        resp.setContentType("application/json");
        resp.getWriter().write(json); // devuelve el json
    }
}
