/**
 * 
 */
package io.gocanvas.integration.ats.middleware.greenhouse.models;

/**
 * @author Prodapt Solutions
 *
 */
public class GreenHousePayload {
	private String action;
	private Object payload;
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public Object getPayload() {
		return payload;
	}
	
	public void setPayload(Object payload) {
		this.payload = payload;
	}

	
	@Override
	public String toString() {
		return "GreenHousePayload [action=" + action + ", payload=" + payload + "]";
	}
	
	
	
}
