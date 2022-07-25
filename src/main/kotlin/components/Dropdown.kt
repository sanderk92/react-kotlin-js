package components

import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.option
import react.dom.html.ReactHTML.select
import react.fc
import react.useEffect

external interface DropdownProps : Props {
    var label: String
    var onSelect: (String) -> Unit
    var selected: String
    var isLoading: Boolean?
    var isDisabled: Boolean?
    var options: List<String>
}

val Dropdown = fc<DropdownProps> { props ->

    label {
        attrs.htmlFor = props.label
        +"${props.label}:"
    }

    div {
        attrs.className = ClassName("select is-rounded full-width ${loadingClassFrom(props)}")

        select {
            attrs {
                id = props.label
                className = ClassName("full-width")
                disabled = props.isDisabled
                value = props.selected
                onChange = { props.onSelect(it.target.value) }
            }

            props.options.forEach { option ->
                option {
                    attrs.value = option
                    +option
                }
            }
        }
    }

    useEffect(props.options) {
        if (props.options.isNotEmpty() && !props.options.contains(props.selected)) {
            props.onSelect(props.options.first())
        }
    }
}

private fun loadingClassFrom(props: DropdownProps) =
    if (props.isLoading == true) {
        "is-loading"
    } else {
        ""
    }
