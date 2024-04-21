package vilbil.admin.adapter.ui.widgets

import kotlinx.html.*
import java.lang.Appendable
import kotlinx.html.stream.appendHTML

class SimpleHtmxPage(
  private val name: String = "",
  private val htmxSource: String = "https://unpkg.com/htmx.org@1.6.1",
) {

  fun render(target: Appendable) {
    target.appendLine("<!DOCTYPE html>")
    target.appendHTML().html {
      head {
        meta { charset = "UTF-8" }
        if (name.isNotBlank()) {
          title { +name }
        }
        script { src = htmxSource }
      }
    }
  }
}

// <!DOCTYPE html>
// <html lang="en">
// <head>
// <meta charset="UTF-8">
// <title>HTMX Example</title>
// <script src="https://unpkg.com/htmx.org@1.6.1"></script>
// </head>
// <body>
// <div id="search-results">
// <!-- Search results will be loaded here -->
// </div>
//
// <input type="text" hx-get="/search" hx-trigger="keyup changed delay:500ms"
// hx-target="#search-results" hx-swap="innerHTML" placeholder="Search...">
//
// <button hx-post="/loadContent" hx-target="#content" hx-swap="outerHTML">
// Load New Content
// </button>
//
// <div id="content">
// Original Content
// </div>
// </body>
// </html>
