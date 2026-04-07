package com.workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentWorkflowTest {

    @Test
    void testValidApprovalFlow() {
        DocumentWorkflow doc = new DocumentWorkflow();
        doc.submitForReview();
        doc.approve();
        assertEquals(DocumentWorkflow.State.APPROVED, doc.getCurrentState());
    }

    @Test
    void testValidRejectionFlow() {
        DocumentWorkflow doc = new DocumentWorkflow();
        doc.submitForReview();
        doc.reject();
        assertEquals(DocumentWorkflow.State.REJECTED, doc.getCurrentState());
    }

    @Test
    void testInvalidTransition() {
        DocumentWorkflow doc = new DocumentWorkflow();
        assertThrows(IllegalStateException.class, doc::approve);
    }
}
