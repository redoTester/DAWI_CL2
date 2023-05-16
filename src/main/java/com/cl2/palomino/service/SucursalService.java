package com.cl2.palomino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl2.palomino.entity.Sucursal;
import com.cl2.palomino.repository.SucursalRepository;

@Service
public class SucursalService {

	@Autowired
	private SucursalRepository repo;
	
	public List<Sucursal> listarSucursal(){
		return repo.findAll();
	}
}
