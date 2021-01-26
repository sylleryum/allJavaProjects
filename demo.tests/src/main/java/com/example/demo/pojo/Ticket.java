package com.example.demo.pojo;

public class Ticket {
    private String Task;
    private String Hasbreached;
    private String AssignmentGroup;
    private String AssignedTo;
    private String Openedby;
    private String ShortDescription;
    private String Status;
    private String Description;
    private String Country;
    private String Created;
    private String Closed;
    private String Contacttype;
    private String COE;
    private String hrService;
    private String topicCategory;
    private String EmployeeNumber;

    public Ticket() {
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getHasbreached() {
        return Hasbreached;
    }

    public void setHasbreached(String hasbreached) {
        Hasbreached = hasbreached;
    }

    public String getAssignmentGroup() {
        return AssignmentGroup;
    }

    public void setAssignmentGroup(String assignmentGroup) {
        AssignmentGroup = assignmentGroup;
    }

    public String getAssignedTo() {
        return AssignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        AssignedTo = assignedTo;
    }

    public String getOpenedby() {
        return Openedby;
    }

    public void setOpenedby(String openedby) {
        Openedby = openedby;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getClosed() {
        return Closed;
    }

    public void setClosed(String closed) {
        Closed = closed;
    }

    public String getContacttype() {
        return Contacttype;
    }

    public void setContacttype(String contacttype) {
        Contacttype = contacttype;
    }

    public String getCOE() {
        return COE;
    }

    public void setCOE(String COE) {
        this.COE = COE;
    }

    public String getHrService() {
        return hrService;
    }

    public void setHrService(String hrService) {
        this.hrService = hrService;
    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public String getEmployeeNumber() {
        return EmployeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        EmployeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Task='" + Task + '\'' +
                ", Hasbreached='" + Hasbreached + '\'' +
                ", AssignmentGroup='" + AssignmentGroup + '\'' +
                ", AssignedTo='" + AssignedTo + '\'' +
                ", Openedby='" + Openedby + '\'' +
                ", ShortDescription='" + ShortDescription + '\'' +
                ", Status='" + Status + '\'' +
                ", Description='" + Description + '\'' +
                ", Country='" + Country + '\'' +
                ", Created='" + Created + '\'' +
                ", Closed='" + Closed + '\'' +
                ", Contacttype='" + Contacttype + '\'' +
                ", COE='" + COE + '\'' +
                ", hrService='" + hrService + '\'' +
                ", topicCategory='" + topicCategory + '\'' +
                ", EmployeeNumber='" + EmployeeNumber + '\'' +
                '}';
    }
}
