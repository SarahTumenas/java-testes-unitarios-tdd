package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void deveCalcularBonusDeUmFuncionarioComSalarioAcimaDoLimite() {
        BonusService bonusService = new BonusService();
//        assertThrows(IllegalArgumentException.class,
//                ()-> bonusService.calcularBonus(new Funcionario("Ricardo", LocalDate.now(),new BigDecimal("25000"))));

        try {
            bonusService.calcularBonus(new Funcionario("Ricardo", LocalDate.now(),new BigDecimal("25000")));
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário com salário acima do limite não receb Bonus", e.getMessage());
        }

    }

    @Test
    void deveCalcularBonusDe10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ricardo", LocalDate.now(),new BigDecimal("2500")));
        //assertEquals(BigDecimal.valueOf(250.0), bonus);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusDeveSer10PorCentoComSalarioLimite(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ricardo", LocalDate.now(),new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonus);

    }
}
