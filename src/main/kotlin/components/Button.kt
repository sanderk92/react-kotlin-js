package components

import components.elements.BulmaColor
import components.elements.BulmaSize
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.span
import react.fc

external interface ButtonProps : Props {
    var onPressed: () -> Unit
    var value: String
    var color: BulmaColor
    var size: BulmaSize
}

val Button = fc<ButtonProps> { props ->
    span {
        input {
            attrs {
                className = "button is-outlined is-rounded ${props.color.className} ${props.size.className}"
                type = InputType.button
                value = props.value
                onClick = { props.onPressed() }
            }
        }
    }
}
