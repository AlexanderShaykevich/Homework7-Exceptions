
//import WallService.attachments

fun main() {

    val service = WallService()

    service.add(Post(0,1, 1, 1, 100, "Text", 1,
        1, 1, null, null, null, null, null, " ",
        null, null, null, 1, null, true, true, true,
        false, false, null, 1))

    service.add(Post(0,1, 1, 1, 100, "Text", 1,
        1, 1, null, null, null, null, null, " ",
        null, null, null, 1, null, true, true, true,
        false, false, null, 1))



    service.createComment(Comment(1, 2,1,1," ", null, true, " ",
        1, 1, null, null, null))

    println(service.posts.forEach { println(it) })
    println(service.comments.forEach { println(it) })
    println(service.count)

    service.addReportComment(ReportComment(1,5))




}


