package br.com.cvinicius.config

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

open class ErrorMessage(open val message:String)

data class FieldErrorMessage(override val message:String,
                                      val field:String) : ErrorMessage(message)

@RestControllerAdvice
class ErrorController(val messageSource: MessageSource) {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(ex: MethodArgumentNotValidException): List<FieldErrorMessage>? {

        return ex.bindingResult.fieldErrors.map {
            FieldErrorMessage(messageSource.getMessage(it, LocaleContextHolder.getLocale()), it.field)
        }
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    fun methodArgumentNotValidException(ex: HttpMessageNotReadableException): ErrorMessage {

        return ErrorMessage(ex.localizedMessage)
    }
}