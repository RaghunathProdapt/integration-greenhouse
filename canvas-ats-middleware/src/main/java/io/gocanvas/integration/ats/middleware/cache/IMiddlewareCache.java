/**
 * 
 */
package io.gocanvas.integration.ats.middleware.cache;

import java.util.List;

import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;

/**
 * @author Prodapt Solutions
 *
 */
public interface IMiddlewareCache {
	public void loadCandidateintoCache(List<Object> lst_object);
	public void loadJobintoCache(List<Object> lst_object);
	public List<ResponseCanvasJobModel> searchJobByName(String searchtext);
	public List<ResponseCanvasCandidateModel> searchCandidateByName(String searchtext);
	
	public List<ResponseCanvasJobModel> getAllJobs();
	public List<ResponseCanvasCandidateModel> getAllCandidates();
}
