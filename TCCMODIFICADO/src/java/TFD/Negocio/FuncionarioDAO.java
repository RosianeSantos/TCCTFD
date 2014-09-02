/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import TFD.Entidade.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
public class FuncionarioDAO {
    EntityManager ge = DAOGenerico.getGerenciadorEntidade();
    
    /**
     * Metodo com a finalidade apenas de salvar um usuario.
     * @param funcionario Objeto do tipo usuario.
     */
    public void cadastrarUsuario(Funcionario funcionario){
        ge.getTransaction().begin();
        ge.persist(funcionario);
        ge.getTransaction().commit();
    }
    
      /**
     * Obtem o usuario atravez do codigo.
     * @param CodFuncionario tipo String.
     * @return 
     */
    public Funcionario obterUsuarioCodigo(String CodFuncionario){
        Query query = ge.createQuery("SELECT f FROM Funcionario f WHERE f.CodFuncionario =:codFuncionario");
        query.setParameter("codEmergencia", CodFuncionario);
        Funcionario funcionario = (Funcionario) query.getSingleResult();
        return funcionario;
    }
            
    /**
     * Metodo que busca um usuario no banco de dados, pelo nome.
     * @param nome tipo String
     * @return Objeto do tipo Funcionario.
     */
    public Funcionario obterFuncionario(String nome){
        Query query = ge.createQuery("SELECT f FROM Funcionario f WHERE f.nome =:nome");
        query.setParameter("nome", nome);      
        Funcionario funcionario = (Funcionario) query.getSingleResult();
        return funcionario;
    }
 /**   public void alterarFuncionario(Funcionario funcionario){
        this.cadastrarfuncionario(funcionario);
    }**/
}
