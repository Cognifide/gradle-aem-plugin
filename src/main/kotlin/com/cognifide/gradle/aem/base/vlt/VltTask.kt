package com.cognifide.gradle.aem.base.vlt

import com.cognifide.gradle.aem.base.api.AemDefaultTask
import org.gradle.api.tasks.TaskAction

open class VltTask : AemDefaultTask() {

    companion object {
        val NAME = "aemVlt"
    }

    init {
        description = "Execute any Vault command."
    }

    @TaskAction
    fun perform() {
        val command = project.properties["aem.vlt.command"] as String?
        if (command.isNullOrBlank()) {
            throw VltException("Vault command cannot be blank.")
        }

        VltCommand(project).raw(command!!)
    }

}