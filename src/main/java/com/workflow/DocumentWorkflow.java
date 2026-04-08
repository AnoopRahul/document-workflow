package com.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/workflow")
public class DocumentWorkflowApplication {

    // ================= WORKFLOW LOGIC =================
    public enum State {
        DRAFT, UNDER_REVIEW, APPROVED, REJECTED
    }

    private State currentState = State.DRAFT;

    public State getCurrentState() {
        return currentState;
    }

    public void submitForReview() {
        if (currentState == State.DRAFT) {
            currentState = State.UNDER_REVIEW;
        } else {
            throw new IllegalStateException("Only draft documents can be submitted for review.");
        }
    }

    public void approve() {
        if (currentState == State.UNDER_REVIEW) {
            currentState = State.APPROVED;
        } else {
            throw new IllegalStateException("Only documents under review can be approved.");
        }
    }

    public void reject() {
        if (currentState == State.UNDER_REVIEW) {
            currentState = State.REJECTED;
        } else {
            throw new IllegalStateException("Only documents under review can be rejected.");
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        SpringApplication.run(DocumentWorkflowApplication.class, args);
    }

    // ================= REST APIs =================

    @GetMapping("/")
    public String home() {
        return "🚀 Document Workflow App Running!";
    }

    @GetMapping("/state")
    public State state() {
        return currentState;
    }

    @PostMapping("/submit")
    public String submit() {
        submitForReview();
        return "Submitted for review";
    }

    @PostMapping("/approve")
    public String approveDoc() {
        approve();
        return "Approved";
    }

    @PostMapping("/reject")
    public String rejectDoc() {
        reject();
        return "Rejected";
    }
}
