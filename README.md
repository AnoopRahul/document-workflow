# Document Approval Workflow System

## Features
- Implements approval workflow with states: Draft → Review → Approved/Rejected
- JUnit tests for valid and invalid transitions
- CI/CD pipeline with Jenkins, Docker, Kubernetes

## Commands
- Build & Test: `mvn clean test`
- Package: `mvn clean package`
- Docker Build: `docker build -t yourdockerhubusername/document-workflow:latest .`
- Kubernetes Deploy: `kubectl apply -f deployment.yaml`
