/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Rosy
 */
@Entity
public class Funcionario implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String Nome;
    @Column(nullable = false)
    private String Login;
    @Column (nullable = false)
    private String Senha;
    
    /**
     *
     * @return
     */
    public String getSenha() {
        return Senha;
    }

    /**
     *
     * @param Senha
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    /**
     *
     * @return
     */
    public Long getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return Login;
    }

    /**
     *
     * @param Login
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

     @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Nome;
    }
    
  
}
