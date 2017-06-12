package edu.iss.laps.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.laps.model.Employee;
import edu.iss.laps.model.Leave;
import edu.iss.laps.service.LeaveService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	private LeaveService cService;

	@Autowired
	private LeaveEventService ceService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	
	@RequestMapping(value = "/pending")
	public ModelAndView pendingApprovals(HttpSession session) {
		HashMap<Employee, ArrayList<Leave>> hm = new HashMap<Employee, ArrayList<Leave>>();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		System.out.println(us.toString());
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			for (Employee employee : us.getSubordinates()) {
				ArrayList<Leave> clist = cService.findPendingLeavesByEID(employee.getEmployeeId());
				hm.put(employee, clist);
			}
			mav = new ModelAndView("manager-pending-leave-application");
			mav.addObject("pendinghistory", hm);
			return mav;
		}
		return mav;

	}
	
	@RequestMapping(value = "/shistory")
	public ModelAndView subordinatesHistory(HttpSession session) {
		
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		HashMap<Employee, ArrayList<Leave>> submap = new HashMap<Employee, ArrayList<Leave>>();		
		for (Employee subordinate : us.getSubordinates()) {
			submap.put(subordinate, cService.findCoursesByEID(subordinate.getEmployeeId()));
		}
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null && us.getSubordinates() != null) {
			mav = new ModelAndView("/subordinates-course-history");
			mav.addObject("submap", submap);
			return mav;
		}
		return mav;

	}

}
