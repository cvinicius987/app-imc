package br.com.cvinicius.core.usecase

import java.math.BigDecimal

data class ImcResponse(val result: BigDecimal,
                       val category:String,
                       val message:String)
