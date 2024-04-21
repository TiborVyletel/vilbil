package vilbil.admin.adapter.ui.wiring

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.function.server.RouterFunctions.resources
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

class AdminAdapterUiConfiguration {

  private val logger: Logger = LoggerFactory.getLogger(AdminAdapterUiConfiguration::class.java)

  @Bean
  fun adminEditRoute() = router {
    GET("/admin/edit.html") {
      ServerResponse.ok()
        .contentType(TEXT_HTML)
        .bodyValue(
          """
          <form hx-put="/admin" hx-target="this" hx-swap="outerHTML">
            <div>
              <label>First Name</label>
              <input type="text" name="firstName" value="Joe">
            </div>
            <div class="form-group">
              <label>Last Name</label>
              <input type="text" name="lastName" value="Blow">
            </div>
            <div class="form-group">
              <label>Email Address</label>
              <input type="email" name="email" value="joe@blow.com">
            </div>
            <button class="btn">Submit</button>
            <button class="btn" hx-get="/contact/1">Cancel</button>
          </form>
        """
            .trimIndent()
        )
        .doOnNext { response -> logger.info("Responding with: $response") }
    }
  }

  @Bean fun adminStaticContent() = resources("/admin/**", ClassPathResource("public/"))
}
