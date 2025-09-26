package com.lagradost.cloudstream3.adultswim

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.api.*
import com.lagradost.cloudstream3.utils.ExtractorLink

class AdultSwimProvider : MainAPI() {
        override var mainUrl = "https://www.adultswim.com"
            override var name = "AdultSwim"
                override val lang = "en"
                    override val hasQuickSearch = true
                        override val hasMainPage = true

                            private val showsPath = "/shows"

                                override suspend fun getMainPage(type: Int, page: Int, filters: String?): List<VideoInfo> {
                                            val html = app.get(mainUrl + showsPath).text
                                                    return AdultSwimParser.parseMainPage(html)
                                }

                                    override suspend fun search(query: String): List<SearchResponse> {
                                                val html = app.get("$mainUrl/search?q=${query.encodeURL()}").text
                                                        return AdultSwimParser.parseSearch(html)
                                    }

                                        override suspend fun load(url: String): LoadResponse {
                                                    val html = app.get(url).text
                                                            return AdultSwimParser.parseLoadPage(html, url)
                                        }

                                            override suspend fun loadLinks(
                                                        data: String,
                                                                isCasting: Boolean,
                                                                        subtitleCallback: (SubtitleFile) -> Unit
                                            ): List<ExtractorLink> {
                                                        val html = app.get(data).text
                                                                return AdultSwimExtractor.extractLinks(html)
                                            }

                                                private fun String.encodeURL(): String = java.net.URLEncoder.encode(this, "UTF-8")
}
                                            }
                                            )
                                        }
                                    }
                                }
}