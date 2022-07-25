package components

import csstype.ClassName
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
        attrs.className = ClassName("card opaque-hover clickable")
        div {
            attrs.className = ClassName("card-image")
            figure {
                img {
                    attrs.src = props.imageSrc
                }
            }
        }
        div {
            attrs.className = ClassName("card-content")
            +props.text
        }
    }
}

