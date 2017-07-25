/**
 * 
 */
package io.gocanvas.integration.ats.middleware.factory;

import org.springframework.stereotype.Component;

import io.gocanvas.integration.ats.middleware.MiddlewareConstants;
import io.gocanvas.integration.ats.middleware.cache.GreenHouseCandidateCache;
import io.gocanvas.integration.ats.middleware.cache.IMiddlewareCache;

/**
 * @author Prodapt Solutions
 *
 */
@Component
public class MiddlewareCacheFactory {

	private static IMiddlewareCache IMiddlewareCache;
	
	public static IMiddlewareCache getMiddlewareCache(String middlewarename){
		
		if(middlewarename.equalsIgnoreCase(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)){
			IMiddlewareCache = new GreenHouseCandidateCache();
		}
		return IMiddlewareCache;
	}
	
	
}
