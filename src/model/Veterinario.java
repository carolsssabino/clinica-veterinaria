package model;

import java.util.ArrayList;
import java.util.List;

public class Veterinario {
    private int id;
    private String nome;
    private String crmv;
    private List<Consulta> consultas;
    
    public Veterinario() {
        this.consultas = new ArrayList<>();
    }
    
    public Veterinario(String nome, String crmv) {
        this.nome = nome;
        this.crmv = crmv;
        this.consultas = new ArrayList<>();
    }
    
    public void registrarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCrmv() {
        return crmv;
    }
    
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
    
    public List<Consulta> getConsultas() {
        return consultas;
    }
    
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}