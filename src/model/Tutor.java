package model;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private List<Animal> animais;
    
    public Tutor() {
        this.animais = new ArrayList<>();
    }
    
    public Tutor(String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.animais = new ArrayList<>();
    }
    
    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
        animal.setTutor(this);
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
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public List<Animal> getAnimais() {
        return animais;
    }
    
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
    
    @Override
    public String toString() {
        return "Tutor: " + nome + " | CPF: " + cpf;
    }
}