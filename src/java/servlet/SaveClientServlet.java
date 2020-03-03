/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import dao.ObjectDAO;
import java.io.PrintWriter;

/**
 *
 * @author PaulinaMaciej
 */

@WebServlet(urlPatterns = {"/saveClient"})
public class SaveClientServlet extends HttpServlet{

    @Inject
    private ObjectDAO<Client> dao;
    
    private Client formToUser(HttpServletRequest req){
        Client client = new Client();
        client.setName(req.getParameter("name"));
        client.setSurname(req.getParameter("surname"));
        client.setRegion(req.getParameter("region"));
        client.setAge(Integer.parseInt(req.getParameter("age")));
        System.out.println(req.getParameter("gender"));
        int gen = req.getParameter("gender") == "male" ? 0 : 1;
        System.out.println(gen);
        client.setGender(gen);
        
        return client;
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = formToUser(req);
        
        try{
            dao.saveObject(client);
            
            req.getRequestDispatcher("clientSaved.html").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        //resp.sendRedirect(req.getContextPath() + "/index.html");
    }
    
}
