/*;

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author lukas
 */
@Entity
public class Endereco {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @Column
    private String numeroCasa;
    @Column
    private String nomeRua;
    @Column
    private String Cidade;
    @Column
    private String Estado;
    
  

    public Endereco(Long id, String numeroCasa, String nomeRua, String Cidade, String Estado) {
        this.id = id;
        this.numeroCasa = numeroCasa;
        this.nomeRua = nomeRua;
        this.Cidade = Cidade;
        this.Estado = Estado;
    }

 
    
    

   
    
    
    public Endereco(){
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

  

   
            
    
    
}
