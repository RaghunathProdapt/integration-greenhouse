package io.gocanvas.integration.ats.middleware.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gocanvas.integration.ats.middleware.factory.MiddlewareServiceFactory;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;

/**
 * @author Prodapt Solutions
 *
 */
@RestController
@RequestMapping("/api/v1/integration")
public class MiddlewareRestController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MiddlewareServiceFactory  middlewareServiceFactory;
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
	public ResponseEntity<String> init() {
		return ResponseEntity.ok("application up and running....");
	}

	@RequestMapping(value = "/{middleware}/getallcandidatelist", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseCanvasCandidateModel>> getAllCandidates(@PathVariable(value = "middleware", required = true) String middlewarename) {

		log.info("Entered getAllCandidates");
		List<ResponseCanvasCandidateModel> canvasCandidateList = middlewareServiceFactory.getMiddlewareService(middlewarename).getAllCandidates();
		return ResponseEntity.ok(canvasCandidateList);
	}

	@RequestMapping(value = "/{middleware}/searchcandidate", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseCanvasCandidateModel>> searchCandidateByName(@PathVariable(value = "middleware", required = true) String middlewarename,
			@RequestParam(value = "searchtext", required = true) String searchtext) {
		log.info("Entered searchCandidateByName");
		List<ResponseCanvasCandidateModel> canvasCandidateList = middlewareServiceFactory.getMiddlewareService(middlewarename).searchCandidateByName(searchtext);
		return ResponseEntity.ok(canvasCandidateList);
	}

	@RequestMapping(value = "/{middleware}/getalljoblist", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseCanvasJobModel>> getAllJob(@PathVariable(value = "middleware", required = true) String middlewarename) {
		log.info("Entered getAllJob");
		List<ResponseCanvasJobModel> canvasJobList = middlewareServiceFactory.getMiddlewareService(middlewarename).getAllJob();
		return ResponseEntity.ok(canvasJobList);
	}

	@RequestMapping(value = "/{middleware}/searchjob", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseCanvasJobModel>> searchJobByTitle(@PathVariable(value = "middleware", required = true) String middlewarename,
			@RequestParam(value = "searchtext", required = true) String searchtext) {
		log.info("Entered searchJobByTitle");
		List<ResponseCanvasJobModel> canvasJobList = middlewareServiceFactory.getMiddlewareService(middlewarename).searchJobByTitle(searchtext);
		return ResponseEntity.ok(canvasJobList);
	}
	
	@RequestMapping(value = "/{middleware}/reload/{type}", method = RequestMethod.GET)
	public ResponseEntity<String> loadDataFromAts(@PathVariable(value = "middleware", required = true) String middlewarename,
			@PathVariable(value = "type", required = true) String type) {
		log.info("Entered searchJobByTitle");
		try {
			System.out.println(middlewareServiceFactory);
			middlewareServiceFactory.getMiddlewareService(middlewarename).refreshCacheData(type);
			return ResponseEntity.ok("Data loaded into cache.....");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("Exception Occured while loading data from ATS.....");
		}
		
	}
	
	

}
