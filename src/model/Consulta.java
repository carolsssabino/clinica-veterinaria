package model;

import model.enums.StatusConsulta;
import java.util.Date;

public class Consulta {
    private int id;
    private Animal animal;
    private Veterinario veterinario;
    private Date dataHora;
    private String diagnostico;
    private String tratamento;
    private String observacoes;
    private StatusConsulta status;
    private Pagamento pagamento;
    
    public Consulta() {
        this.status = StatusConsulta.AGENDADA;
    }
    
    public Consulta(Animal animal, Veterinario veterinario, Date dataHora) {
        this.animal = animal;
        this.veterinario = veterinario;
        this.dataHora = dataHora;
        this.status = StatusConsulta.AGENDADA;
    }
    
    public void agendar() {
        this.status = StatusConsulta.AGENDADA;
    }
    
    public void registrarConsulta(String diagnostico, String tratamento, String observacoes) {
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.observacoes = observacoes;
        this.status = StatusConsulta.REALIZADA;
    }
    
    public void cancelar() {
        this.status = StatusConsulta.CANCELADA;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Animal getAnimal() {
        return animal;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    public Date getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public String getTratamento() {
        return tratamento;
    }
    
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public StatusConsulta getStatus() {
        return status;
    }
    
    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}