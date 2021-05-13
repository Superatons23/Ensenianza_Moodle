package apps.moviles.enseanza.model

data class Parcial (
    val id: Int,
    val name: String,
    val visible: Long,
    val summary: String,
    val summaryformat: Long,
    val section: Long,
    val hiddenbynumsections: Long,
    val uservisible: Boolean,
    val modules: List<Module>
)

data class Module (
    val id: Int,
    val url: String,
    val name: String,
    val instance: Int?,
    val contextid: Long,
    val visible: Long,
    val uservisible: Boolean,
    val visibleoncoursepage: Long,
    val modicon: String,
    val modname: String,
    val modplural: String,
    val availability: Any? = null,
    val indent: Long,
    val onclick: String,
    val afterlink: Any? = null,
    val customdata: String,
    val noviewlink: Boolean,
    val completion: Long,
    val completiondata: Completiondata
)

data class Completiondata (
    val state: Long,
    val timecompleted: Long,
    val overrideby: Any? = null,
    val valueused: Boolean
)