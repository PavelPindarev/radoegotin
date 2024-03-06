package com.example.hello.util;


import org.hibernate.Session;

import javax.faces.context.FacesContext;

public class FacesContextUtil {
        private static final String HIBERNATE_SESSION = "hibernate_session";

        public static void setRequestSession(Session session) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
        }

        public static Session getRequestSession() {
                return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
        }

}