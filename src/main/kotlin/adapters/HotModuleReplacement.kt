package adapters

external val module: Module

external interface Module {
    val hot: Hot?
}

external interface Hot {
    fun accept()
}
