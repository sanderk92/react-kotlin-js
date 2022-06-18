package pages

import Toaster
import components.DatePicker
import components.Dropdown
import components.Timeline
import components.TimelineItem
import components.elements.BoxIcon
import components.elements.BulmaColor
import react.Props
import react.dom.html.ReactHTML.div
import react.fc
import react.useContext
import kotlin.js.Date

val InputPage = fc<Props> {

    val toaster = useContext(Toaster)

    div {
        attrs.className = "columns is-centered"
        div {
            attrs.className = "column is-narrow background-opaque card"
            DatePicker {
                attrs {
                    label = "Date picker"
                    initialDate = Date()
                    onSelect = { toaster.success("Datepicker selected $it") }
                }
            }

            Dropdown {
                attrs {
                    label = "Dropdown menu"
                    onSelect = { toaster.success("Dropdown selected $it") }
                    selected = "Nothing"
                    options = listOf("Option1", "Option2" , "Option3")
                }
            }
        }
    }

}