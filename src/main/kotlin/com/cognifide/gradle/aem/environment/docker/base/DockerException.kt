package com.cognifide.gradle.aem.environment.docker.base

import com.cognifide.gradle.aem.common.AemException

open class DockerException : AemException {

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(message: String) : super(message)
}
