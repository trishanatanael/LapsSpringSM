package edu.iss.laps.service;

import java.util.ArrayList;

import edu.iss.laps.model.Leave;

public interface LeaveService {

	ArrayList<Leave> findAllLeaves();

	Leave findLeave(Integer leid);

	Leave createLeave(Leave leave);

	Leave changeLeave(Leave leave);

	void removeLeave(Leave leave);

	ArrayList<Leave> findLeavesByEID(String eid);

	ArrayList<Leave> findPendingLeavesByEID(String eid);
	//eid=employee id

}