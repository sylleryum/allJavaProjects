package application;

public class Ticket {
	private String cai;
	private String summary;
	private String notes;
	
	public Ticket(String cai, String summary, String notes) {
		this.cai = cai;
		this.summary = summary;
		this.notes = notes;
	}
	
	public String getCai() {
		return cai;
	}
	public String getSummary() {
		return summary;
	}
	public String getNotes() {
		return notes;
	}
	public void setCai(String cai) {
		this.cai = cai;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setTicket(String cai, String summary, String notes){
		this.cai = cai;
		this.summary = summary;
		this.notes = notes;
	}
	
	
	@Override
	public String toString() {
		return summary;
	}
	
	
}
