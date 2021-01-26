package com.spotifyit.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Dispatcherinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[] {Config.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
