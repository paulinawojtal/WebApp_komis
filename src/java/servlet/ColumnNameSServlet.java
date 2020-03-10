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
@WebServlet(urlPatterns = "/colNames")
public class ColumnNameSServlet extends HttpServlet{
    
    @Inject
    private ObjectDAO<Vehicle> dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> colNames = dao.getColumnList();
        
        req.setAttribute("colNames", colNames);
        req.getRequestDispatcher("searchVehicleFirst.jsp").forward(req, resp);
    }
}
