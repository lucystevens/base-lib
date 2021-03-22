import java.io.StringWriter
import java.io.PrintWriter

fun Exception.writeToString(): String {
	return StringWriter().apply {
		this@writeToString.printStackTrace(PrintWriter(this@apply))
	}.toString()
}