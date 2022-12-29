package api.payload;

public class Pets {
	
	long id;
	String categ_name;
	String name;
	String status;
	String pending_status;
	String sold_status;
	
	public String getPending_status() {
		return pending_status;
	}
	public void setPending_status(String pending_status) {
		this.pending_status = pending_status;
	}
	public String getSold_status() {
		return sold_status;
	}
	public void setSold_status(String sold_status) {
		this.sold_status = sold_status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCateg_name() {
		return categ_name;
	}
	public void setCateg_name(String categ_name) {
		this.categ_name = categ_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
