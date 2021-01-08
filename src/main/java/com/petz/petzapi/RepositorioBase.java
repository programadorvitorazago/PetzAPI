package com.petz.petzapi;

import com.google.gson.Gson;
import com.petz.petzapi.Classe.RespostaPadrao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Vitor Zago
 */
public abstract class RepositorioBase<T> {
    
    private Class<T> tipo;
    private Gson conversorJSON = new Gson();

    protected abstract EntityManager getEntityManager();
    
    public RepositorioBase(Class<T> entityClass) {
        this.tipo = entityClass;
    }

    public void INSERT(T entity) {
        EntityTransaction transaction =  getEntityManager().getTransaction();
        
        transaction.begin();
        getEntityManager().persist(entity);
        transaction.commit();
    }

    public void UPDATE(T entity) {
        EntityTransaction transaction =  getEntityManager().getTransaction();

        transaction.begin();
        getEntityManager().merge(entity);
        transaction.commit();
    }

    public void DELETE(T entity) {
        EntityTransaction transaction =  getEntityManager().getTransaction();

        transaction.begin();
        getEntityManager().remove(entity);
        transaction.commit();
    }

    public T SELECT(Object id) {
        T t = getEntityManager().find(this.tipo, id);
        return t;
    }

    public int COUNT() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(this.tipo);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public String Exito()
    {
        return toJson(new RespostaPadrao("OK"));
    }
    
    public String toJson(Object objeto)
    {
        return conversorJSON.toJson(objeto);
    }
    
    public T fromJson(String json)
    {
        return conversorJSON.fromJson(json, this.tipo);
    }

}
