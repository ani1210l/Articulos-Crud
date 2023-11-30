package com.tf4beta.ems.main.repository;

import com.tf4beta.ems.main.entity.IngresoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngresoDetalleRepository extends JpaRepository<IngresoDetalles, Integer> {


List<IngresoDetalles> findAllByOrderByLastNameAsc();
}
