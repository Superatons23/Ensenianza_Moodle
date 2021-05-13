package apps.moviles.enseanza.model

data class getCursos (
    val id: Int,
    val shortname: String,
    val fullname: String,
    val displayname: String,
    val enrolledusercount: Long,
    val idnumber: String,
    val visible: Long,
    val summary: String,
    val summaryformat: Long,
    val format: String,
    val showgrades: Boolean,
    val lang: String,
    val enablecompletion: Boolean,
    val completionhascriteria: Boolean,
    val completionusertracked: Boolean,
    val category: Long,
    val progress: Long? = null,
    val completed: Boolean,
    val startdate: Long,
    val enddate: Long,
    val marker: Long,
    val lastaccess: Long,
    val isfavourite: Boolean,
    val hidden: Boolean,
    val overviewfiles: List<Overviewfile>
)

data class Overviewfile (
    val filename: String,
    val filepath: String,
    val filesize: Long,
    val fileurl: String,
    val timemodified: Long,
    val mimetype: String
)
