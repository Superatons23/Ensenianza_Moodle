package apps.moviles.enseanza.model

data class getTareas (
    val courseid: Int,
    val userid: Int,
    val userfullname: String,
    val useridnumber: String,
    val maxdepth: Long,
    val gradeitems: List<tareas>
)

data class tareas (
    val id: Int,
    val itemname: String,
    val itemtype: String,
    val itemmodule: String? = null,
    val iteminstance: Int?,
    val itemnumber: Long? = null,
    val idnumber: String,
    val categoryid: Long? = null,
    val outcomeid: Any? = null,
    val scaleid: Any? = null,
    val locked: Boolean,
    val cmid: Long? = null,
    val weightraw: Double? = null,
    val weightformatted: String? = null,
    val graderaw: Long,
    val gradedatesubmitted: Any? = null,
    val gradedategraded: Long,
    val gradehiddenbydate: Boolean,
    val gradeneedsupdate: Boolean,
    val gradeishidden: Boolean,
    val gradeislocked: Boolean,
    val gradeisoverridden: Boolean,
    val gradeformatted: String,
    val grademin: Long,
    val grademax: Long,
    val rangeformatted: String,
    val percentageformatted: String,
    val feedback: String,
    val feedbackformat: Long
)