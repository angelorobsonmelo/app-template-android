package br.com.soluevo.www.application.util.extensions

fun Int.notEqual(comparator: Int): Boolean {
    return this != comparator
}

fun Int.isEqual(comparator: Int): Boolean {
    return this == comparator
}