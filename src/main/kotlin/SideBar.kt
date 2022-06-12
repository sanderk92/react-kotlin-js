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
        attrs.className = "menu"

        ul {
            attrs.className = "menu-list mt-5"

            p {
                attrs.className = "menu-label p-1 has-text-dark"
                +"My label"
            }
            li {
                attrs.className = "menu-item px-2 py-1"
                RouterLink {
                    attrs.path = "/"
                    attrs.value = "Home"
                    attrs.icon = "bx bx-home"
                }
            }
            li {
                attrs.className = "menu-item px-2 py-1"
                RouterLink {
                    attrs.path = "/unused1"
                    attrs.value = "Unused"
                    attrs.icon = "bx bx-chart"
                }
            }
            li {
                attrs.className = "menu-item px-2 py-1"
                RouterLink {
                    attrs.path = "/unused2"
                    attrs.value = "Unused"
                    attrs.icon = "bx bx-battery"
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
            attrs.className = "is-active"
        }

        span {
            attrs.className = "icon mx-1"
            i {
                attrs.className = props.icon
            }
        }
        +props.value
    }
}
