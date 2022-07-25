package pages

import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML.div
import react.fc

val HomePage = fc<Props> {
    div {
        attrs.className = ClassName("title has-text-centered")
        +"Welcome"
    }
    div {
        attrs.className = ClassName("subtitle has-text-centered")
        +"Kotlin-JS React + Bulma CSS"
    }
}
