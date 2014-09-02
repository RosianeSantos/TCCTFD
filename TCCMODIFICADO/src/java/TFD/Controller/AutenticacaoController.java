/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Controller;

import TFD.Entidade.Funcionario;
import TFD.Negocio.IFuncionarioRepositorio;
import java.util.Enumeration;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rosy
 */
@Named(value = "autenticacaoController")
@SessionScoped
public class AutenticacaoController
        implements Serializable {

    /**
     * Criando a nova instancia de AutenticacaoController
     */
    public AutenticacaoController() {
    }
   
    IFuncionarioRepositorio dao;
    private String login, senha;
    Funcionario usuario;
    
     public void Mensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String validar() {
        try {
        usuario = dao.porLogin(login);

        if (usuario == null) {
            Mensagem("Login ou senha não correspondem!");
            return "Template.xhtml";
            
        } else {
            if (senha.equals(usuario.getSenha())) {

                HttpSession session;

                FacesContext ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("usuarioAutenticado", usuario);

            //    AppendLog("Login");

                return "CadastroFuncionario.xhtml";
            } else {
                Mensagem("Login ou senha não correspondem");
                return "Template.xhtml";
                
            }
        }
        } catch(Exception ex){
            Mensagem("Login ou senha não correspondem");
            return "Template.xhtml";
        }

    }

    public String logout() {
        HttpSession session;

        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("usuarioAutenticado", null);

       // AppendLog("Logout");
        
        Enumeration<String> vals = session.getAttributeNames(); 
        
        while(vals.hasMoreElements()){
            session.removeAttribute(vals.nextElement());
        }

        return "Template.xhtml";

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public void setUsuario(Funcionario usuario) {
        this.usuario = usuario;
    }
}
