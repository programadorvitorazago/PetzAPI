/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petz.petzapi.Classe;

/**
 *
 * @author vitor.zago
 */
public class RespostaPadrao {
    
    private int errorCode; // Se erro então != 0
    private String status; 
    private String mensagem; 
    
    public RespostaPadrao(String _status)
    {
        this(("OK".equals(_status) ? 0 : -1), _status, null);
    }
    
    public RespostaPadrao(String _status, String _mensagem)
    {
        this(("OK".equals(_status) ? 0 : -1), _status, _mensagem);
    }
    
    public RespostaPadrao(int _codigo, String _status, String _mensagem)
    {
        this.errorCode = _codigo;
        this.status = _status;
        this.mensagem = _mensagem;
    }
 
    // GS
    public int getErroCode() {
        return errorCode;
    }

    public void setErroCode(int erroCode) {
        this.errorCode = erroCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}

