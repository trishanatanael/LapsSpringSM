package edu.iss.laps.service;

import java.util.ArrayList;

import edu.iss.laps.model.LeaveEvent;

public interface LeaveEventService {

	ArrayList<LeaveEvent> findAllLeaveEvents();

	LeaveEvent findLeaveEvent(Integer leid);

	LeaveEvent createLeaveEvent(LeaveEvent leaveEvent);

	LeaveEvent changeLeaveEvent(LeaveEvent leaveEvent);

	void removeLeaveEvent(LeaveEvent leaveEvent);

}