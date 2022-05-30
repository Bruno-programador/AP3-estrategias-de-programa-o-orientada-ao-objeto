/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ap1.Classes;

/**
 *
 * @author Bruno 5600
 */  
public class Cliente {
        
    private int Id;
    private String nome;
    private String CPF;

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cpf) {
        this.CPF = cpf;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
}

