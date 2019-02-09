package com.cg.pms.service;

import java.util.ArrayList;


import com.cg.pms.dao.ProjectDao;
import com.cg.pms.dto.ProjectDTO;
import com.cg.pms.exception.ProjectException;

public class ProjectService implements IProjectService{
	
	ProjectDao pdao=new ProjectDao();
	
	@Override
	public int insertProject(ProjectDTO p) throws ProjectException{
		int pid=pdao.insertProject(p);
		return pid;
	}

	@Override
	public ProjectDTO viewById(int projectId)throws ProjectException {
		return pdao.viewById(projectId);
	}

	@Override
	public ArrayList<ProjectDTO> viewAllProjects()throws ProjectException {
		// TODO Auto-generated method stub
	return pdao.viewAllProjects();
	}

	@Override
	public boolean deleteProject(int projectId)throws ProjectException {
		// TODO Auto-generated method stub
		return pdao.deleteProject(projectId);
	}

	@Override
	public boolean isProject(int projectId) throws ProjectException{
		return pdao.isProject(projectId);
	}

	
}
