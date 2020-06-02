# Terminator Language (featured by [RPG](https://github.com/c0stra/rpg))
[![Released version](https://img.shields.io/maven-central/v/foundation.fluent.api/terminator.svg)](https://search.maven.org/#search%7Cga%7C1%7Cterminator)
[![Build Status](https://travis-ci.org/c0stra/terminator.svg?branch=master)](https://travis-ci.org/c0stra/terminator)

```java
When (Arnold) steels (aBike),
then fun begins.
```

Terminator language is yet another JVM language with syntax, that allows to write sentences like in real english.
The purpose is to be able to write human readable and descriptive code, with main usage in areas, where this is
important. E.g. automated testing.

It's small features.

Operator `.` for member selection is totally avoided. Member access is simply like this `object member`

Instead `.` is used to terminate a statement (sentence). Hence this operator is called _Terminator_. Object may respond
to this operator by implementing `Terminator` interface, which makes the language very powerful. Therefore it gave the
name to the language.

There is another operator `,` called _Separator_. It's allowed only at top level expression. It doesn't terminate
an expression, but objects may also respond to it by implementing interface `Separator`.

Method call still uses the same feature as member select. So your code may look like this (see cucumber syntax
implemented)

```java
When (user) enters username ("admin") and password ("p@ssw0rD"),
then (application) displays ("Welcome admin").
```
