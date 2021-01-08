/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petz.petzapi;

import java.util.Date;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author vitor.zago
 */
@Stateless
@Path("/servico")
public class ServicoREST {
    
    @GET
    @Path("/teste")
    @Produces({"text/plain"})
    public String testeConexao() {
        return "OK! " + new Date();
    }
    
    @GET
    @Path("/time")
    @Produces({"application/json"})
    public String getTime() {
        return String.format("{ \"DateTime\": \"%s\"}", new Date());
    }
}
