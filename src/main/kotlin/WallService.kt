import attachments.Attachment

class WallService {
    private var postId = 1
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportsComment = emptyArray<ReportComment>()

    fun add(post: Post): Post {
        val postToAdd = post.copy(id = postId)
        posts += postToAdd
        postId++
        return posts.last()
    }

    fun update(postToUpdate: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postToUpdate.id) {
                posts[index] = postToUpdate.copy(
                    ownerId = posts[index].ownerId,
                    date = posts[index].date
                )
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment) {
        for (post in posts) {
            if (post.id == comment.postId) {
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

