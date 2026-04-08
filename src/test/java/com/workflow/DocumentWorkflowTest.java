package com.workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentWorkflowTest {

    @Test
    void testValidApprovalFlow() {
       DocumentWorkflowApplication app = new DocumentWorkflowApplication();
        doc.submitForReview();
        doc.approve();
        assertEquals(DocumentWorkflow.State.APPROVED, doc.getCurrentState());
    }

    @Test
    void testValidRejectionFlow() {
        DocumentWorkflow doc = new DocumentWorkflowApplication();
        doc.submitForReview();
        doc.reject();
        assertEquals(DocumentWorkflow.State.REJECTED, doc.getCurrentState());
    }

    @Test
    void testInvalidTransition() {
        DocumentWorkflow doc = new DocumentWorkflowApplication();
        assertThrows(IllegalStateException.class, doc::approve);
    }
}
