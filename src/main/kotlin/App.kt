import kotlinx.browser.window
import pages.IndexPage
import react.Props
import react.createElement
import react.dom.html.ReactHTML.aside
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.section
import react.fc
import react.router.Route
import react.router.Routes
import react.router.dom.HashRouter
import react.useState

val App = fc<Props> {
    var sideBarOpen by useState(window.outerWidth > 768)

    HashRouter {
        header {
            attrs.id = "header"
            child(Header) {
                attrs.sideBarOpen = sideBarOpen
                attrs.onBurgerClick = { sideBarOpen = !sideBarOpen }
            }
        }

        main {
            attrs.id = "main"

            aside {
                attrs.id = "sidebar"
                attrs.className = if (sideBarOpen) "sidebar-open" else "sidebar-closed"
                child(SideBar)
            }

            section {
                attrs.id = "content"

                Routes {
                    Route {
                        attrs.path = "/"
                        attrs.element = createElement(IndexPage)
                    }
                }
            }
        }
    }
}
