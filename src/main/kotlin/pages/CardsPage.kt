package pages

import components.Card
import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.figure
import react.dom.html.ReactHTML.img
import react.dom.img
import react.fc

val CardsPage = fc<Props> {

    div {
        attrs.className = ClassName("container")
        div {
            attrs.className = ClassName("columns is-multiline")

            repeat(10) {
                div {
                    attrs.className = ClassName("column is-one-fifth")
                    Card {
                        attrs {
                            text = "Card text"
                            imageSrc = "https://bulma.io/images/placeholders/1280x960.png"
                        }
                    }
                }
            }
        }
    }
}