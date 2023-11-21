package com.deepweb.convo.entities;

import com.deepweb.convo.constants.DurationUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DurationModel {
    private Long id;
    private Long duration;
    private DurationUnit unit;
}
