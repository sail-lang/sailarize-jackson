package com.github.sailarize.fasterxml.test.mocks;

import com.github.sailarize.resource.Path;
import com.github.sailarize.resource.SailResource;

@Path("/persons")
public class PersonMock extends SailResource {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
}
