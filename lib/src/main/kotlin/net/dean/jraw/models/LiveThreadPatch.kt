package net.dean.jraw.models

import net.dean.jraw.filterValuesNotNull

/**
 * Immutable data class used when creating or updating a live thread
 */
data class LiveThreadPatch(
    /** Thread description */
    val description: String? = null,

    /** Is the content only suitable for viewers 18+? */
    val nsfw: Boolean? = null,

    /** Any additional resources provided by the moderators of the thread */
    val resources: String? = null,

    /** Thread title */
    val title: String? = null
) {
    private constructor(b: Builder) : this(
        description = b.description,
        nsfw = b.nsfw,
        resources = b.resources,
        title = b.title
    )

    internal fun toRequestMap(): Map<String, String> = mapOf(
        "api_type" to "json",
        "description" to description,
        "nsfw" to nsfw?.toString(),
        "resources" to resources,
        "title" to title
    ).filterValuesNotNull()

    /** Builder pattern for [LiveThreadPatch] */
    class Builder {
        internal var description: String? = null
        internal var nsfw: Boolean? = null
        internal var resources: String? = null
        internal var title: String? = null

        /** Sets the description */
        fun description(description: String?): Builder { this.description = description; return this }

        /** Sets if the thread is NSFW */
        fun nsfw(nsfw: Boolean?): Builder { this.nsfw = nsfw; return this }

        /** Sets the resources */
        fun resources(resources: String?): Builder { this.resources = resources; return this }

        /** Sets the title */
        fun title(title: String?): Builder { this.title = title; return this }

        /** Transforms this builder into an immutable [LiveThreadPatch] */
        fun build() = LiveThreadPatch(this)
    }
}
