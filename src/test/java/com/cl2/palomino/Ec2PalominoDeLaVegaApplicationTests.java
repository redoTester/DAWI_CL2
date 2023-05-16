package com.cl2.palomino;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cl2.palomino.entity.Sucursal;
import com.cl2.palomino.entity.Supervisor;

@SpringBootTest
class Ec2PalominoDeLaVegaApplicationTests {

	@Autowired
	private com.cl2.palomino.service.SupervisorService servicio;
	
	@Autowired
	private com.cl2.palomino.service.SucursalService servicio1;
	@Test
	void contextLoads() {
		//List<Sucursal> data=servicio1.listarSucursal();
		List<Supervisor> data=servicio.listarSupervisores();
		for(Supervisor a:data)
			System.out.println(a.getCodigo()+ " --- " + a.getNombre());
	}

}
