import adapters.module
import kotlinext.js.require
import kotlinx.browser.document
import org.w3c.dom.Element
import react.Props
import react.createElement
import react.dom.client.Root
import react.dom.client.createRoot

fun main() {
    importCssFiles()

    module.hot?.also {
        it.accept()
    }

    val element = createElement<Props> {
        child(ErrorBoundary::class) {
            child(App)
        }
    }

    getRoot().render(element)
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

private fun getRoot(): Root {
    val element = document.getElementById("root") ?: createRootDiv()
    document.body?.appendChild(element)
    return createRoot(element)
}

private fun createRootDiv(): Element {
    val element = document.createElement("div")
    element.id = "root"
    return element
}
