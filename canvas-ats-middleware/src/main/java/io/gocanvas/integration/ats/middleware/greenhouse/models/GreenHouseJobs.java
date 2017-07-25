/**
 * 
 */
package io.gocanvas.integration.ats.middleware.greenhouse.models;

/**
 * @author Prodapt Solutions
 *
 */
public class GreenHouseJobs {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "GreenHouseJobs [id=" + id + ", name=" + name + "]";
	}
}
