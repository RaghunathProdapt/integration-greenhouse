/**
 * 
 */
package io.gocanvas.integration.ats.middleware.greenhouse.models;

/**
 * @author Prodapt Solutions
 *
 */
public class GreenHouseCandidatePhoneNumber {
	private String value;
	private String type;
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [value=" + value + ", type=" + type + "]";
	}
	
	
}
