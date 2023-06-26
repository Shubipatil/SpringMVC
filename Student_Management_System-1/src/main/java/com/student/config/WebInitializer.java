package com.student.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {StudentConfig.class};
		/**
		 * In this method we are passing the StudentConfig class object where we have
		 * passed the basepackages in order to let a spring know that which are the
		 * class it need to create object for
		 */
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
		/**
		 * in this method we are accepting all the url coming as request 
		 * by passing a base url inside an string type array{"/"}
		 */

	}

}
