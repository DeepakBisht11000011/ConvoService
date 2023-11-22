package com.deepweb.convo.entities;

import com.deepweb.convo.constants.DurationUnit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
public class DurationModel {
    private Long id;
    private Long duration;
    private DurationUnit unit;
}
