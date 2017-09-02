package be.axxes.hackaton.timesheets.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BillableActivity extends Activity{
	@ManyToOne
	private Project project;
	 
    @NotNull
	private Integer factor;
    
    public Integer getFactor(){
    	return factor;
    }
    
    public void setFactor(Integer factor){
    	this.factor=factor;
    }
	
	public Project getProject(){
		return this.project;
	}
	
	public void setProject(Project project){
		this.project = project;
	}
}
