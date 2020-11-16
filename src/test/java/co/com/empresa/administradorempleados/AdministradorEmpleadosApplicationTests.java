package co.com.empresa.administradorempleados;

import co.com.empresa.administradorempleados.controllers.EmpleadoController;
import co.com.empresa.administradorempleados.models.Empleado;
import co.com.empresa.administradorempleados.repositories.EmpleadoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorEmpleadosApplicationTests {

	@Autowired
	private EmpleadoController empleadoController;
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Test
	public void contextLoads() {
		assertThat(empleadoController).isNotNull();
	}

	@Test
	public void insertarEmpleado(){
		Empleado empleado = new Empleado(null, "C", "1016052582", "JUAN ACEVEDO", "Desarrollador", null);
		empleado = empleadoRepository.save(empleado);
		assertThat(empleado.getId()).isNotNull();
	}
}
