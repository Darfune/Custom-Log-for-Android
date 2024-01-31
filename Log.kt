import android.util.Log
import com.example.trainingproject.BuildConfig

fun StackTraceElement.generateMessage(msg: String = "") =
    className.substringAfterLast(".").substringBefore("$") +
            " | Line: $lineNumber - ${
                className
                    .substringAfter("$")
                    .substringBefore("$")
            } -> $msg"


fun <T> T.info(msg: () -> T) {
    if (BuildConfig.DEBUG)
        Throwable().stackTrace[1].apply {
            Log.i("Logged", generateMessage(msg.invoke().toString()))
        }
}

fun <T> T.error(msg: () -> T) {
    if (BuildConfig.DEBUG)
        Throwable().stackTrace[1].apply {
            Log.e("Logged", generateMessage(msg.invoke().toString()))
        }
}

fun <T> T.warning(msg: () -> T) {
    if (BuildConfig.DEBUG)
        Throwable().stackTrace[1].apply {
            Log.w("Logged", generateMessage(msg.invoke().toString()))
        }
}

fun <T> T.debug(msg: () -> T) {
    if (BuildConfig.DEBUG)
        Throwable().stackTrace[1].apply {
            Log.d("Logged", generateMessage(msg.invoke().toString()))
        }
}
