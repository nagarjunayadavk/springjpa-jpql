package com.springjpql.jpql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchInput {
	private String column;
	private String value;
}
