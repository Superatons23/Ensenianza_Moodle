package apps.moviles.enseanza.model



data class getMaestros (
    val id: Long,
    val username: String,
    val firstname: String,
    val lastname: String,
    val fullname: String,
    val email: String,
    val department: String,
    val firstaccess: Long,
    val lastaccess: Long,
    val lastcourseaccess: Long,
    val description: String,
    val descriptionformat: Long,
    val city: String,
    val country: String,
    val profileimageurlsmall: String,
    val profileimageurl: String,
    val groups: List<Any?>,
    val roles: List<Role>,
    val enrolledcourses: List<Enrolledcourse>
)

data class Enrolledcourse (
    val id: Long,
    val fullname: String,
    val shortname: String
)

data class Role (
    val roleid: Long,
    val name: String,
    val shortname: String,
    val sortorder: Long
)
