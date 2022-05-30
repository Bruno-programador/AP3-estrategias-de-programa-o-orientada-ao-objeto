/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ap1.Classes;

/**
 *
 * @author Bruno 5600
 */
public class Vendas {
    
    private String id;
    private ap1.Classes.Cliente cliente;
    private ap1.Classes.Motocicleta motocicleta;
    private String parcelas;
    private double valorParcelas;
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public ap1.Classes.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(ap1.Classes.Cliente cliente) {
        this.cliente = cliente;
    }

    public ap1.Classes.Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(ap1.Classes.Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }
    
    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }
    
    @Override
    public String toString(){
        return this.id;
    }
}
