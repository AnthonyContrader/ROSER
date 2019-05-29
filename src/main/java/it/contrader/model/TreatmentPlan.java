package it.contrader.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TreatmentPlan {
private int planId;
private String planDescription;
private Date planStart;
private Date planEnd;

public TreatmentPlan(int planId , String planDescription , Date planStart , Date planEnd) {
	this.planId = planId;
	this.planDescription = planDescription ;
	this.planStart = planStart;
	this.planEnd = planEnd;
}

public int getPlanId() {
	return planId;
}

public void setPlanId(int planId) {
	this.planId = planId;
}

public String getPlanDescription() {
	return planDescription;
}

public void setPlanDescription(String planDescription) {
	this.planDescription = planDescription;
}

public Date getPlanStart() {
	return planStart;
}

public void setPlanStart(Date planStart) {
	this.planStart = planStart;
}

public Date getPlanEnd() {
	return planEnd;
}

public void setPlanEnd(Date planEnd) {
	this.planEnd = planEnd;
}
@Override
public String toString() {
	DateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
	String start = formatter.format(getPlanStart());
	String end = formatter.format(getPlanEnd());
		
	return this.getPlanId() + "\t" + start + "\t" + end + "\t" + this.getPlanDescription();
}
}
