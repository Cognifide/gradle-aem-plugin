package com.cognifide.gradle.aem.common.instance.service.repository

import com.cognifide.gradle.aem.common.instance.InstanceService
import com.cognifide.gradle.aem.common.instance.InstanceSync

class Repository(sync: InstanceSync) : InstanceService(sync) {

    internal val http = RepositoryHttpClient(aem, instance)

    /**
     * Take care about property value types saved in repository.
     */
    var typeHints: Boolean = true

    /**
     * Controls throwing exceptions in case of response statuses indicating repository errors.
     * Switching it to false, allows custom error handling in task scripting.
     */
    var verbose: Boolean
        get() = http.responseChecks
        set(value) {
            http.responseChecks = value
        }

    fun node(path: String): Node {
        return Node(this, path)
    }

    fun <T> node(path: String, options: Node.() -> T): T = node(path).run(options)

    fun node(path: String, properties: Map<String, Any?>): RepositoryResult = node(path).save(properties)
}