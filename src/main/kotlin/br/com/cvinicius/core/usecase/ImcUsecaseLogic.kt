package br.com.cvinicius.core.usecase

import br.com.cvinicius.core.domain.defineClassification
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component
class ImcUsecaseLogic : ImcUsecase {

    override fun calcule(height: Double, weight: Double): ImcResponse {

        val resultValue = weight / (height * height)

        val classifyResult = defineClassification(resultValue)

        return with(classifyResult){

            val resultBigDecimal = BigDecimal.valueOf(resultValue).setScale(2, RoundingMode.HALF_EVEN)

            ImcResponse(resultBigDecimal, category, table)
        }
    }
}