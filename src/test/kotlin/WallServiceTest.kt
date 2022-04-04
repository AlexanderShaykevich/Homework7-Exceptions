import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addNew() {
        val service = WallService()
        val examplePost = Post(0,1, 1, 1, 100, "Text", 1,
        1, 1, null, null, null, null, null, " ",
        null, null, null, 1, null, true, true, true,
        false, false, null, 1)
        val expected = 1

        val result = service.add(examplePost).id

        assertEquals(expected, result)
    }

    @Test
    fun updateExistingTrue() {
        val service = WallService()
        service.add(Post(0,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        val update = Post(1,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1)

        val result = service.update(update)

        assertTrue(result)

    }

    @Test
    fun updateExistingFalse() {
        val service = WallService()
        service.add(Post(0,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        val update = Post(15,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1)

        val result = service.update(update)

        assertFalse(result)
    }


    @Test(expected = PostNotFoundException::class)
    fun shouldThrowByCreatingPost() {
        val service = WallService()
        service.add(Post(0,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        service.createComment(Comment(1, 10,1,1," ", null, true, " ",
            1, 1, null, null, null))
    }


    @Test
    fun shouldNotThrowByCreatingPost() {
        val service = WallService()
        service.add(Post(0,1, 1, 1, 100, "Text1", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        service.createComment(Comment(1, 1,1,1," ", null, true, " ",
            1, 1, null, null, null))

        val expected = true
        val result = service.comments.isNotEmpty()

        assertEquals(expected, result)
    }

    @Test(expected = FalseReasonException::class)
    fun shouldThrowByAddingReportCommentWrongReason() {
        val service = WallService()
        service.add(Post(1,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        service.addReportComment(ReportComment(1,10))

    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowByAddingReportCommentWrongId() {
        val service = WallService()
        service.add(Post(1,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        service.addReportComment(ReportComment(10,5))

    }

    @Test
    fun shouldNotThrowByAddingReportComment() {
        val service = WallService()
        service.add(Post(1,1, 1, 1, 100, "Text", 1,
            1, 1, null, null, null, null, null, " ",
            null, null, null, 1, null, true, true, true,
            false, false, null, 1))

        service.addReportComment(ReportComment(1,5))

    }

}