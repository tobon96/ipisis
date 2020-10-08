package com.ipisis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    private Long Id;
    private String description;
    private String details;
    private boolean done;

}
