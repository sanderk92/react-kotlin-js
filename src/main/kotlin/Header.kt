import react.Props
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.i
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.nav
import react.fc

external interface HeaderProps : Props {
    var sideBarOpen: Boolean
    var onBurgerClick: () -> Unit
}

val Header = fc<HeaderProps> { props ->
    nav {
        attrs.className = "navbar is-dark"

        div {
            attrs.className = "navbar-item"
            button {
                attrs.className = "button is-dark is-rounded"
                attrs.onClick = { props.onBurgerClick() }
                a {
                    attrs.className = "icon mx-1 has-text-light"
                    i {
                        attrs.className = if (props.sideBarOpen) "bx bx-x" else "bx bx-menu"
                    }
                }
            }
        }

        div {
            attrs.className = "navbar-menu"
            div {
                attrs.className = "navbar-end"
                div {
                    attrs.className = "navbar-brand"
                    a {
                        attrs.className = "navbar-item"
                        img {
                            attrs.src = "images/logo.svg"
                        }
                    }
                }
            }
        }
    }
}
