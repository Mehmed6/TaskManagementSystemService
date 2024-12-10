package com.doganmehmet.app.taskmanagementsystem.service.find.dto;

import com.doganmehmet.app.taskmanagementsystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class AllTasksDTO {

    public String title;

    public String description;

    public Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDateTime deadline;

    public long projectId;
    public String userName;


}
