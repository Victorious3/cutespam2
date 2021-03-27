import moe.nightfall.XMP
import nl.adaptivity.xmlutil.serialization.XML
import org.junit.jupiter.api.Test

class XMPParserTest {

    val xml = XML {}

    @Test
    fun `parse test xdf`() {
        val xmpString = XMPParserTest::class.java.getResource("/test.xmp").readText()
        val xmp = xml.decodeFromString(XMP.serializer(), xmpString)

        println(xmp)
    }
}