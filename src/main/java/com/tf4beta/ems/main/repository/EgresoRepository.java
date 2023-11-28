package com.tf4beta.ems.main.repository;

import com.tf4beta.ems.main.entity.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface EgresoRepository extends JpaRepository <Egreso , Integer> {
}
