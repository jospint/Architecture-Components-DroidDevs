package com.jospint.droiddevs.architecturecomponents.util

class Resource<T> private constructor(val resourceStatus: ResourceStatus, val data: T?, val message: String?) {
    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(ResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ResourceStatus.ERROR, data, msg)
        }

        fun <T> loading(msg: String? = null): Resource<T> {
            return Resource(ResourceStatus.LOADING, null, msg)
        }

    }
}
