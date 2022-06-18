package pages

import react.Props
import react.dom.html.ReactHTML.div
import react.fc

val HomePage = fc<Props> {
    div {
        attrs.className = "title has-text-centered"
        +"Welcome"
    }
    div {
        attrs.className = "subtitle has-text-centered"
        +"Kotlin-JS React + Bulma CSS"
    }
}
