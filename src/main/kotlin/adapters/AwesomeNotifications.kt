@file:JsModule("awesome-notifications")
@file:JsNonModule

package adapters

import kotlin.js.Json
import kotlin.js.Promise

@JsName("default")
external class AwesomeNotifications(globalOptions: Json = definedExternally) {
    fun tip(msg: String)
    fun info(msg: String)
    fun success(msg: String)
    fun warning(msg: String)
    fun alert(msg: String)
    fun modal(msg: String)
    fun async(promise: Promise<*>, msg: String)
    fun confirm(msg: String)
    fun confirm(msg: String, onOk: () -> Unit)
    fun confirm(msg: String, onOk: () -> Unit, onCancel: () -> Unit)
}
