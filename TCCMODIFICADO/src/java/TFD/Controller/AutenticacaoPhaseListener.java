/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Controller;

import TFD.Entidade.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosy
 */
public class AutenticacaoPhaseListener implements PhaseListener {

    /**
     *
     * @param event
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        ExternalContext ec = fc.getExternalContext();

        if (!fc.getViewRoot().getViewId().contains("Template.xhtml")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            Funcionario usuario = (Funcionario) session.getAttribute("usuarioAutenticado");

            if (usuario == null) {
                try {
                    ec.redirect(ec.getRequestContextPath() + "/Template.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(AutenticacaoPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     * @param event
     */
    @Override
    public void beforePhase(PhaseEvent event) {
    }

    /**
     *
     * @return
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    } 
}
