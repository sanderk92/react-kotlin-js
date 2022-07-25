package pages

import Toaster
import components.*
import components.elements.BoxIcon
import components.elements.BulmaColor
import components.elements.BulmaSize
import csstype.ClassName
import react.Props
import react.dom.html.ReactHTML.div
import react.fc
import react.useContext
import react.useState
import kotlin.js.Date

val InputPage = fc<Props> {

    val toaster = useContext(Toaster)

    var datePickerSelection by useState(Date())
    var dropDownSelection by useState("")

    div {
        attrs.className = ClassName("columns is-centered")
        div {
            attrs.className = ClassName("column box is-narrow has-text-centered")

            div {
                attrs.className = ClassName("p-4")
                DatePicker {
                    attrs {
                        label = "Date picker"
                        initialDate = datePickerSelection
                        onSelect = {
                            datePickerSelection = it
                            toaster.info("Datepicker selected '$it'")
                        }
                    }
                }
            }

            div {
                attrs.className = ClassName("p-4")
                Dropdown {
                    attrs {
                        label = "Dropdown menu"
                        selected = dropDownSelection
                        options = listOf("Option 1", "Option 2" , "Option 3")
                        onSelect = {
                            dropDownSelection = it
                            toaster.info("Dropdown selected '$it'")
                        }
                    }
                }
            }

            div {
                attrs.className = ClassName("p-4")
                Button {
                    attrs {
                        value = "Button"
                        color = BulmaColor.Dark
                        size = BulmaSize.Normal
                        onPressed = { toaster.success("$dropDownSelection, $datePickerSelection") }
                    }
                }
            }
        }
    }
}