package pages

import react.Props
import react.dom.html.ReactHTML.div
import react.fc

val HomePage = fc<Props> {
    div {
        +"Welcome"
    }
}
