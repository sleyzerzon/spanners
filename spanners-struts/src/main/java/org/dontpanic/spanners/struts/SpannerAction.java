package org.dontpanic.spanners.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.dontpanic.spanners.dao.SpannersDAO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Superclass of Spanner pages
 * User: Stevie
 * Date: 03/03/12
 */
public abstract class SpannerAction extends ActionSupport {

    protected SpannersDAO spannersDAO;

    public void setSpannersDAO(SpannersDAO spannersDAO) {
        this.spannersDAO = spannersDAO;
    }

    /**
     * Get the name of the currently logged in user
     */
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
