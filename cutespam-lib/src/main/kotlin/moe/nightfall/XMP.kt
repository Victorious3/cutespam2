package moe.nightfall

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.*

private const val rdfNS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
private const val xmpNS = "http://ns.adobe.com/xap/1.0/"
private const val cuteNS = "http://ns.nightfall.moe/cutespam/1.0/"
private const val dcNS = "http://purl.org/dc/elements/1.1/"

@Serializable
@XmlSerialName("xmpmeta", "adobe:ns:meta/", "x")
data class XMP(
    @XmlElement(value = true)
    val rdf: RDF,
)

@Serializable
@XmlSerialName("RDF", rdfNS, "rdf")
data class RDF(
    @XmlElement(value = true)
    val description: Description,
)

@Serializable
@XmlSerialName("Description", rdfNS, "rdf")
data class Description(
    @XmlElement(false)
    @XmlSerialName("about", "", "rdf")
    val about: String,
    @XmlElement(false)
    @XmlSerialName("CreateDate", xmpNS, "xmp")
    val createDate: String,
    @XmlElement(false)
    @XmlSerialName("MetadataDate", xmpNS, "xmp")
    val metadataDate: String,
    @XmlElement(false)
    @XmlSerialName("rating", cuteNS, "cute")
    val rating: Rating,
    @XmlElement(false)
    @XmlSerialName("hash", cuteNS, "cute")
    val hash: String,
    @XmlElement(false)
    @XmlSerialName("group_id", cuteNS, "cute")
    val group_id: String,
    @XmlElement(false)
    @XmlSerialName("source", dcNS, "dc")
    val source: String,
    @XmlElement(false)
    @XmlSerialName("identifier", dcNS, "dc")
    val identifier: String,
    @XmlSerialName("creator", dcNS, "dc")
    val creator: RDFList,
    @XmlSerialName("src", cuteNS, "cute")
    val src: RDFBag,
    @XmlSerialName("via", cuteNS, "cute")
    val via: RDFBag,
    @XmlSerialName("subject", dcNS, "dc")
    val subject: RDFBag,
    @XmlSerialName("collections", cuteNS, "cute")
    val collections: RDFBag,
    @XmlSerialName("description", dcNS, "dc")
    val description: RDFAlt,
)

@Serializable
data class RDFList(
    @XmlSerialName("Seq", rdfNS, "rdf")
    @XmlChildrenName("li", rdfNS, "rdf")
    val li: List<String>
) : List<String> by li

@Serializable
data class RDFBag(
    @XmlSerialName("Bag", rdfNS, "rdf")
    @XmlChildrenName("li", rdfNS, "rdf")
    val li: Set<String>
) : Set<String> by li

@Serializable
data class RDFAlt(
    @XmlSerialName("Alt", rdfNS, "rdf")
    @XmlChildrenName("li", rdfNS, "rdf")
    val li: Set<String>
) : Set<String> by li
