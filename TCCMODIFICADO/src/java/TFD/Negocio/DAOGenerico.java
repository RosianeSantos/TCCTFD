/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import TFD.Negocio.Entidade;
import TFD.Negocio.IRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rosy
 *
 */
public abstract class DAOGenerico<T> implements IRepositorio<T> {
    @PersistenceContext(name="TCCMODIFICADOPU")
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
   

 
    @Override
    public T Salvar(T obj) {
        try{
            if(manager.contains(obj)) {
                obj = manager.merge(obj);
            }
            else {
                manager.persist(obj);
            }
            
            manager.flush();
            return obj;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return null;
        }
    }
    
          
    
    @Override
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    @Override
      public abstract List<T> Buscar(T obj);

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
