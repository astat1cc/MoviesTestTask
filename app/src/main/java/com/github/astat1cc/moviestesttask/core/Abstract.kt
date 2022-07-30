package com.github.astat1cc.moviestesttask.core

abstract class Abstract {

    /**
     * object that is mapping to T by M mapper
     */
    interface Object<T, M : Mapper> {

        fun map(mapper: M): T
    }

    interface Mapper {

        class Empty: Mapper
    }
}