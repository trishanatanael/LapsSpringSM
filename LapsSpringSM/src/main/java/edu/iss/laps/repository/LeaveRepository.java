package edu.iss.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.laps.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
	
	@Query("SELECT l FROM leave_application l WHERE l.EmployeeID = :eid")
	ArrayList<Leave> findLeavesByEID(@Param("eid") String eid);
	
	@Query("SELECT l FROM leave_application l WHERE l.EmployeeID = :eid AND (l.Status ='SUBMITTED' OR l.Status ='UPDATED')")
	ArrayList<Leave> findPendingLeavesByEID(@Param("eid") String eid);
	
	@Query(value = "SELECT * FROM leave_application WHERE status = ?0", nativeQuery = true)
	ArrayList<Leave> findPendingLeavesByStatus(String status);

}
