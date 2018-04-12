package com.ljz.test.design_mode.filter_pattern;

import java.util.List;

//标准
public interface Criteria {
   public List<Person> meetCriteria(List<Person> persons);
}