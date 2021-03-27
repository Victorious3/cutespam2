import moe.nightfall.XMP
import moe.nightfall.xmp.TestParser
import nl.adaptivity.xmlutil.serialization.XML
import org.junit.jupiter.api.Test

class XDFParserTest {

    val xml = XML {}

    @Test
    fun `parse test xdf`() {
        val xmpString = XDFParserTest::class.java.getResource("/test.xmp").readText()
        val xmp = xml.decodeFromString(XMP.serializer(), xmpString)

        println(xmp)
    }
}