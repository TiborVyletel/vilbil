package vilbil.adapter.dynamodb.wiring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import vilbil.adapter.dynamodb.bills.DynamoDbBills

@Configuration(proxyBeanMethods = false)
class AdapterDynamoDbConfiguration {

    // TODO: take table name from value adapter.dynamodb.tables.bills

    @Bean
    fun dynamoDbBills(): DynamoDbBills = DynamoDbBills()
}