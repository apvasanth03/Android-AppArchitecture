# Modularization - Why we should care

<!-- TOC -->

* [Modularization - Why we should care](#modularization---why-we-should-care)
    * [Speeds up builds](#speeds-up-builds)
    * [Experiment with new technologies](#experiment-with-new-technologies)
    * [Scale development teams](#scale-development-teams)
    * [Other Benefits](#other-benefits)

<!-- TOC -->

Modularization Architecture has the following benefits

- Speeds up builds
- Experiment with new technologies
- Scale development teams

Let’s investigate these benefits more in depth.

## Speeds up builds

Highly simplified, Gradle does two things to speed up builds:

1. Cache work it did before so it doesn’t have to do it again
2. Try to do as much work as possible in parallel

Both of these strategies aren’t effective for single module apps as every code change, makes it
impossible to reuse the already generated (cached) compiled code artifact and hence all code has to
be recompiled again sequentially.

With multiple modules, however, Gradle can build several modules in parallel and avoid building
modules that have no code changed it already has a cached artifact for. This speeds up your
incremental builds and even your clean builds.

## Experiment with new technologies

<img src="./pics/experimenting_with_new_technology.png" />

The Android landscape is evolving at a rapid pace: just few years ago we didn’t have Kotlin,
Jetpack, Architecture components, Navigation components, … and that’s just the official Google
stuff!

How on earth can we keep up with that in our app, Because making the wrong technology or
architecture choice could haunt us for several months or even years!

Again modularisation comes in to save the day. What if we just contain the new tech/architecture to
a single module? That makes integrating the technology (e.g. KMM) a lot easier and we can
experience the full benefits of the technology by converting an entire module end to end. Hence we
can rapidly experiment and if the choice turns out not to work for us, it won’t be that much work
to revert it.

Enabling experimentation with new technologies isn’t the only benefit. Modules also help to avoid
technology lock-in! What if we go all in react native and Facebook pulls official support?
Containing technology choices to modules gives us room to see how a technology matures before going
all in.

## Scale development teams

The more people that work on a code base, the more files will be modified concurrently causing a
hell of merge conflicts. And let’s face it, every conflict you solve is like flipping a coin hoping
it falls on the right side, so regression is a real issue here.

Again modularisation softens the blow because if we split your app in a smart way, we can delegate
the ownership of particular feature modules to particular teams/people. Completely avoiding
concurrent modifications, or at least limiting those problems to a smaller set of modules.

## Other Benefits

- Simplify development
- Enables refactoring

