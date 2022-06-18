package components

import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.figure
import react.dom.html.ReactHTML.img
import react.fc

external interface CardProps : Props {
    var imageSrc: String
    var text: String
}

val Card = fc<CardProps> { props ->

    div {
        attrs.className = "card opaque-hoverable clickable"
        div {
            attrs.className = "card-image"
            figure {
                img {
                    attrs.src = props.imageSrc
                }
            }
        }
        div {
            attrs.className = "card-content"
            +props.text
        }
    }
}

