/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ObjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;

/**
 *
 * @author PaulinaMaciej
 */
@WebServlet(urlPatterns = "/searchVehicle")
public class SearchVehicleServlet extends HttpServlet{
    
    @Inject
    private ObjectDAO<Vehicle> dao;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String col = req.getParameter("columns");
         
        List<Vehicle> colList =  dao.getData(col);
        
        System.out.println(colList);
        PrintWriter pw = resp.getWriter();
        pw.print(colList);
        
    }
    
}
