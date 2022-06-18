package pages

import components.Card
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.figure
import react.dom.html.ReactHTML.img
import react.dom.img
import react.fc

val CardsPage = fc<Props> {

    div {
        attrs.className = "container"
        div {
            attrs.className = "columns is-multiline"
            repeat(15) {
                div {
                    attrs.className = "column is-one-third clickable hoverable"
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