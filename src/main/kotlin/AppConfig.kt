import adapters.AwesomeNotifications
import http.HttpClient
import react.createContext
import kotlin.js.json

private val httpClient = HttpClient()

val Toaster = createContext(AwesomeNotifications(
    globalOptions = json(
        "maxNotifications" to 3,
        "durations" to json(
            "global" to 10000
        )
    )
))
