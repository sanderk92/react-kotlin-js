package components

import csstype.ClassName
import extensions.toUtcISoDateString
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.fc
import react.useEffectOnce
import kotlin.js.Date

external interface DatePickerProps : Props {
    var label: String
    var onSelect: (Date) -> Unit
    var initialDate: Date
}

val DatePicker = fc<DatePickerProps> { props ->

    label {
        attrs.htmlFor = props.label
        +"${props.label}:"
    }

    input {
        attrs {
            id = props.label
            className = ClassName("input is-rounded")
            type = InputType.date
            defaultValue = props.initialDate.toUtcISoDateString()
            required = true
            onChange = {
                props.onSelect(
                    Date(it.target.value)
                )
            }
        }
    }

    useEffectOnce {
        props.onSelect(props.initialDate)
    }
}
