/**
 * 
 */
package io.gocanvas.integration.ats.middleware.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.gocanvas.integration.ats.middleware.MiddlewareConstants;
import io.gocanvas.integration.ats.middleware.factory.MiddlewareServiceFactory;
import io.gocanvas.integration.ats.middleware.greenhouse.models.GreenHousePayload;

/**
 * @author Prodapt Solutions
 *
 */
@Controller
@RequestMapping("/webhook/greenhouse")
public class MiddlewareWebHookController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MiddlewareServiceFactory  middlewareServiceFactory;
	
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String webhook(@RequestBody String obj) throws Exception{

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GreenHousePayload greenHousePayload = null;
		try {
			greenHousePayload = mapper.readValue(obj, GreenHousePayload.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(greenHousePayload!=null){
				log.debug("Payload Action : "+greenHousePayload.getAction());
				switch (greenHousePayload.getAction()) {
					case MiddlewareConstants.PAYLOAD_CANDIDATEDELETED:
						middlewareServiceFactory.getMiddlewareService(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)
								.refreshCacheData(MiddlewareConstants.CANDIDATE);
						break;
					case MiddlewareConstants.PAYLOAD_JOBCREATED:
						middlewareServiceFactory.getMiddlewareService(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)
								.refreshCacheData(MiddlewareConstants.JOB);
						break;
					case MiddlewareConstants.PAYLOAD_JOBDELETED:
						middlewareServiceFactory.getMiddlewareService(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME)
								.refreshCacheData(MiddlewareConstants.JOB);
						break;
					case MiddlewareConstants.PAYLOAD_JOBPOSTDELETED:
						break;
					case MiddlewareConstants.PAYLOAD_JOBSTAGEDELETED:
						break;
					case MiddlewareConstants.PAYLOAD_JOBUPDATED:
						break;
					default:
						break;
				}
				
			}
			else{
				log.info("Payload received but no body recived");
				return "Payload received but no body recived";
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			log.info("Payload received but exception occured in data reload");
			return "Payload received but exception occured in data reload";
		}
		
		
		log.info("Payload received and data reloaded");
        return "Payload received and data reloaded";
    }
	
}
