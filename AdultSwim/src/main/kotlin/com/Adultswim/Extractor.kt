package com.lagradost.cloudstream3.adultswim

import com.lagradost.cloudstream3.utils.ExtractorLink
import org.jsoup.Jsoup

object AdultSwimExtractor {
        fun extractLinks(html: String): List<ExtractorLink> {
                    val result = mutableListOf<ExtractorLink>()
                            val doc = Jsoup.parse(html)

                                    // Look through scripts for m3u8 or mp4 links
                                            val scripts = doc.select("script")
                                                    scripts.forEach { s ->
                                                                val text = s.html()
                                                                            if (text.contains("m3u8")) {
                                                                                                val regex = "(https?:\\\\/\\\\/[^\"]+?\\.m3u8[^\"]*)".toRegex()
                                                                                                                regex.findAll(text).forEach { match ->
                                                                                                                                    result.add(ExtractorLink("HLS", match.groupValues[1], "hls"))
                                                                                                                                                    }
                                                                            }
                                                                                        if (text.contains(".mp4")) {
                                                                                                            val regex = "(https?:\\\\/\\\\/[^\"]+?\\.mp4[^\"]*)".toRegex()
                                                                                                                            regex.findAll(text).forEach { match ->
                                                                                                                                                result.add(ExtractorLink("MP4", match.groupValues[1], ""))
                                                                                                                                                                }
                                                                                        }
                                                    }

                                                            return result
        }
}
                                                                                        }
                                                                            }}
        }
}