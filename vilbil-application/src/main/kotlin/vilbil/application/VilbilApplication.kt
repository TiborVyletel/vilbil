package vilbil.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import vilbil.adapter.dynamodb.wiring.AdapterDynamoDbConfiguration
import vilbil.admin.adapter.ui.wiring.AdminAdapterUiConfiguration
import vilbil.bills.adapter.rest.wiring.BillsAdapterRestConfiguration

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@Import(
  AdapterDynamoDbConfiguration::class,
  BillsAdapterRestConfiguration::class,
  AdminAdapterUiConfiguration::class,
)
class VilbilApplication

fun main(args: Array<String>) {
  runApplication<VilbilApplication>(*args)
}
