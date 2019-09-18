package com.darren.repositories;



import com.darren.domain.Admin;

import java.util.Set;

public interface AdminRepository extends CrudRepository<Admin, String> {
    Set<Admin> getAll();
}
