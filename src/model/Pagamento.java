package model;

import model.enums.FormaPagamento;
import model.enums.StatusPagamento;
import java.util.Date;

public class Pagamento {
    private int id;
    private double valor;
    private FormaPagamento formaPagamento;
    private Date dataPagamento;
    private StatusPagamento status;
    
    public Pagamento() {
        this.status = StatusPagamento.PENDENTE;
    }
    
    public Pagamento(double valor, FormaPagamento formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.status = StatusPagamento.PENDENTE;
    }
    
    public void registrarPagamento() {
        this.dataPagamento = new Date();
        this.status = StatusPagamento.PAGO;
    }
    
    public boolean verificarPendencia() {
        return this.status == StatusPagamento.PENDENTE;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public Date getDataPagamento() {
        return dataPagamento;
    }
    
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public StatusPagamento getStatus() {
        return status;
    }
    
    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}