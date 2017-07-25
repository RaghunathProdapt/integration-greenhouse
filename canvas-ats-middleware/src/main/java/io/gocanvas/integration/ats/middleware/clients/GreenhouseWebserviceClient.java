/**
 * 
 */
package io.gocanvas.integration.ats.middleware.clients;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasCandidateModel;
import io.gocanvas.integration.ats.middleware.greenhouse.models.ResponseCanvasJobModel;

/**
 * @author Prodapt Solutions
 *
 */
@Component
public class GreenhouseWebserviceClient {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${GREENHOUSE_AUTHTOKEN}")
	private String authStringEnc;
	
	@Value("${GREENHOUSE_CANDIDATEENDPOINT}")
	private String candidateEndpoint;
	
	@Value("${GREENHOUSE_JOBENDPOINT}")
	private String jobEndpoint;
	
	public void setAuthStringEnc(String authStringEnc) {
		this.authStringEnc = authStringEnc;
	}

	public void setCandidateEndpoint(String candidateEndpoint) {
		this.candidateEndpoint = candidateEndpoint;
	}

	public void setJobEndpoint(String jobEndpoint) {
		this.jobEndpoint = jobEndpoint;
	}
	public String getAuthStringEnc() {
		return authStringEnc;
	}

	public String getCandidateEndpoint() {
		return candidateEndpoint;
	}

	public String getJobEndpoint() {
		return jobEndpoint;
	}
	
	
	

	public void authGreenHouse(){
		try {
			
			String url = candidateEndpoint;
	        Client restClient = Client.create();
	        WebResource webResource = restClient.resource(url);
	        ClientResponse resp = webResource.accept("application/json")
	                                         .header("Authorization", "Basic " + authStringEnc)
	                                         .get(ClientResponse.class);
	        if(resp.getStatus() != 200){
	        	log.error("Unable to connect to the server");
	        }
	        String output = resp.getEntity(String.class);
	        log.info("response: "+output);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Object> loadCandidateList() {
		List<Object> lst_obj = null;
		try {
//			log.debug("authStringEnc : "+authStringEnc);
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("Authorization", "Basic " + authStringEnc);
			headers.add("Content-Type", "application/json");

			RestTemplate restTemplate = new RestTemplate();
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(candidateEndpoint);
			
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			HttpEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			lst_obj = mapper.readValue(response.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, ResponseCanvasCandidateModel.class));
			
			for(Object obj : lst_obj){
				log.debug(""+obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst_obj;
	}
	
	public List<Object> loadJobList() {
		List<Object> lst_obj = null;
		try {
//			log.debug("authStringEnc : "+authStringEnc);
			
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("Authorization", "Basic " + authStringEnc);
			headers.add("Content-Type", "application/json");

			RestTemplate restTemplate = new RestTemplate();
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(jobEndpoint);
			
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			HttpEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			
			
			log.debug(""+response.getBody());
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			lst_obj = mapper.readValue(response.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, ResponseCanvasJobModel.class));
			
			for(Object obj : lst_obj){
				log.debug(""+obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst_obj;
	}
	
	
}
