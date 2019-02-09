package com.cg.pms.dao;

import java.util.ArrayList;

import com.cg.pms.dto.ProjectDTO;
import com.cg.pms.exception.ProjectException;

public interface IProjectDao  {
	int insertProject(ProjectDTO p) throws ProjectException;
	ProjectDTO viewById(int projectId) throws ProjectException;
	ArrayList<ProjectDTO> viewAllProjects() throws ProjectException;
	boolean deleteProject(int projectId) throws ProjectException;
	boolean isProject(int projectId) throws ProjectException;
	
}
