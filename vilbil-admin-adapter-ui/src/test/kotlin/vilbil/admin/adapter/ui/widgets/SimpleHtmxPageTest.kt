package vilbil.admin.adapter.ui.widgets

import com.google.common.truth.Truth.assertThat
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SimpleHtmxPageTest {

  private fun SimpleHtmxPage.renderAsDocument(): Document =
    Jsoup.parse(buildString { this@renderAsDocument.render(this) })

  @Test
  fun `when page name is specified, title element in html head contains it`() {
    val page = SimpleHtmxPage("My First Page")

    val htmlDoc = page.renderAsDocument()
    val titleElements = htmlDoc.head().getElementsByTag("title")
    assertTrue(titleElements.size == 1)

    val content = titleElements[0].text()
    assertThat(content).isEqualTo("My First Page")
  }

  @Test
  fun `when page name is not specified, html page does not contain title element`() {
    val page = SimpleHtmxPage()

    val doc = page.renderAsDocument()
    assertThat(doc.head().getElementsByTag("title")).isEmpty()
  }
}
