package vilbil.bills.adapter.rest.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import vilbil.domain.bill.Bills

@RestController
class BillsController(private val bills: Bills) {

  private val logger: Logger = LoggerFactory.getLogger(BillsController::class.java)

  @RequestMapping(
    method = [RequestMethod.POST],
    path = ["/bills"],
    consumes = [APPLICATION_JSON_VALUE],
    produces = [APPLICATION_JSON_VALUE],
  )
  fun createBill(@RequestBody body: String): ResponseEntity<String> {
    logger.info("createBill invoked with $body")
    return ResponseEntity.status(HttpStatus.OK).contentType(APPLICATION_JSON).body(body)
  }
}
