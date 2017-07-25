package io.gocanvas.integration.ats.middleware.services;

import java.util.List;

import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;

/**
 * @author Prodapt Solutions
 *
 */
public interface IMiddlewareService {

	/**
	 * 
	 * This method will return all the available candidates from the middle ware cache
	 * 
	 * */
	public List<ResponseCanvasCandidateModel> getAllCandidates();
	
	
	/**
	 * 
	 * @param searchtext : could be  any string
	 * This method will return all the available candidates from the 
	 * middle ware cache with respect to the serach text
	 * 
	 * */
	public List<ResponseCanvasCandidateModel> searchCandidateByName(String searchtext);
	
	
	/**
	 * 
	 * 
	 * This method will return all the available jobs from the middle ware cache
	 * 
	 * */
	public List<ResponseCanvasJobModel> getAllJob();
	
	
	/**
	 * 
	 * @param searchtext : could be  any string
	 * This method will return all the available jobs from the 
	 * middle ware cache with respect to the serach text
	 * 
	 * */
	public List<ResponseCanvasJobModel> searchJobByTitle(String searchtext);
	
	
	/**
	 * 
	 * @param data : could be  "job" or "candidate"
	 * This method will reload the cache with newly added data in the middle ware application
	 * 
	 * */
	public void refreshCacheData(String data) throws Exception;
	
}
