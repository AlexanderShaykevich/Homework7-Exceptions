import attachments.Attachment

class WallService {
    private var postId = 1
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
    var reportsComment = emptyArray<ReportComment>()
    var count: Int = 0

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

//    fun createComment(comment: Comment) {
//        for (post in posts) {
//            if (post.id == comment.postId) {
//                comments += comment
//                break
//            } else throw PostNotFoundException()
//        }
//    }

    fun createComment(comment: Comment) {
        var isPostExists = false

        for (post in posts) {
            if (post.id == comment.postId) {
                comments += comment
                isPostExists = true
            }
        }

        if (!isPostExists) throw PostNotFoundException()
    }

    fun addReportComment(reportComment: ReportComment) {
        var isReportCommentExists = false

        if (reportComment.reason !in 0..8) throw FalseReasonException()
        for (post in posts) {
            if (post.id == reportComment.postId) {
                reportsComment += reportComment
                isReportCommentExists = true
            }
        }
        if (!isReportCommentExists) throw PostNotFoundException()
    }


}

