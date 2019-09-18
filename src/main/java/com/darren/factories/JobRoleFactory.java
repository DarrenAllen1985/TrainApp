package com.darren.factories;


import com.darren.domain.JobRole;

public class JobRoleFactory {

    public static JobRole createJobRole(String jobRoleId, String jobRoleDescription, double jobRoleSalary) {
        return new JobRole.Builder()
                .jobRoleId(jobRoleId)
                .jobRoleDescription(jobRoleDescription)
                .jobRoleSalary(jobRoleSalary)
                .build();
    }
}