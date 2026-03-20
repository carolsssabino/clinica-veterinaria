package model;

public class Animal {
    private int id;
    private String nome;
    private String tipo;
    private String raca;
    private int idade;
    private Tutor tutor;
    
    public Animal() {
    }
    
    public Animal(String nome, String tipo, String raca, int idade) {
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.idade = idade;
    }
    
    public void vincularTutor(Tutor tutor) {
        this.tutor = tutor;
        tutor.adicionarAnimal(this);
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
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getRaca() {
        return raca;
    }
    
    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public Tutor getTutor() {
        return tutor;
    }
    
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    @Override
    public String toString() {
        return "Animal: " + nome + " (" + tipo + ") - Tutor: " + 
               (tutor != null ? tutor.getNome() : "Sem tutor");
    }
}