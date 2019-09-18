package com.darren.repositories;


import com.darren.domain.JobRole;

import java.util.Set;

public interface JobRoleRepository extends CrudRepository<JobRole, String> {
    Set<JobRole> getAll();
}