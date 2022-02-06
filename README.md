# Feedback Engine

This project is the backend for the Feedback Portal. 

### Installation

This backend will be running on default  `localhost:8080`. (UI https://github.com/Allysonooi/gt-frontend)

```sh
Execute bootRun
```

### View Submissions

GET `/api/submissions`

- Params:
  - email: String
  - contactNo: String

- Sample: GET `/api/submissions?email=a@a.com&contactNo=123`

### Submit single Submission

POST `/api/submissions`

```sh
// Sample Json

{
    "name": "C",
    "email": "c@c.com",
    "contactNo": "123456789",
    "agencyName": "cA",
    "feedback": "cF"
}
```

### Incompleted Tasks

- Configure for Production
  - Setup proper application.properties for different environments
- Improve
  - Method of configuration for higher traffic (E.g a batch/queue system)
  - Add Authentication + User Login etc 
- Write Unit tests
