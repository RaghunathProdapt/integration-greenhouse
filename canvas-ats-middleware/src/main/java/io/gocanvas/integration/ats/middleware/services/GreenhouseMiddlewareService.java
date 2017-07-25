package io.gocanvas.integration.ats.middleware.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.gocanvas.integration.ats.middleware.MiddlewareConstants;
import io.gocanvas.integration.ats.middleware.clients.GreenhouseWebserviceClient;
import io.gocanvas.integration.ats.middleware.factory.MiddlewareCacheFactory;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;

/**
 * @author Prodapt Solutions
 *
 */
@Component
public class GreenhouseMiddlewareService implements IMiddlewareService{

	@Autowired
	private GreenhouseWebserviceClient greenhouseWebserviceClient;
	
	

	@Override
	public List<ResponseCanvasCandidateModel> getAllCandidates() {
		try{
			return MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).getAllCandidates();
		}catch(Exception exe){
			exe.printStackTrace();
			throw exe;
		}
	}

	@Override
	public List<ResponseCanvasCandidateModel> searchCandidateByName(String searchtext) {
		try{
			return MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).searchCandidateByName(searchtext);
		}catch(Exception exe){
			exe.printStackTrace();
			throw exe;
		}
	}

	@Override
	public List<ResponseCanvasJobModel> getAllJob() {
		try{
			return MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).getAllJobs();
		}catch(Exception exe){
			exe.printStackTrace();
			throw exe;
		}
	}

	@Override
	public List<ResponseCanvasJobModel> searchJobByTitle(String searchtext) {
		try{
			return MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).searchJobByName(searchtext);
		}catch(Exception exe){
			exe.printStackTrace();
			throw exe;
		}
	}

	@Override
	public void refreshCacheData(String data) throws Exception {
		try{
			if(data.equalsIgnoreCase(MiddlewareConstants.CANDIDATE)){
				MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)
						.loadCandidateintoCache(greenhouseWebserviceClient.loadCandidateList());
			}
			else if(data.equalsIgnoreCase(MiddlewareConstants.JOB)){
				MiddlewareCacheFactory.getMiddlewareCache(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)
				.loadJobintoCache(greenhouseWebserviceClient.loadJobList());
			}
		}catch(Exception exe){
			exe.printStackTrace();
			throw exe;
		}
		
	}

}
