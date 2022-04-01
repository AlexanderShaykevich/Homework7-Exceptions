import attachments.Attachment;

data class Comment (
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val isDon: Boolean,
    val placeholder: String,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Attachment?,
    val parents_stack: Array<Integer>?,
    val thread: Thread?,
) {
}
