package br.com.cvinicius.core.usecase

import br.com.cvinicius.core.domain.Classification.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ImcUsecaseTest {

    private val imcUsecase: ImcUsecase = ImcUsecaseLogic()

    @Test
    fun `Calcula o IMC com resultado = THINNESS`(){

        val height = 1.90
        val weight = 60.0

        imcUsecase.calcule(height, weight).run {

            assertEquals(BigDecimal.valueOf(16.62), result)
            assertEquals(category, THINNESS.category)
            assertEquals(message, THINNESS.table)
        }
    }

    @Test
    fun `Calcula o IMC com resultado = NORMAL`(){

        val height = 1.80
        val weight = 67.0

        imcUsecase.calcule(height, weight).run {

            assertEquals(BigDecimal.valueOf(20.68), result)
            assertEquals(category, NORMAL.category)
            assertEquals(message, NORMAL.table)
        }
    }

    @Test
    fun `Calcula o IMC com resultado = OVERWEIGHT`(){

        val height = 1.82
        val weight = 85.0

        imcUsecase.calcule(height, weight).run {

            assertEquals(BigDecimal.valueOf(25.66), result)
            assertEquals(category, OVERWEIGHT.category)
            assertEquals(message, OVERWEIGHT.table)
        }
    }

    @Test
    fun `Calcula o IMC com resultado = OBESITY`(){

        val height = 1.90
        val weight = 110.0

        imcUsecase.calcule(height, weight).run {

            assertEquals(BigDecimal.valueOf(30.47), result)
            assertEquals(category, OBESITY.category)
            assertEquals(message, OBESITY.table)
        }
    }

    @Test
    fun `Calcula o IMC com resultado = SERIOUS_OBESITY`(){

        val height = 1.85
        val weight = 160.0

        imcUsecase.calcule(height, weight).run {

            assertEquals(BigDecimal.valueOf(46.75), result)
            assertEquals(category, SERIOUS_OBESITY.category)
            assertEquals(message, SERIOUS_OBESITY.table)
        }
    }
}