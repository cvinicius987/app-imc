package br.com.cvinicius.application.entrypoints

import br.com.cvinicius.core.usecase.ImcResponse
import br.com.cvinicius.core.usecase.ImcUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import javax.validation.Valid

@RestController
class ImcApi(val imc:ImcUsecase) {

    @PostMapping("/imc")
    fun imc(@Valid @RequestBody imcRequest: ImcRequest): ResponseEntity<ImcResponse> {

        return ResponseEntity.ok(imc.calcule(imcRequest.height!!, imcRequest.weight!!))
    }
}