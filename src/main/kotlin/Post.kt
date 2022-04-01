import attachments.Attachment

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes?,
    val reposts: Reposts?,
    val views: Views?,
    val postType: String,
    val postSource: PostSource?,
    val attachments: Array<Attachment>?,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: CopyHistory?,
    val canPin: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAd: Boolean,
    val isFavorite: Boolean,
    val donut: Donut?,
    val postponedId: Int
) {




}


