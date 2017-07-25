/**
 * 
 */
package io.gocanvas.integration.ats.middleware.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.gocanvas.integration.ats.middleware.MiddlewareConstants;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import net.sf.ehcache.search.expression.Criteria;
import net.sf.ehcache.search.expression.Or;

/**
 * @author Prodapt Solutions
 *
 */
@Component
public class GreenHouseCandidateCache implements IMiddlewareCache{

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static Cache candidateCache = CacheManager.getInstance().getCache("candidates"); 
	private static Attribute<String> candidatefirstname = candidateCache.getSearchAttribute("firstname");
	private static Attribute<String> candidatelastname = candidateCache.getSearchAttribute("lastname");
	
	
	public static Cache jobCache = CacheManager.getInstance().getCache("jobs"); 
	private static Attribute<String> jobname = jobCache.getSearchAttribute("name");
	
	
	@Override
	public void loadCandidateintoCache(List<Object> lst_object){
		long start = System.currentTimeMillis();
		int k = 0;
		candidateCache.removeAll();
		for (Object obj : lst_object) {
			ResponseCanvasCandidateModel responseCanvasCandidateModel = (ResponseCanvasCandidateModel) obj;
			Element e = new Element(k, responseCanvasCandidateModel);
			k++;
			candidateCache.put(e);
		}
		long duration = System.currentTimeMillis() - start;
		log.info("All candidates cached in {}ms.",duration);
		log.info("Cache size is {} elements",candidateCache);
	}

	
	@Override
	public void loadJobintoCache(List<Object> lst_object) {
		
		long start = System.currentTimeMillis();
		int k = 0;
		jobCache.removeAll();
		for (Object obj : lst_object) {
			ResponseCanvasJobModel responseCanvasJobModel = (ResponseCanvasJobModel) obj;
			Element e = new Element(k, responseCanvasJobModel);
			k++;
			jobCache.put(e);
		}
		long duration = System.currentTimeMillis() - start;
		log.info("All jobs cached in {}ms.",duration);
		log.info("Cache size is {} elements",candidateCache);
		
	}
	
	@Override
	public List<ResponseCanvasJobModel> searchJobByName(String searchtext) {
		
		List<ResponseCanvasJobModel> lst_responseCanvasJobModel = new ArrayList<>();
		
		 Results results  = performSearch(jobCache,jobname.ilike("*"+searchtext+"*"));	
		 for (Result result : results.all()) {
			 lst_responseCanvasJobModel.add((ResponseCanvasJobModel)result.getValue());
		 }
		 
		 return lst_responseCanvasJobModel;
	}
	
	@Override
	public List<ResponseCanvasCandidateModel> searchCandidateByName(String searchtext) {
		
		List<ResponseCanvasCandidateModel> lst_responseCanvasCandidateModel = new ArrayList<>();
		Results results  = performSearch(candidateCache,new Or(candidatelastname.ilike("*"+searchtext+"*"), candidatefirstname.ilike("*"+searchtext+"*")));
		 for (Result result : results.all()) {
			 lst_responseCanvasCandidateModel.add((ResponseCanvasCandidateModel)result.getValue());
		 }
		return lst_responseCanvasCandidateModel;
	}
	
	
	
	
	@Override
	public List<ResponseCanvasJobModel> getAllJobs() {
		List<ResponseCanvasJobModel> lst_responseCanvasJobModel = new ArrayList<>();
		
		 Results results  = performSearch(jobCache);	
		 for (Result result : results.all()) {
			 lst_responseCanvasJobModel.add((ResponseCanvasJobModel)result.getValue());
		 }
		 
		 return lst_responseCanvasJobModel;
	}


	@Override
	public List<ResponseCanvasCandidateModel> getAllCandidates() {
		List<ResponseCanvasCandidateModel> lst_responseCanvasCandidateModel = new ArrayList<>();
		Results results  = performSearch(candidateCache);
		 for (Result result : results.all()) {
			 lst_responseCanvasCandidateModel.add((ResponseCanvasCandidateModel)result.getValue());
		 }
		return lst_responseCanvasCandidateModel;
	}
	
	
	
	
	
	/*public void searchCandidateByName(String searchtext,String type) throws Exception {
		if(type.equalsIgnoreCase(MiddlewareConstants.CANDIDATE)){
			 Results results  = performSearch(candidateCache,candidatelastname.eq(searchtext), candidatefirstname.eq(searchtext));
		} else if(type.equalsIgnoreCase(MiddlewareConstants.JOB)){
			 Results results  = performSearch(jobCache,jobname.eq(searchtext));	
		}
    }*/
	
	private Results performSearch( Cache cache, Criteria... criteria) {
        Query query = createQuery(cache, criteria);
        long start = System.currentTimeMillis();
        Results results = query.execute();
        System.out.println(results.size());
//        for (Result result : results.all()) {
//        	System.out.println("" + result.getKey());
//        	System.out.println("" + result.getValue());
//    	}
//        int count = results.size();
//        long duration = System.currentTimeMillis() - start;
//        log.info("Searchresult: found {} persons in {} ms.", count, duration);
//        results.discard();
        return results;
    }
	private Query createQuery(Cache cache, Criteria... criteria) {
        Query query = cache.createQuery().includeValues();
        for (Criteria crit : criteria) {
            query.addCriteria(crit);
        }
        query.end();
        return query;
    }


	


	
	


	
	
	
}
