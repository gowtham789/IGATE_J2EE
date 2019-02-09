package com.cg.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.project.dao.ProjectDao;
import com.cg.project.bean.ProjectDto;
import com.cg.project.exception.ProjectException;

public class ProjectService implements IProjectService {
	ProjectDao pdao=new ProjectDao();

	@Override
	public int insertProject(ProjectDto project) throws ProjectException{
		int projid=pdao.insertProject(project);
		return projid;
	}

	@Override
	public ProjectDto viewById(int ProjectId) throws ProjectException{
		return pdao.viewById(ProjectId);
	}

	@Override
	public ArrayList<ProjectDto> viewAllProject() throws ProjectException{
		return pdao.viewAllProject();
	}

	@Override
	public boolean deleteProject(int ProjectId) throws ProjectException{
		return pdao.deleteProject(ProjectId);
	}

	@Override
	public boolean isProject(int id) throws ProjectException {
		return pdao.isProject(id);
	}

	@Override
	public HashMap<Integer, ProjectDto> viewAllProjectHash()
			throws ProjectException {
		return pdao.viewAllProjectHash();
	}

}
