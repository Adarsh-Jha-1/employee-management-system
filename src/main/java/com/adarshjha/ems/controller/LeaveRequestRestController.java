package com.adarshjha.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adarshjha.ems.entity.LeaveRequest;
import com.adarshjha.ems.service.LeaveRequestService;

@RestController
@RequestMapping("/leaveRequests")
public class LeaveRequestRestController {
    
    @Autowired
    private LeaveRequestService leaveRequestService;
    

    @PostMapping
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return new ResponseEntity<>(leaveRequestService.createLeaveRequest(leaveRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<LeaveRequest>> getAllLeaveRequests() {
        return new ResponseEntity<>(leaveRequestService.getAllLeaveRequests(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequestById(id)
                .map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveRequest> approveLeaveRequest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(leaveRequestService.approveLeaveRequest(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveRequest> rejectLeaveRequest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(leaveRequestService.rejectLeaveRequest(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/byEmployee/{employeeId}")
    public ResponseEntity<Iterable<LeaveRequest>> getLeaveRequestsByEmployee(@PathVariable Long employeeId) {
        try {
            Iterable<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestsByEmployeeId(employeeId);
            return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/pending")
    public ResponseEntity<Iterable<LeaveRequest>> getPendingLeaveRequests() {
        return new ResponseEntity<>(leaveRequestService.getPendingLeaveRequests(), HttpStatus.OK);
    }
}
