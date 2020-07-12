
package teste_api_aluguel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import teste_api_aluguel.Aluguel;

public class AluguelTest {

	
	@ParameterizedTest
	@CsvSource(value={"900.0:0:-1.0", "900.0:1:810.0", "900.0:2:810.0", "900.0:4:810.0", "900.0:5:810.0", "900.0:6:855.0", "900.0:9:855.0", "900.0:10:855.0", 
			   "900.0:11:900.0", "900.0:14:900.0", "900.0:15:900.0", "900.0:16:918.9", "900.0:29:930.6", "900.0:30:931.5", "900.0:31:-1.0"},
			   delimiter=':')
	public void testVMU(Double valorAluguel, int dia, Double valor_calculado){
		Aluguel aluguel = new Aluguel();
		assertEquals(valor_calculado, aluguel.requisitarSite(valorAluguel, dia));
	}

	@Disabled
	@ParameterizedTest(name="Teste {index} => valorAluguel={0} dia={1},"
					   + "valor_calculado={2}")
	@CsvFileSource(resources="/valores_teste.csv",
				   delimiter=',')
	public void test2VMU(Double valorAluguel, int dia, Double valor_calculado){
		Aluguel aluguel = new Aluguel();
		assertEquals(valor_calculado, aluguel.requisitarSite(valorAluguel, dia));
	}

}