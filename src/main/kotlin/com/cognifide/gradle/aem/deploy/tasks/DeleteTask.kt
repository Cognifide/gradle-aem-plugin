package com.cognifide.gradle.aem.deploy.tasks

import com.cognifide.gradle.aem.AemPlugin
import org.gradle.api.tasks.TaskAction

open class DeleteTask : AbstractTask() {

    companion object {
        val NAME = "aemDelete"
    }

    init {
        group = AemPlugin.TASK_GROUP
        description = "Deletes AEM package on instance(s)."
    }

    @TaskAction
    fun install() {
        deploy({ sync ->
            ensureUserAwareness(NAME)

            deletePackage(determineRemotePackagePath(sync), sync)
        })
    }

}
