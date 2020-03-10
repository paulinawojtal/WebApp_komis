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
import model.Vehicle;

/**
 *
 * @author PaulinaMaciej
 */

@Stateless
public class VehicleDAOImpl implements ObjectDAO<Vehicle>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveObject(Vehicle obj) {
        em.persist(obj);
    }

    @Override
    public List<Vehicle> getObjects() {
        return em.createQuery("select v from Vehicle v", Vehicle.class).getResultList();
    }

    @Override
    public void deleteObjecttById(int id) {
        Vehicle vehicle = em.find(Vehicle.class, id);
//        Query q = em.createQuery("select v from Vehicle v where v.id=:idNumber", Vehicle.class);
//        q.setParameter("idNumber", id);
//        Vehicle vehicle = (Vehicle) q.getSingleResult();
        
        em.remove(vehicle);
    }

    @Override
    public void updateObjectById(Vehicle vehicle) {
        em.merge(vehicle);
    }

    @Override
    public Vehicle findObjectById(int id) {
        Vehicle vehicle = em.find(Vehicle.class, id);
        return vehicle;
    }
    
    public List<String> getColumnList(){
        Query q = em.createNativeQuery("select column_name from information_schema.columns where table_name = 'vehicle'");
        List<String> colNames = q.getResultList();
        return colNames;
    }
    
    public List<Vehicle> getData(String brand){
        Query q = em.createQuery("select v from Vehicle v where v.brand = :getBrand", Vehicle.class);
        q.setParameter("getBrand", brand);
        
        List<Vehicle> vehicles = q.getResultList();
        return vehicles;
    }
    
}
