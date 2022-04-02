import attachments.Attachment

class WallService {
    private var postId = 1
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
    var attachments = emptyArray<Attachment>()
    var reportsComment = emptyArray<ReportComment>()

    fun add(post: Post): Post {
        post.id = postId
        posts += post
        postId++
        return posts.last()
    }

    fun update(postToUpdate: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postToUpdate.id) {
                posts[index] = post.copy(
                    ownerId = postToUpdate.ownerId,
                    fromId = postToUpdate.fromId,
                    createdBy = postToUpdate.createdBy,
                    text = postToUpdate.text,
                    replyOwnerId = postToUpdate.replyOwnerId,
                    replyPostId = postToUpdate.replyPostId,
                    friendsOnly = postToUpdate.friendsOnly,
                    comments = postToUpdate.comments,
                    copyright = postToUpdate.copyright,
                    likes = postToUpdate.likes,
                    reposts = postToUpdate.reposts,
                    views = postToUpdate.views,
                    postType = postToUpdate.postType,
                    postSource = postToUpdate.postSource,
                    attachments = postToUpdate.attachments,
                    geo = postToUpdate.geo,
                    signerId = postToUpdate.signerId,
                    copyHistory = postToUpdate.copyHistory,
                    canPin = postToUpdate.canPin,
                    canEdit = postToUpdate.canEdit,
                    isPinned = postToUpdate.isPinned,
                    markedAsAd = postToUpdate.markedAsAd,
                    isFavorite = postToUpdate.isFavorite,
                    donut = postToUpdate.donut,
                    postponedId = postToUpdate.postponedId
                )
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment, postId: Int) {
        for (post in posts) {
            if (postId == comment.id) {
                comments += comment
            } else throw PostNotFoundException()
        }
    }

    fun addReportComment(reportComment: ReportComment) {
        if (reportComment.reason !in 0..8) throw FalseReasonException()
        for (post in posts) {
            if (post.id == reportComment.postId) {
                reportsComment += reportComment
            } else throw PostNotFoundException()
        }
    }


}

