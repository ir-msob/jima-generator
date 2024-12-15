package com.example.myproject.commondto.jima.child.characteristic;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Characteristic extends ir.msob.jima.core.commons.child.characteristic.Characteristic<<%= idClassName %>> {

}