import br.com.alura.tdd.Calculadora;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculadoraTest {

        @Test
        void deveriaSomarDoisNumerosPositivos() {
           Calculadora calculadora = new Calculadora();
                int soma = calculadora.soma(1, 2);
              assertEquals(3, soma);
    }

}
