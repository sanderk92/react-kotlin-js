import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML
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
        attrs.className = ClassName("navbar is-dark")

        div {
            attrs.className = ClassName("navbar-item")
            button {
                attrs.className = ClassName("button is-dark is-rounded")
                attrs.onClick = { props.onBurgerClick() }
                a {
                    attrs.className = ClassName("icon mx-1 has-text-light")
                    i {
                        attrs.className = if (props.sideBarOpen) ClassName("bx bx-x") else ClassName("bx bx-menu")
                    }
                }
            }
        }

        div {
            attrs.className = ClassName("navbar-menu")
            div {
                attrs.className = ClassName("navbar-end")
                div {
                    attrs.className = ClassName("navbar-brand")
                    a {
                        attrs.className = ClassName("navbar-item")
                        img {
                            attrs.src = "images/logo.svg"
                        }
                    }
                }
            }
        }
    }
}
