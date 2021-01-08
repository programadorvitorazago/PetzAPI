/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petz.petzapi;

import com.google.gson.Gson;
import com.petz.petzapi.Classe.RespostaPadrao;
import com.petz.petzapi.Entidade.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;

/**
 *
 * @author vitor.zago
 */
@Stateless
@Path("/cliente")
public class ClienteREST extends RepositorioBase<Cliente>{
    
    //@PersistenceContext(name = "PetzAPI_PU")
    private EntityManager em;
    
    public ClienteREST()
    {
        super(Cliente.class);
    }
    
    // CADASTRO
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String insert(String entidadeJon) {
        try
        {
            Cliente entidade = fromJson(entidadeJon);
            super.INSERT(entidade);
            
            return super.Exito();
        }
        catch(Exception ex)
        {
            return super.toJson(new RespostaPadrao("FALHA", ex.getMessage()));
        }
    }
    
    // EDIÇÂO
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String update(@PathParam("id") Integer id, String entidadeJson) {
        try
        {
            Cliente entidade = super.fromJson(entidadeJson);
            entidade.setId(id);
            
            super.UPDATE(entidade);
            
            return super.Exito();
        }
        catch(Exception ex)
        {
            return super.toJson(new RespostaPadrao("FALHA", ex.getMessage()));
        }
    }
    
    // DELEÇÃO
    @DELETE
    @Path("{id}")
    @Produces({"application/json"})
    public String delete(@PathParam("id") Integer id) {
        try
        {
            Cliente entidade = super.SELECT(id);
            if(entidade != null)
            {
                super.DELETE(entidade);
            }
            
            return super.Exito();
        }
        catch(Exception ex)
        {
            return super.toJson(new RespostaPadrao("FALHA", ex.getMessage()));
        }
    }
    
    // VISUALIZAÇÃO
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public String get(@PathParam("id") Integer id) {
        return super.toJson(super.SELECT(id));
    }

    @Override
    protected EntityManager getEntityManager() {
        if(this.em == null)
        {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetzAPI_PU");
            this.em = emf.createEntityManager();
        }
        
        if(this.em != null)
        {
            System.out.println("Status conexão: " + this.em.isOpen());
        }
        
        return this.em;
    }
}
