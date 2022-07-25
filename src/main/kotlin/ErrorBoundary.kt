import csstype.ClassName
import history.createBrowserHistory
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.i
import styled.css
import styled.styledDiv

external interface ErrorBoundaryState : State {
    var error: Throwable?
}

class ErrorBoundary : RComponent<PropsWithChildren, ErrorBoundaryState>() {

    override fun componentDidCatch(error: Throwable, info: ErrorInfo) {
        createBrowserHistory().push("/")
        setState { this.error = error }
    }

    override fun RBuilder.render() {
        state.error?.also {

            styledDiv {

                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    position = Position.fixed
                    justifyContent = JustifyContent.center
                    alignItems = Align.center
                    textAlign = TextAlign.center
                    width = 100.pct
                    height = 100.pct
                    zIndex = 999
                    color = Color.white
                    backgroundColor = Color.black
                    opacity = 0.8
                }

                div {
                    attrs.className = ClassName("icon is-large")
                    i {
                        attrs.className = ClassName("bx bx-lg bx-error has-text-danger")
                    }
                }

                div {
                    +"An unexpected fatal error has occurred: ${state.error}."
                    br {}
                    +"Please contact the system administrator or check the console for more information."
                    br {}
                    +"Press to continue."
                }

                attrs.onClickFunction = { setState { error = null } }
            }
        }
        props.children()
    }
}
