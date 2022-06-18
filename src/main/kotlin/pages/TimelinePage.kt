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
                    timelineItems = listOf(
                        TimelineItem(
                            header = "DANGER",
                            details = "You should check it out!",
                            icon = BoxIcon.Radiation,
                            message = "More information on what has happened",
                            severity = BulmaColor.Danger,
                        ),
                        TimelineItem(
                            header = "WARNING",
                            details = "You should check it out!",
                            icon = BoxIcon.Message,
                            message = "More information on what has happened",
                            severity = BulmaColor.Warning,
                        ),
                        TimelineItem(
                            header = "SUCCESS",
                            details = "You should check it out!",
                            icon = BoxIcon.Hand,
                            message = "More information on what has happened",
                            severity = BulmaColor.Success,
                        ),
                        TimelineItem(
                            header = "INFO",
                            details = "You should check it out!",
                            icon = BoxIcon.CogWheel,
                            message = "More information on what has happened",
                            severity = BulmaColor.Info,
                        ),
                        TimelineItem(
                            header = "DARK",
                            details = "You should check it out!",
                            icon = BoxIcon.ChevronRight,
                            message = "More information on what has happened",
                            severity = BulmaColor.Dark,
                        ),
                        TimelineItem(
                            header = "NONE",
                            details = "You should check it out!",
                            icon = BoxIcon.Quote,
                            message = "More information on what has happened",
                            severity = BulmaColor.None,
                        ),
                    )
                }
            }
        }
    }
}