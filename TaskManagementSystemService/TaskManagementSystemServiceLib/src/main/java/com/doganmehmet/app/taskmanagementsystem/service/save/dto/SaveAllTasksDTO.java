package com.doganmehmet.app.taskmanagementsystem.service.save.dto;

import com.doganmehmet.app.taskmanagementsystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class SaveAllTasksDTO {

    public String title;
    public String description;
    public Status status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDateTime deadline = LocalDateTime.now();
    public long projectId;


}
