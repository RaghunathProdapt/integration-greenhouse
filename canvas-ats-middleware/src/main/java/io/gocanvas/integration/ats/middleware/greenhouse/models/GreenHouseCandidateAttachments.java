/**
 * 
 */
package io.gocanvas.integration.ats.middleware.greenhouse.models;

/**
 * @author Prodapt Solutions
 *
 */
public class GreenHouseCandidateAttachments {
	private String filename;
	private String url;
	private String type;
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
		return "Attachments [filename=" + filename + ", url=" + url + ", type=" + type + "]";
	}
	
	
	
}
