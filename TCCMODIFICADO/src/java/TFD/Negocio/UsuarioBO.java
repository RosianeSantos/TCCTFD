/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import TFD.Entidade.Funcionario;
import TFD.Utilizados.Validacao;
import java.io.Serializable;

/**
 *
 * @author Rosy
 */
public class UsuarioBO implements Serializable {
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private Validacao validacao = new Validacao();
    
    
    
    /** Obtem Usuario da camada de persistencia.
     *
     * @param nome
     * @return objeto do tipo usuario.
     */
    public Funcionario obterFuncionario(String nome) {
        Funcionario funcionario;
        try {
            funcionario = funcionarioDAO.obterFuncionario(nome);
            return funcionario;

        } catch (Exception e) {
            return new Funcionario();
        }
    }
    }