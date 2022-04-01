package attachments

sealed class Attachment {
    open val type: String = " "

    data class AudioAttachment(val audio: Audio) : Attachment() {
        override val type: String = "audio"
    }

    data class DocAttachment(val doc: Doc) : Attachment() {
        override val type: String = "doc"
    }

    data class LinkAttachment(val link: Link) : Attachment() {
        override val type: String = "link"
    }

    data class PhotoAttachment(val photo: Photo) : Attachment() {
        override val type: String = "photo"
    }

    data class VideoAttachment(val video: Video) : Attachment() {
        override val type: String = "video"
    }

}
