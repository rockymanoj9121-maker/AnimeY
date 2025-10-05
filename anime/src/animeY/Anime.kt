package eu.kanade.tachiyomi.animeextension.en.animey

import eu.kanade.tachiyomi.animesource.online.ParsedAnimeHttpSource
import eu.kanade.tachiyomi.network.GET
import okhttp3.Request
import org.jsoup.nodes.Element

class AnimeY : ParsedAnimeHttpSource() {

    override val name = "AnimeY"
    override val baseUrl = "https:en8.pornhd8k.me"
    override val lang = "en"
    override val supportsLatest = true

    override fun popularAnimeRequest(page: Int): Request = GET(baseUrl)
    override fun popularAnimeSelector(): String = "div"
    override fun popularAnimeFromElement(element: Element) = throw Exception("Parser not implemented")
    override fun popularAnimeNextPageSelector(): String? = null

    override fun episodeListSelector(): String = "div"
    override fun episodeFromElement(element: Element) = throw Exception("Parser not implemented")

    override fun videoListSelector(): String = "div"
    override fun videoFromElement(element: Element) = throw Exception("Parser not implemented")

    override fun searchAnimeRequest(page: Int, query: String, filters: Any?): Request =
        GET("$baseUrl/search?keyword=$query")
}
