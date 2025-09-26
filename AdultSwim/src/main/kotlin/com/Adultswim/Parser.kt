package com.lagradost.cloudstream3.adultswim

import com.lagradost.cloudstream3.*
import org.jsoup.Jsoup

object AdultSwimParser {

        fun parseMainPage(html: String): List<VideoInfo> {
                    val doc = Jsoup.parse(html)
                            val cards = doc.select(".show-card, .card, figure a")
                                    return cards.mapNotNull { el ->
                                                val a = el.selectFirst("a") ?: el
                                                            val href = a.attr("href")
                                                                        val fullUrl = if (href.startsWith("http")) href else "https://www.adultswim.com$href"
                                                                                    val title = a.attr("title").ifEmpty { a.text() }
                                                                                                val img = a.selectFirst("img")?.attr("src") ?: a.attr("data-src")
                                                                                                            if (title.isNullOrBlank() || fullUrl.isNullOrBlank()) return@mapNotNull null
                                                                                                                        VideoInfo(
                                                                                                                                            title = title.trim(),
                                                                                                                                                            url = fullUrl,
                                                                                                                                                                            posterUrl = if (!img.isNullOrBlank()) (if (img.startsWith("http")) img else "https://www.adultswim.com$img") else null
                                                                                                                        )
                                    }
        }

            fun parseSearch(html: String): List<SearchResponse> {
                        val doc = Jsoup.parse(html)
                                val items = doc.select(".search-result a, .card a")
                                        return items.mapNotNull { el ->
                                                    val a = el.selectFirst("a") ?: el
                                                                val href = a.attr("href")
                                                                            val fullUrl = if (href.startsWith("http")) href else "https://www.adultswim.com$href"
                                                                                        val title = a.attr("title").ifEmpty { a.text() }
                                                                                                    val img = a.selectFirst("img")?.attr("src")
                                                                                                                if (title.isNullOrBlank() || fullUrl.isNullOrBlank()) return@mapNotNull null
                                                                                                                            SearchResponse(title = title.trim(), url = fullUrl, posterUrl = img)
                                                                                                                                    }
            }

                fun parseLoadPage(html: String, pageUrl: String): LoadResponse {
                            val doc = Jsoup.parse(html)
                                    val title = doc.selectFirst("h1, .title, .show-title")?.text()?.trim() ?: "Unknown"
                                            val poster = doc.selectFirst("meta[property=og:image]")?.attr("content")
                                                    val episodeElements = doc.select(".episode, .episode-list li a, .episodes a[href*='episode']")

                                                            val episodes = episodeElements.mapIndexed { idx, el ->
                                                                        val a = el.selectFirst("a") ?: el
                                                                                    val href = a.attr("href")
                                                                                                val epUrl = if (href.startsWith("http")) href else "https://www.adultswim.com$href"
                                                                                                            val epTitle = a.text().ifEmpty { a.attr("title") }
                                                                                                                        Episode(
                                                                                                                                            name = epTitle.ifEmpty { "Episode ${idx + 1}" },
                                                                                                                                                            url = epUrl
                                                                                                                        )
                                                            }

                                                                    return LoadResponse(
                                                                                    name = title,
                                                                                                posterUrl = poster,
                                                                                                            url = pageUrl,
                                                                                                                        type = if (episodes.isEmpty()) LoadResponse.TYPE_VIDEO else LoadResponse.TYPE_SERIES,
                                                                                                                                    episodes = episodes
                                                                    )
                }
}
                                                                    )
                                                                                                                        )}
                }
            }
                                                                                                                        )}
        }
}