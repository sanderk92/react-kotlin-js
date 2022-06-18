package pages

import components.Timeline
import components.TimelineItem
import components.elements.BoxIcon
import components.elements.BulmaColor
import react.Props
import react.dom.html.ReactHTML.div
import react.fc

val TimelinePage = fc<Props> {

    div {
        attrs.className = "columns is-centered"
        div {
            attrs.className = "column is-one-third background-opaque card"
            Timeline {
                attrs {
                    timelineItems = (1..6).map {
                        TimelineItem(
                            header = "Something has failed",
                            details = "You should check it out!",
                            icon = BoxIcon.Radiation,
                            message = "More information on what has happened",
                            severity = BulmaColor.Danger,
                        )
                    }
                }
            }
        }
    }
}