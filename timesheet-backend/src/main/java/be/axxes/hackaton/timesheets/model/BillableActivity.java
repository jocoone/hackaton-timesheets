package be.axxes.hackaton.timesheets.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BillableActivity extends Activity{
	@ManyToOne
	private Project project;
	
	public Project getProject(){
		return this.project;
	}
	
	public void setProject(Project project){
		this.project = project;
	}
}
