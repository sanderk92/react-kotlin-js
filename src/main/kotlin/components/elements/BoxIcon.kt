package components.elements

import csstype.ClassName

enum class BoxIcon(val className: ClassName) {
    Quote(ClassName("bx bxs-quote-right")),
    Message(ClassName("bx bxs-message-alt")),
    Hand(ClassName("bx bxs-hand")),
    Radiation(ClassName("bx bxs-radiation")),
    CogWheel(ClassName("bx bxs-cog")),
    ChevronRight(ClassName("bx bxs-chevron-right"))
}
