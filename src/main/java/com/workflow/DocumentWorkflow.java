package com.workflow;

public class DocumentWorkflow {

    public enum State {
        DRAFT, UNDER_REVIEW, APPROVED, REJECTED
    }

    private State currentState;

    public DocumentWorkflow() {
        this.currentState = State.DRAFT;
    }

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

    // ✅ ADD THIS MAIN METHOD
    public static void main(String[] args) {
        DocumentWorkflow workflow = new DocumentWorkflow();

        System.out.println("Initial State: " + workflow.getCurrentState());

        workflow.submitForReview();
        System.out.println("After Submit: " + workflow.getCurrentState());

        workflow.approve();
        System.out.println("After Approval: " + workflow.getCurrentState());
         while (true) {
        Thread.sleep(10000);
    }
    }
}
