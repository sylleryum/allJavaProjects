package application;

public class ParseKb {

	private String kb;
	private String link;

	public ParseKb(String kb, String link) {
		this.kb = kb;
		this.link = link;
	}	

	public String getKb() {
		return kb;
	}

	public String getLink() {
		return link;
	}

	public void setKb(String kb) {
		this.kb = kb;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return kb;
	}

}
