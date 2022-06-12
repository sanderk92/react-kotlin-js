import adapters.module
import kotlinext.js.require
import kotlinx.browser.document
import org.w3c.dom.Element
import react.createElement
import react.dom.render

fun main() {
    importCssFiles()

    module.hot?.also {
        it.accept()
    }

    render(
        element = createElement { child(ErrorBoundary::class) { child(App) } },
        container = getRootElement().also { document.body!!.appendChild(it) }
    )
}

private fun importCssFiles() {
    // Resources
    require("styles.css")
    require("boxicons.min.css")
    require("bulma.min.css")
    require("bulma-divider.min.css")
    require("bulma-timeline.min.css")

    // External
    require("awesome-notifications/dist/style.css")
}

private fun getRootElement(): Element =
    document.getElementById("root") ?: createRootElement()

private fun createRootElement(): Element {
    val element = document.createElement("div")
    element.id = "root"
    return element
}
