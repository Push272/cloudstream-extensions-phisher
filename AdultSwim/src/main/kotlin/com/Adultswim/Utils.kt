package com.lagradost.cloudstream3.adultswim

import org.jsoup.nodes.Document
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object AdultSwimUtils {
        const val BASE = "https://www.adultswim.com"

            /** Make a possibly-relative href absolute using the site base. */
                fun makeAbsolute(href: String?): String? {
                            if (href.isNullOrBlank()) return null
                                    return if (href.startsWith("http")) href else (BASE + if (href.startsWith("/")) href else "/$href")
                }

                    /** URL-encode a query string safely. */
                        fun encodeQuery(q: String): String = URLEncoder.encode(q, StandardCharsets.UTF_8.toString())

                            /** Extract the first regex group match, or null. */
                                fun extractFirst(regex: String, input: String): String? {
                                            val r = regex.toRegex()
                                                    val m = r.find(input) ?: return null
                                                            return if (m.groupValues.size > 1) m.groupValues[1] else m.value
                                }

                                    /** Safe helper to get trimmed text of the first element matching selector. */
                                        fun Document.selectFirstText(selector: String): String? {
                                                    return this.selectFirst(selector)?.text()?.trim()
                                        }

                                            /** Build a search URL for AdultSwim search endpoint. */
                                                fun buildSearchUrl(query: String): String = "$BASE/search?q=${encodeQuery(query)}"

                                                    /** Return filename-friendly string from url (useful for caching/logging). */
                                                        fun urlToFilename(url: String): String {
                                                                    return try {
                                                                                    val u = URL(url)
                                                                                                val path = u.path.replace("/", "_").trim('_')
                                                                                                            val query = if (u.query != null) "_${u.query.hashCode()}" else ""
                                                                                                                        "${u.host}_${path}${query}"
                                                                    } catch (e: Exception) {
                                                                                    url.hashCode().toString()
                                                                    }
                                                        }
}
                                                                    }
                                                                    }
                                                        }
                                        }
                                }
                }
}