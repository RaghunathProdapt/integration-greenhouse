package io.gocanvas.integration.ats.middleware.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.gocanvas.integration.ats.middleware.MiddlewareConstants;
import io.gocanvas.integration.ats.middleware.services.GreenhouseMiddlewareService;
import io.gocanvas.integration.ats.middleware.services.IMiddlewareService;

/**
 * @author Prodapt Solutions
 *
 */
@Component
public class MiddlewareServiceFactory {

	private IMiddlewareService iMiddlewareService;
	
	@Autowired
	private GreenhouseMiddlewareService greenhouseMiddlewareService;
	
	public IMiddlewareService getMiddlewareService(String middlewarename){
		
		if(middlewarename.equalsIgnoreCase(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)){
			iMiddlewareService = greenhouseMiddlewareService;
		}
		
		return iMiddlewareService;
		
	}
}
