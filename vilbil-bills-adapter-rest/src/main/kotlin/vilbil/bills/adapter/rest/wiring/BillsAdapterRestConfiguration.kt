package vilbil.bills.adapter.rest.wiring

import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunctions.resources
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

class BillsAdapterRestConfiguration {

  @Bean
  fun billsRoutes() = router {
    POST("/bills") {
      it.bodyToMono(String::class.java).flatMap { body ->
        ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(body)
      }
    }
  }

  @Bean fun staticContent() = resources("/**", ClassPathResource("public/"))
}
