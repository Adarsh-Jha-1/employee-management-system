package com.adarshjha.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarshjha.ems.entity.Employee;
import com.adarshjha.ems.entity.LeaveRequest;
import com.adarshjha.ems.enums.LeaveRequestStatus;
import com.adarshjha.ems.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {

	@Autowired
	LeaveRequestRepository leaveRequestRepository;

	@Autowired
	private EmployeeService employeeService;

	public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
		return leaveRequestRepository.save(leaveRequest);
	}

	public Iterable<LeaveRequest> getAllLeaveRequests() {
		return leaveRequestRepository.findAll();
	}

	public Optional<LeaveRequest> getLeaveRequestById(Long id) {
		return leaveRequestRepository.findById(id);
	}

	public LeaveRequest approveLeaveRequest(Long id) {
		return leaveRequestRepository.findById(id).map(existingRequest -> {
			if (existingRequest.getStatus() == LeaveRequestStatus.APPROVED) {
				throw new IllegalStateException("Leave request already approved");
			} else if (existingRequest.getStatus() == LeaveRequestStatus.REJECTED) {
				throw new IllegalStateException("Leave request was rejected previously");
			}
			existingRequest.setStatus(LeaveRequestStatus.APPROVED);
			return leaveRequestRepository.save(existingRequest);
		}).orElseThrow(() -> new IllegalStateException("Leave request not found"));
	}

	public LeaveRequest rejectLeaveRequest(Long id) {
		return leaveRequestRepository.findById(id).map(existingRequest -> {
			if (existingRequest.getStatus() == LeaveRequestStatus.APPROVED) {
				throw new IllegalStateException("This is Approved Leave");
			} else if (existingRequest.getStatus() == LeaveRequestStatus.REJECTED) {
				throw new IllegalStateException("Leave request was rejected Already");
			}
			existingRequest.setStatus(LeaveRequestStatus.REJECTED);
			return leaveRequestRepository.save(existingRequest);
		}).orElseThrow(() -> new IllegalStateException("Leave request not found"));
	}

	public Iterable<LeaveRequest> getLeaveRequestsByEmployeeId(Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Employee not found"));
		return leaveRequestRepository.findByEmployee(employee);
	}

	public Iterable<LeaveRequest> getPendingLeaveRequests() {
		return leaveRequestRepository.findByStatus(LeaveRequestStatus.PENDING);
	}

}
