package vilbil.adapter.dynamodb.bills

import reactor.core.publisher.Mono
import vilbil.domain.bill.Bill
import vilbil.domain.bill.Bills
import vilbil.domain.bill.CreateBillRequest

class DynamoDbBills(private val tableName: String = "VILBIL_BILLS") : Bills {
    override fun create(request: CreateBillRequest): Mono<Bill> =
        Mono.error(UnsupportedOperationException("Not yet implemented"))
}