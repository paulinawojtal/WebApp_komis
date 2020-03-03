/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Client;

/**
 *
 * @author PaulinaMaciej
 */
@Stateless
public class ClientDAOImpl implements ObjectDAO<Client> {
    
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveObject(Client client) {
        em.persist(client);
    }

    @Override
    public List<Client> getObjects() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }

    @Override
    public void deleteObjecttById(int id) {
        Client client = em.find(Client.class, id);
        
        em.remove(client);
    }

    @Override
    public void updateObjectById(Client obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findObjectById(int id) {
        Client client = em.find(Client.class, id);
        return client;
    }
    
}
