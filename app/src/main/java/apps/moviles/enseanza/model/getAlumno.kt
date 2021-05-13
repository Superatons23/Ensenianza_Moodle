package apps.moviles.enseanza.model

data class getAlumno (
    val id: Int,
    val username: String,
    val firstname: String,
    val lastname: String,
    val fullname: String,
    val email: String,
    val department: String,
    val firstaccess: Long,
    val lastaccess: Long,
    val auth: String,
    val suspended: Boolean,
    val confirmed: Boolean,
    val lang: String,
    val theme: String,
    val timezone: String,
    val mailformat: Long,
    val description: String,
    val descriptionformat: Long,
    val city: String,
    val country: String,
    val profileimageurlsmall: String,
    val profileimageurl: String
)