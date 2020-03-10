/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Client;
import model.Vehicle;

/**
 *
 * @author PaulinaMaciej
 */
public interface ObjectDAO<T> {
    
    void saveObject(T obj);
    List<T> getObjects();
    void deleteObjecttById(int id);
    void updateObjectById(T obj);
    T findObjectById(int id);
    public List<String> getColumnList();
    public List<Vehicle> getData(String brand);
}
