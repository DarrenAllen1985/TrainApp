package com.darren.service;


import com.darren.domain.JobRole;

import java.util.Set;

public interface JobRoleService extends CrudService<JobRole, String> {
    Set<JobRole> getAll();
}