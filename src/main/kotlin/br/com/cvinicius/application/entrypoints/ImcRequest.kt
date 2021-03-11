package br.com.cvinicius.application.entrypoints

import javax.validation.constraints.NotNull

class ImcRequest {

    @NotNull(message="{message.height.notnull}")
    var height: Double? = null

    @NotNull(message="{message.weight.notnull}")
    var weight:Double? = null
}