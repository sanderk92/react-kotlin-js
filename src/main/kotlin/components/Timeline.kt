package components

import components.elements.BoxIcon
import components.elements.BulmaColor
import components.elements.BulmaSize
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.i
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.pre
import react.dom.html.ReactHTML.span
import react.fc
import react.useEffect
import react.useState

data class TimelineItem(
    val header: String,
    val message: String,
    val details: String,
    val severity: BulmaColor,
    val icon: BoxIcon,
)

external interface TimelineProps : Props {
    var timelineItems: List<TimelineItem>
}

val Timeline = fc<TimelineProps> { props ->
    var openTimePoints: List<Int> by useState(emptyList())

    div {
        attrs.className = "timeline"

        Button {
            attrs {
                value = if (openTimePoints.isEmpty()) "Open" else "Close"
                color = BulmaColor.None
                size = BulmaSize.Small
                onPressed = { openTimePoints = toggleAll(openTimePoints, props.timelineItems) }
            }
        }

        div {
            attrs.className = "timeline-header"
            span {
                attrs.className = "is-icon is-large is-primary"
                i {
                    attrs.className = "bx bxs-downvote"
                }
            }
        }

        props.timelineItems.forEachIndexed { index, item ->
            div {
                attrs.className = "timeline-item clickable grey-hover disable-select"
                attrs.onClick = { openTimePoints = toggle(openTimePoints, index) }
                div {
                    attrs.className = "timeline-marker is-icon clickable ${item.severity.className}"
                    i {
                        attrs.className = item.icon.className
                    }
                }
                div {
                    attrs.className = "timeline-content"
                    div {
                        p {
                            attrs.className = "heading break-word"
                            +item.header
                        }
                        p {
                            attrs.className = "break-word"
                            +item.message
                        }
                    }
                    div {
                        attrs.hidden = !openTimePoints.contains(index)
                        attrs.className = "message"
                        pre {
                            attrs.className = "message-body break-word"
                            +item.details
                        }
                    }
                }
            }
        }
    }

    useEffect(props.timelineItems) {
        openTimePoints = emptyList()
    }
}

private fun toggle(openTimePoints: List<Int>, index: Int): List<Int> =
    if (!openTimePoints.contains(index)) {
        openTimePoints + index
    } else {
        openTimePoints - index
    }

private fun toggleAll(openTimePoints: List<Int>, timeLineItems: List<TimelineItem>): List<Int> =
    if (openTimePoints.isNotEmpty()) {
        emptyList()
    } else {
        timeLineItems.indices.toList()
    }
