import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.i
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul
import react.fc
import react.router.dom.Link
import react.router.useLocation

val SideBar = fc<Props> {

    div {
        attrs.className = ClassName("menu")

        ul {
            attrs.className = ClassName("menu-list mt-5")

            p {
                attrs.className = ClassName("menu-label p-1 has-text-dark")
                +"My label"
            }
            li {
                attrs.className = ClassName("menu-item py-1")
                RouterLink {
                    attrs.path = "/"
                    attrs.value = "Home"
                    attrs.icon = "bx bx-home"
                }
            }
            li {
                attrs.className = ClassName("menu-item py-1")
                RouterLink {
                    attrs.path = "/timeline"
                    attrs.value = "Timeline"
                    attrs.icon = "bx bx-time"
                }
            }
            li {
                attrs.className = ClassName("menu-item py-1")
                RouterLink {
                    attrs.path = "/input"
                    attrs.value = "Input"
                    attrs.icon = "bx bx-search"
                }
            }
            li {
                attrs.className = ClassName("menu-item py-1")
                RouterLink {
                    attrs.path = "/cards"
                    attrs.value = "Cards"
                    attrs.icon = "bx bx-card"
                }
            }
        }
    }
}

private external interface RouterLinkProps : Props {
    var path: String
    var value: String
    var icon: String
}

private val RouterLink = fc<RouterLinkProps> { props ->
    Link {
        attrs.to = props.path
        if (props.path == useLocation().pathname) {
            attrs.className = ClassName("is-active")
        }

        span {
            attrs.className = ClassName("icon mx-1")
            i {
                attrs.className = ClassName(props.icon)
            }
        }
        +props.value
    }
}
