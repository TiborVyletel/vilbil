package vilbil.domain.bill

import reactor.core.publisher.Mono

data class CreateBillRequest(val sellpointId: String)

interface Bills {

    fun create(request: CreateBillRequest): Mono<Bill>
}