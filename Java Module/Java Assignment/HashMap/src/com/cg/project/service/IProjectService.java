package com.cg.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.project.bean.ProjectDto;
import com.cg.project.exception.ProjectException;

public interface IProjectService {
	
	int insertProject(ProjectDto project) throws ProjectException;
	ProjectDto viewById(int ProjectId) throws ProjectException;
	ArrayList<ProjectDto> viewAllProject() throws ProjectException;
	boolean deleteProject(int ProjectId) throws ProjectException;
	boolean isProject(int id) throws ProjectException;
	HashMap<Integer,ProjectDto> viewAllProjectHash() throws ProjectException;

}
